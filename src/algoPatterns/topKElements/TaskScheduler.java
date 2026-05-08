package algoPatterns.topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given tasks ['A','A','A','B','B','C'] and cooldown n=2, find minimum CPU cycles to schedule all tasks.
 * CPU has a cooldown period for each task. CPU can repeat a task only after at least K units of time has passed after it did same task last time.
 * It can perform other tasks in that time, can stay idle to wait for repeating that task.
 * <p>
 * Key insight: Schedule most frequent tasks first, then fill gaps with less frequent ones.
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freq.values());

        int cycles = 0;
        while (!maxHeap.isEmpty()) {

            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int count = maxHeap.poll();
                    if (count > 1) {

                    }
                }
            }
        }

        return cycles;
    }
}
