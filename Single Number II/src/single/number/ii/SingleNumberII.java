/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single.number.ii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class SingleNumberII {

    /**
     * @param args the command line arguments
     */
    
    public int singleNumber(int[] nums) {
        int ones=0;
        int twos=0;
        for(int i: nums) {
            if((ones&i)==i) {
                if((twos&i)!=i) {
                    ones+=i;
                }
            }
            if((twos&i)==i) {
                if((ones&i)!=i) {
                    twos+=i;
                }
            }
        }
        return ones;
    }
    
    
    
    
//    public int singleNumber(int[] nums) {
//        int ones=0;
//        int twos=0;
//        for(int i: nums) {
//            ones=(ones^i)&(~twos);
//            twos=(twos^i)&(~ones);
//            System.out.println(ones+" "+twos);
//        }
//        return ones;
//    }
    
    
    
//    public int singleNumber(int[] nums) {
//        int answer=0;
//        for(int i=0; i<32; i++) {
//            int s=0;
//            for(int j: nums) {
//                s+=((j>>>i)&1);
//            }
//            s%=3;
//            answer=answer|(s<<i);
//        }
//        return answer;
//    }
    
    
    
//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int i: nums) {
//            map.put(i, map.getOrDefault(i, 0)+1);
//        }
//        for(int i: map.keySet()) {
//            if(map.get(i)==1) {
//                return i;
//            }
//        }
//        return -1;
//    }
    
    
    
//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        int i=0;
//        while(i+1<nums.length) {
//            if(nums[i]!=nums[i+1]) {
//                return nums[i];
//            }
//            i+=3;
//        }
//        return nums[nums.length-1];
//    }
    
    
    
    public static void main(String[] args) {
        SingleNumberII s=new SingleNumberII();
        System.out.println(s.singleNumber(new int[]{0,1,0,1,0,1,99}));
        System.out.println(s.singleNumber(new int[]{2,2,3,2}));
        System.out.println(s.singleNumber(new int[]{30000,500,100,30000,100,30000,100}));
    }
}
