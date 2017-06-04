package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kislay on 2/17/17 at 12:36 PM .
 */
public class ListTest {
    public static void main(String[] args) {
	List<String> dataList = new ArrayList<>();
	for (String data:dataList) {
	    data = data.concat("hello");
	    System.out.println(data);
	}
    }
}
