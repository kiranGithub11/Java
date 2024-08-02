//https://leetcode.com/problems/contains-duplicate/description/

import java.util.Arrays;
import java.util.HashSet;


public class ContainsDuplicate {
	// solution 1
	static boolean containsDuplicate1(int[] nums) {
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	// solution 2
	static boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		for(int i=0; i<nums.length-1; i++) {
			if(nums[i] == nums[i+1]) {
				return true;
			}
		}
		return false;
	}
	
    // solution 3 -- OPTIMAL --
	static boolean containsDuplicate3(int[] nums) {
		HashSet<Integer> hashset = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			if(hashset.contains(nums[i])) {
				return true;
			} else {
				hashset.add(nums[i]);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1}; // true
        // int[] nums1 = {1, 2, 3, 4}; // false
		System.out.println(containsDuplicate3(nums));
	}
}
