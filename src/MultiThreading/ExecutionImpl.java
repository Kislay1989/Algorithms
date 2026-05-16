package MultiThreading;

import MultiThreading.ThreadPools.CustomThreadPool;

import java.util.Random;

/**
 * Created by kislay on 5/28/17 at 10:46 PM .
 */
public class ExecutionImpl {

    public static void main(String[] args) {
        CustomThreadPool threadPool = new CustomThreadPool(5, 10);
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            Runnable runnable = new RunnableTask(random.nextInt(10), "Thread :" + i);
            try {
                threadPool.execute(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        threadPool.stop();
    }
}
