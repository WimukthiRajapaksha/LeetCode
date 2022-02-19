/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two.sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }
        return new int[2];
    }
}

public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] list1 = new int[]{2,7,11,15};
        int[] list2 = new int[]{3,2,4};
        int[] list3 = new int[]{3,3};
        System.out.println(solution.twoSum(list1, 9));
        System.out.println(solution.twoSum(list2, 6));
        System.out.println(solution.twoSum(list3, 6));
    }
    
}
