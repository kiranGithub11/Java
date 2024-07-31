// https://leetcode.com/problems/valid-anagram/description/

import java.util.Arrays;
import java.util.Hashtable;

public class ValidAnagram {

    // solution one -- OPTIMAL --
    static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0; i<arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // solution two
    static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr1.length; j++) {
                if(arr1[i] == arr2[j]) {
                    // we mark the matched character in arr2 as deleted by setting it to the null character '\0'
                    arr2[j] = '\0';
                    // We use break to exit the inner loop after finding a match, so we move on to the next character in arr1
                    break; 
                }
            }
        }
        for(char c : arr2) {
            if(c != '\0') {
                return false;
            }
        }
        return true;
    }

    // solution 3 
    static boolean isAnagram3(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        // create a hashtable
        Hashtable<Character, Integer> hashtable = new Hashtable<>();

        // adding all characters of arr1 to hashtable - frequency  
        for(int i=0; i<arr1.length; i++) {
            if(hashtable.containsKey(arr1[i])) {
                hashtable.put(arr1[i], hashtable.get(arr1[i]) + 1);
            } else {
                hashtable.put(arr1[i], 1);
            }
        }

        // deleting all characters - frequency of hashtable if arr2 chars is found in arr1
        for(int j=0; j<arr2.length; j++) {
            if(!hashtable.containsKey(arr2[j])) {
                return false;
            }
            int count = hashtable.get(arr2[j]);
            if(count == 1) {
                hashtable.remove(arr2[j]);
            } else {
                hashtable.put(arr2[j],  count - 1);
            }
        }

    // if empty true anagaram
        if(hashtable.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram3(s, t));
    }    
}
