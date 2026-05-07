package algoPatterns.topKElements;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s with lowercase repeated characters, the task is to rearrange characters in a string so that no two adjacent characters are the same.
 * If it is not possible to do so, then print empty string ("").
 */
public class RearrangeString {

    public static void main(String[] args) {
        String s = "aaabc";
        String res = rearrangeString(s);
        System.out.println(res);

        String s2 = "aa";
        String res2 = rearrangeString(s2);
        System.out.println(res2);


    }


    public static String rearrangeString2(String data) {
        int len = data.length();
        int maxCount = 0;
        char c = '#';

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = data.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            if (freq.get(ch) > maxCount) {
                maxCount = freq.get(ch);
                c = ch;
            }
        }

        int ind = 0;
        char[] res = data.toCharArray();
        while (maxCount > 0) {
            res[ind] = c;
            ind += 2;
            maxCount--;
        }

        freq.put(c, 0);


    }

    // O(n*log n) Time and O(n) Space
    public static String rearrangeString(String data) {
        int len = data.length();
        StringBuilder res = new StringBuilder();

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : data.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(freq.entrySet());

        Map.Entry<Character, Integer> prev = new AbstractMap.SimpleEntry<>('#', -1);
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> p = pq.poll();
            res.append(p.getKey());

            if (prev.getValue() > 0)
                pq.add(prev);

            prev = new AbstractMap.SimpleEntry<>(p.getKey(), p.getValue() - 1);
        }

        if (res.length() != len)
            return "";

        return res.toString();
    }
}
