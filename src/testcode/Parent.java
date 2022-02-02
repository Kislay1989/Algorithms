package testcode;

/**
 * Created by kislay on 4/27/17 at 9:12 PM .
 */
public class Parent {

    public static void main(String[] args)
    {
	Parent p = new Parent();
	p.printSoomething();
    }

    private final void printSoomething()
    {
	System.out.println("Inside parent");
    }
}
