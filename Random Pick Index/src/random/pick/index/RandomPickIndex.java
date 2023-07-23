/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random.pick.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author wimukthirajapaksha
 */

//--------------------OPTIMAL -> O(N), O(N)--------------
//class Solution {
//    Map<Integer, List<Integer>> map;
//    Random rand;
//
//    public Solution(int[] nums) {
//        map=new HashMap<>();
//        for(int i=0; i<nums.length; i++) {
//            if(!map.containsKey(nums[i])) {
//                map.put(nums[i], new ArrayList<>());
//            }
//            map.get(nums[i]).add(i);
//        }
//        rand=new Random();
//    }
//    
//    public int pick(int target) {
//        int val=rand.nextInt(map.get(target).size());
//        return map.get(target).get(val);
//    }
//}


//--------------------OPTIMAL -> O(N), O(N)--------------
//class Solution {
//    int[] arr;
//    Random rand;
//
//    public Solution(int[] nums) {
//        this.arr=nums;
//        rand=new Random();
//    }
//    
//    public int pick(int target) {
//        int count=0;
//        int index=0;
//        for(int i=0; i<arr.length; i++) {
//            if(arr[i]!=target) continue;
//            count++;
//            if(rand.nextInt(count)==0) {
//                index=i;
//            }
//        }
//        return index;
//    }
//}


//--------------------OPTIMAL -> O(N), O(N)--------------
class Solution {
    int[] arr;
    Random rand;

    public Solution(int[] nums) {
        this.arr=nums;
        rand=new Random();
    }
    
    public int pick(int target) {
        while(true) {
            int temp=rand.nextInt(arr.length);
            if(arr[temp]==target) return temp;
        }
    }
}

public class RandomPickIndex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solution sol=new Solution(new int[]{1, 2, 3, 3, 3});
        System.out.println(sol.pick(3));
        System.out.println(sol.pick(1));
        System.out.println(sol.pick(3));
    }
}
