package testcode;

/**
 * Created by kislay on 4/27/17 at 9:16 PM .
 */
public class Child extends Parent {

    public static void main(String[] args)
    {
	Child c = new Child();
	c.print();
    }

    private void print()
    {
        this.printSoomething();
    }

    public void printSoomething()
    {
	System.out.println("inside child");
    }
}
