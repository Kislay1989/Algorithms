package testcode;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.io.StringWriter;


/**
 * Created by kislay on 2/15/17 at 5:33 PM .
 */
public class HtmlParser {
    public static void main(String[] args) {

        try {
	    String data = "<html><head><title>Email for Rating Mapping</title></head><body><p><b>Dear " +
		"Team,</b></p><p>Please refer the following fields for which mapping needs to be done " +
		"at DB level -</p><p>1.) Rating</p><p>RAT</p><p>2.) Health Status</p><p>HS</p><p>3.) " +
		"Product</p><p>PROD</p><p><b>Regards,</b></p><p><b>InforcePro Team" +
		".</b></p></body></html>";

	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document doc = builder.parse(new InputSource(new StringReader(data)));
	    XPath xPath = XPathFactory.newInstance().newXPath();
	    String expression = "/html/body/p[6]";
	    NodeList nodes = (NodeList)xPath.evaluate(expression, doc.getDocumentElement(), XPathConstants.NODESET);
	    Node text = nodes.item(0);
	    String rat = "Not Applicable";
	    text.getFirstChild().setTextContent(rat);
	    doc.getDocumentElement().getNodeValue();
	    //System.out.println(doc.getTextContent());

	    NodeList list = doc.getChildNodes();
	    Node n = list.item(0);
	    String res = getInnerHTML(n);

	    System.out.println(res);

	}
	catch (Exception exc)
	{
	    System.out.println(exc.getMessage());
	}
    }

    public static String getInnerHTML(Node node) throws TransformerConfigurationException, TransformerException
    {
	StringWriter sw = new StringWriter();
	Result result = new StreamResult(sw);
	TransformerFactory factory = new net.sf.saxon.TransformerFactoryImpl();
	Transformer proc = factory.newTransformer();
	proc.setOutputProperty(OutputKeys.METHOD, "html");
	for (int i = 0; i < node.getChildNodes().getLength(); i++)
	{
	    proc.transform(new DOMSource(node.getChildNodes().item(i)), result);
	}
	return sw.toString();
    }
}
