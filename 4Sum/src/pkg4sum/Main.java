/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        int i=0;
        while(i<nums.length-3) {
            if((long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) {
                return list;
            }
            if((long)nums[i]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1]<target) {
                i++;
                continue;
            }
            int j=i+1;
            while(j<nums.length-2) {
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) {
                    break;
                }
                if(nums[i]+nums[j]+nums[nums.length-2]+nums[nums.length-1]<target) {
                    j++;
                    continue;
                }
                int b=j+1;
                int e=nums.length-1;
                while(b<e) {
                    int v=nums[i]+nums[j]+nums[b]+nums[e];
                    if(v==target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[b], nums[e]));
                        while(b<e && nums[b]==nums[b+1]) b++;
                        b++;
                        while(b<e && nums[e]==nums[e-1]) e--;
                        e--;
                    } else if (v>target) {
                        while(b<e && nums[e]==nums[e-1]) e--;
                        e--;
                    } else {
                        while(b<e && nums[b]==nums[b+1]) b++;
                        b++;
                    }
                }
                while(j+1<nums.length-2 && nums[j+1]==nums[j]) j++;
                j++;
            }
            while(i+1<nums.length-3 && nums[i+1]==nums[i]) i++;
            i++;
        }
        return list;
    }
    
    
    
    
//    --------------------ALTERNATE -> ABOVE IS WITH SMALL OPTIMIZATION-----------
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        List<List<Integer>> list=new ArrayList<>();
//        int i=0;
//        while(i<nums.length-3) {
//            int j=i+1;
//            while(j<nums.length-2) {
//                int b=j+1;
//                int e=nums.length-1;
//                while(b<e) {
//                    int v=nums[i]+nums[j]+nums[b]+nums[e];
//                    if(v==target) {
//                        list.add(Arrays.asList(nums[i], nums[j], nums[b], nums[e]));
//                        while(b<e && nums[b]==nums[b+1]) b++;
//                        b++;
//                        while(b<e && nums[e]==nums[e-1]) e--;
//                        e--;
//                    } else if (v>target) {
//                        while(b<e && nums[e]==nums[e-1]) e--;
//                        e--;
//                    } else {
//                        while(b<e && nums[b]==nums[b+1]) b++;
//                        b++;
//                    }
//                }
//                j++;
//                while(j<nums.length-2 && nums[j]==nums[j-1]) j++;
//            }
//            i++;
//            while(i<nums.length-3 && nums[i]==nums[i-1]) i++;
//        }
//        return list;
//    }
    
    public static void main(String[] args) {
        Main m=new Main();
//        System.out.println(m.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
//        System.out.println(m.fourSum(new int[]{2,2,2,2,2}, 8));
//        System.out.println(m.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0));
        System.out.println(m.fourSum(new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000}, 1000000000));
    }
}


