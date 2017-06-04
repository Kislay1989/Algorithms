package MultiThreading.DeadLock;

/**
 * Created by kislay on 5/26/17 at 12:10 PM .
 */
public class Runnable2 implements Runnable {

    private final String data1;
    private final String data2;

    Runnable2(String data1, String data2)
    {
	this.data1 = data1;
	this.data2 = data2;
    }

    @Override public void run()
    {
	synchronized (data2) {
	    System.out.println("Inside Runnable2");
	    try {
		Thread.sleep(10);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    System.out.println("Waiting for thread 1");
	    synchronized (data1) {
		System.out.println("inside core 2");
	    }
	}
    }
}
