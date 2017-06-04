package MultiThreading.ThreadPools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kislay on 5/27/17 at 11:44 PM .
 */
public class CustomThreadPool {

    private CustomBlockingQueue taskQueue;
    private List<WorkerThread> workerThreads = new ArrayList<>();
    private boolean isStopped = false;

    public CustomThreadPool(int noOfWorkerThreads, int maxNoOfTasks)
    {
	taskQueue = new CustomBlockingQueue(maxNoOfTasks);

	for (int i = 0; i < noOfWorkerThreads; i++)
	    workerThreads.add(new WorkerThread("Worker " + i, taskQueue));

	for (WorkerThread worker : workerThreads)
	    worker.start();
    }

    public synchronized void execute(Runnable task) throws InterruptedException
    {
	if (this.isStopped)
	    throw new IllegalStateException("Thread Pool is stopped");

	this.taskQueue.enQueue(task);
    }

    public synchronized void stop()
    {
	this.isStopped = true;
	for (WorkerThread worker : workerThreads)
	    worker.doStop();
    }
}
