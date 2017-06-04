package testcode;

/**
 * Created by kislay on 2/21/17 at 12:49 AM .
 */
public class FinallyTest {
    public static void main(String[] args)
    {
	try{
	    String data = "abc";
	    int len = 0;
	    Integer length = len;
	    System.out.println(data.length());
	    System.out.println(length);
	}
	catch (Exception ex)
	{
	    System.out.println("Inside exception");
	}
	finally {
	    System.out.println("Hello Exception");
	}
    }
}
