package MultiThreading.ThreadPools;

import java.util.ArrayList;
import java.util.List;

/**
 * A bounded blocking queue that selects the next task by highest effective
 * priority at the moment of dequeue, not at the moment of enqueue.
 *
 * Why ArrayList instead of PriorityQueue:
 *   PriorityQueue fixes the heap ordering once at offer() time. Because
 *   getEffectivePriority() can return a different value every call (e.g.
 *   aging adds +1 per second of waiting), the heap would be permanently
 *   stale. A linear scan at deQueue() re-evaluates every waiting task's
 *   priority right now, so aging and any other dynamic signals are always
 *   reflected correctly.
 *
 * Complexity trade-off:
 *   enQueue – O(1) amortised (ArrayList.add)
 *   deQueue – O(n) linear scan; acceptable for bounded n (= queue limit)
 *
 * Blocking behaviour (unchanged from original):
 *   – enQueue blocks the caller when the queue is at capacity.
 *   – deQueue blocks the caller when the queue is empty.
 *
 * Fairness tiebreaker:
 *   Among tasks with equal effective priority at dequeue time, the one with
 *   the smaller sequenceNumber (submitted earlier) is chosen – FIFO fairness.
 */
class CustomBlockingQueue {

    private final List<PrioritizedTask> queue = new ArrayList<>();
    private final int limit;

    CustomBlockingQueue(int limit) {
        this.limit = limit;
    }

    synchronized void enQueue(PrioritizedTask item) throws InterruptedException {
        while (this.queue.size() == this.limit)
            wait();
        if (this.queue.isEmpty())
            notifyAll();
        this.queue.add(item);
    }

    synchronized PrioritizedTask deQueue() throws InterruptedException {
        while (this.queue.isEmpty())
            wait();
        if (this.queue.size() == this.limit)
            notifyAll();

        // Re-evaluate every task's effective priority right now and pick the best.
        PrioritizedTask best = queue.get(0);
        for (PrioritizedTask candidate : queue) {
            int candidateEp = candidate.getEffectivePriority();
            int bestEp      = best.getEffectivePriority();
            if (candidateEp > bestEp
                    || (candidateEp == bestEp && candidate.sequenceNumber < best.sequenceNumber)) {
                best = candidate;
            }
        }
        queue.remove(best);
        return best;
    }
}
