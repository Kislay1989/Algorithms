package MultiThreading.ThreadPools;

/**
 * Created by kislay on 5/28/17 at 4:30 PM .
 */
class WorkerThread extends Thread {

    private final String name;
    private final CustomBlockingQueue taskQueue;
    private boolean isStopped = false;

    WorkerThread(String name, CustomBlockingQueue taskQueue) {
        this.name = name;
        this.taskQueue = taskQueue;
    }

    public void run() {
        while (!this.isStopped) {
            try {
                System.out.println("Thread :" + name + " is working");
                Runnable runnable = (Runnable) taskQueue.deQueue();
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void doStop() {
        this.isStopped = true;
        System.out.println("Thread :" + name + " is being stopped");
        //break pool thread out of dequeue() call
        this.interrupt();
    }
}
