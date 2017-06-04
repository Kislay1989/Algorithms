package MultiThreading;

/**
 * Created by kislay on 5/28/17 at 10:46 PM .
 */
public class RunnableTask implements Runnable {

    private final String name;

    RunnableTask(String name)
    {
	this.name = name;
    }

    @Override public void run()
    {
	System.out.println("Thread : " + this.name + " is implemented.");
    }
}
