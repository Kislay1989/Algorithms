package MultiThreading.SynchronousOperation;

/**
 * Created by kislay on 5/25/17 at 9:51 PM .
 */
public class OddNumberRead implements Runnable {

    private final int[] arrData;

    private static ThreadLocal<Integer> count = new ThreadLocal<>();

    OddNumberRead(int[] arrData)
    {
	this.arrData = arrData;
    }

    @Override public void run()
    {
	Integer index = count.get();
	if (index == null)
	    index = 0;
	int length = arrData.length;

	synchronized (arrData) {
	    while (index < length) {
		int data = arrData[index];
		if (data % 2 != 0)
		    System.out.println(data);
		count.set(++index);
		arrData.notify();
		try {
		    arrData.wait();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	    arrData.notify();
	}
    }
}
