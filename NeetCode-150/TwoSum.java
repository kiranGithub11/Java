// https://leetcode.com/problems/two-sum/description/

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // solution 1
    static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    // solution 2 -- Two Pointer Approach -- 
    static int[] twoSum1(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;

        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum == target) {
                return new int[] {start, end};
            } else if(sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[] {-1, -1};
    }

    // solution 3 -- OPTIMAL --
    static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashmap.containsKey(complement)) {
                return new int[] {hashmap.get(complement), i};
            }
            hashmap.put(nums[i], i);
        }
        
        return new int[] {-1, -1}; // No solution found
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum2(arr, target)));
    }
}
