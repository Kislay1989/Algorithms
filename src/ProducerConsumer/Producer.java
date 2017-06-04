package ProducerConsumer;

/**
 * Created by kislay on 5/19/17 at 11:56 PM .
 */
public class Producer extends Thread {
    private final BufferSpace buffer;

    Producer(BufferSpace buffer)
    {
	super("PRODUCER");
	this.buffer = buffer;
    }

    @Override
    public void run()
    {
	try {
	    buffer.putDataInBuffer();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
}
