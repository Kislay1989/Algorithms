package MultiThreading.ThreadPools;

/**
 * Internal envelope that pairs a Runnable with its scheduling metadata.
 *
 * sequenceNumber    – monotonically increasing submission counter used as a
 *                    fairness tiebreaker: among tasks of equal effective
 *                    priority, the one submitted earlier is dequeued first.
 *
 * getEffectivePriority() – delegates to the task at call time so that
 *                          dynamic signals (e.g. aging in RunnableTask) are
 *                          always evaluated fresh when the WorkerThread picks
 *                          the next task, never at enqueue time.
 */
class PrioritizedTask {

    final Runnable task;
    final long sequenceNumber;

    PrioritizedTask(Runnable task, long sequenceNumber) {
        this.task = task;
        this.sequenceNumber = sequenceNumber;
    }

    int getEffectivePriority() {
        if (task instanceof PriorityAware)
            return ((PriorityAware) task).getEffectivePriority();
        return 0;
    }
}
