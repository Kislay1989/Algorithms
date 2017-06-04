package MultiThreading.DeadLock;

/**
 * Created by kislay on 5/26/17 at 12:08 PM .
 */
public class Runnable1 implements Runnable {

    private final String data1;
    private final String data2;

    Runnable1(String data1, String data2)
    {
	this.data1 = data1;
	this.data2 = data2;
    }

    @Override public void run()
    {
	synchronized (data1) {
	    System.out.println("Inside Runnable 1");
	    try {
		Thread.sleep(10);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    System.out.println("Waiting for thread 2");
	    synchronized (data2) {
		System.out.println("Inside core");
	    }
	}
    }
}
