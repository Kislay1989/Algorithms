package ProducerConsumer;

/**
 * Created by kislay on 5/20/17 at 12:04 AM .
 */
public class ProducerConsumerImpl {

    public static void main(String[] args)
    {
	BufferSpace buffer = new BufferSpace();

	Producer producer = new Producer(buffer);
	Consumer consumer = new Consumer(buffer);

	producer.start();
	consumer.start();
    }
}
