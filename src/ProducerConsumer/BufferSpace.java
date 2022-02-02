package ProducerConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kislay on 5/19/17 at 11:28 PM .
 */
public class BufferSpace {

    // buffer and its size
    private final int CAPACITY = 10;
    private final List<Integer> buffer = new LinkedList<>();
    private final Random random = new Random();

    // lock and condition variables
    private final Lock lock = new ReentrantLock();
    private final Condition bufferNotFull = lock.newCondition();
    private final Condition bufferNotEmpty = lock.newCondition();

    void putDataInBuffer() throws InterruptedException
    {
	lock.lock();
	try {
	    while (buffer.size() == CAPACITY) {
		System.out.println(Thread.currentThread().getName() + " : Buffer is full, " +
				"waiting");
		bufferNotEmpty.await();
	    }

	    int number = random.nextInt();
	    buffer.add(number);
	    System.out.println(
			    Thread.currentThread().getName() + " added " + number + " in buffer");
	    System.out.println(Thread.currentThread().getName() +
			    " signalling that buffer is no more empty now");
	    bufferNotFull.signalAll();
	} finally {
	    lock.unlock();
	}
    }

    void consumeDataFromBuffer() throws InterruptedException
    {
	lock.lock();
	try {
	    while (buffer.size() == 0) {
		System.out.println(
				Thread.currentThread().getName() + " : Buffer is empty, waiting");
		bufferNotFull.await();
	    }

	    Integer value = buffer.get(0);
	    if (value != null) {
		System.out.printf("%s consumed %d from queue %n", Thread.currentThread().getName(),
				value);
		System.out.println(Thread.currentThread().getName() +
				" : Signalling that buffer may be empty now");
		bufferNotEmpty.signalAll();
	    }
	} finally {
	    lock.unlock();
	}
    }
}
