package MultiThreading.ThreadPools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Fixed-size thread pool with priority scheduling and FIFO fairness.
 *
 * Priority  – if a submitted Runnable implements PriorityAware its priority
 *             value is used; otherwise it is treated as priority 0.
 * Fairness  – tasks with identical priority are executed in submission order
 *             thanks to a monotonically increasing sequence counter.
 */
public class CustomThreadPool {

    private final CustomBlockingQueue taskQueue;
    private final List<WorkerThread> workerThreads = new ArrayList<>();
    private boolean isStopped = false;
    private final AtomicLong sequenceCounter = new AtomicLong(0);

    public CustomThreadPool(int noOfWorkerThreads, int maxNoOfTasks) {
        taskQueue = new CustomBlockingQueue(maxNoOfTasks);

        for (int i = 0; i < noOfWorkerThreads; i++)
            workerThreads.add(new WorkerThread("Worker " + i, taskQueue));

        for (WorkerThread worker : workerThreads)
            worker.start();
    }

    public synchronized void execute(Runnable task) throws InterruptedException {
        if (this.isStopped)
            throw new IllegalStateException("Thread Pool is stopped");

        // Priority is not captured here; PrioritizedTask.getEffectivePriority()
        // delegates to the task at dequeue time so aging is always current.
        this.taskQueue.enQueue(new PrioritizedTask(task, sequenceCounter.getAndIncrement()));
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (WorkerThread worker : workerThreads)
            worker.doStop();
    }
}
