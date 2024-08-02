// https://leetcode.com/problems/group-anagrams/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashmap = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);

            if (!hashmap.containsKey(sortedStr)) {
                hashmap.put(sortedStr, new ArrayList<>());
            }
            hashmap.get(sortedStr).add(s);
        }

        return new ArrayList<>(hashmap.values());
    }
}
