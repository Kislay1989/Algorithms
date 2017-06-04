package ProducerConsumer;

/**
 * Created by kislay on 5/20/17 at 12:01 AM .
 */
public class Consumer extends Thread {
    private final BufferSpace buffer;

    Consumer(BufferSpace buffer)
    {
	super("CONSUMER");
	this.buffer = buffer;
    }

    @Override
    public void run()
    {
	try {
	    buffer.consumeDataFromBuffer();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
}
