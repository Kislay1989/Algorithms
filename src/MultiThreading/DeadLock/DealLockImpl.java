package MultiThreading.DeadLock;

/**
 * Created by kislay on 5/26/17 at 12:05 PM .
 */
public class DealLockImpl {

    private static final String data1 = "Hello";
    private static final String data2 = "Done";

    public static void main(String[] args)
    {
	Runnable run1 = new Runnable1(data1, data2);
	Runnable run2 = new Runnable2(data1, data2);

	Thread t1 = new Thread(run1);
	Thread t2 = new Thread(run2);

	t1.start();
	t2.start();
    }
}
