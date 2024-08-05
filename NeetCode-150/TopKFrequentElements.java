// https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopKFrequentElements {

    // Solution 
    static int[] topKFrequent(int[] nums, int k) {

        // create a hashmap to store the each number frequencies
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        // adding numbers and their frequencies
        for(int num : nums) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }

        // creating a priority queue to sort based on their frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hashmap.get(o2) - hashmap.get(o1);
            }
        });

        
        pq.addAll(hashmap.keySet());

        // create a array to store top k frequent elements
        int[] topKFrequentEle = new int[k];

        for(int i=0; i<k; i++) {
            topKFrequentEle[i] = pq.poll(); // poll() method retrives and removes the head of the priority queue
        }

        return topKFrequentEle;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int k = scanner.nextInt();

        int[] result = topKFrequent(nums, k);

       System.out.println(Arrays.toString(result));
    }
}
