package string_array_matrix.String;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by kpandey on 6/26/17.
 */
public class StringEncoding {

    public static void main(String[] args) {
        String data = "GGGGGwww";
        String encoded = collapseString(data);
        System.out.println(encoded);

        int x = (int) Math.pow(2,39);
        System.out.println(x);
    }

    static String collapseString(String input) {
        if (input == null || input.trim().length() == 0)
            return "";

        Map<String, Integer> set = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            String data = input.substring(i, i + 1);
            int count = 1;
            if (set.containsKey(data))
                count = set.get(data) + 1;
            set.put(data, count);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : set.entrySet()) {
            String val = (String) entry.getKey();
            Integer cnt = (Integer) entry.getValue();
            sb.append(cnt);
            sb.append(val);
        }
        return sb.toString();
    }
}
