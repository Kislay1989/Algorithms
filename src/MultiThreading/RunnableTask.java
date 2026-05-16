package MultiThreading;

import MultiThreading.ThreadPools.PriorityAware;

/**
 * Created by kislay on 5/28/17 at 10:46 PM .
 */
public class RunnableTask implements Runnable, PriorityAware {

    private final int basePriority;
    private final String name;
    private final long createdTime;

    RunnableTask(int priority, String name) {
        this.basePriority = priority;
        this.name = name;
        this.createdTime = System.currentTimeMillis();
    }

    public int getBasePriority() {
        return basePriority;
    }

    @Override
    public int getEffectivePriority() {
        long waitingTimeMillis = System.currentTimeMillis() - createdTime;
        int agingBonus = (int) (waitingTimeMillis / 1000);
        return basePriority + agingBonus;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    @Override
    public void run() {
        System.out.println("Thread : " + this.name + " is implemented.");
    }
}
