/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two.sum.ii.input.array.is.sorted;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author wimukthirajapaksha
 */
public class TwoSumIIInputArrayIsSorted {

    /**
     * @param args the command line arguments
     */
    
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                // System.out.println(map.get(nums[i])+" "+i);
                return new int[]{map.get(numbers[i]), i+1};
            } else {
                map.put(target-numbers[i], i+1);
            }
        }
        return new int[2];
    }
    
    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted ts = new TwoSumIIInputArrayIsSorted();
        ts.twoSum(new int[]{1,3,4}, 6);
    }
}
