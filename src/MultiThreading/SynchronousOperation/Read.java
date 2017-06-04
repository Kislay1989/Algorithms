package MultiThreading.SynchronousOperation;

/**
 * Created by kislay on 5/25/17 at 10:06 PM .
 */
public class Read {

    public static void main(String[] args)
    {
	int[] data = { 2, 5, 7, 9, 10, 12, 14, 16, 17, 19, 20 };

	Runnable even = new EvenNumberRead(data);
	Runnable odd = new OddNumberRead(data);

	Thread t1 = new Thread(even);
	Thread t2 = new Thread(odd);

	t2.start();
	t1.start();
    }
}
