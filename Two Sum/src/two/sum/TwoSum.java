/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class TwoSum {

    /**
     * @param args the command line arguments
     */
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                System.out.println(map.get(nums[i])+" "+i);
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target-nums[i], i);
            }
        }
        return new int[]{};
    }
    
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        ts.twoSum(new int[]{3,2,4}, 6);
    }
}
