/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------------ALTERNATE---------------------------
//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> list=new ArrayList<>();
//        for(int i=0; i<nums.length-2; i++) {
//            if(i==0 || (i>0 && nums[i-1]!=nums[i])) {
//                int val=-nums[i];
//                int low=i+1;
//                int high=nums.length-1;
//                
//                while(low<high) {
//                    if(nums[low]+nums[high]==val) {
//                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
//                        while(low<high && nums[low]==nums[low+1]) low++;
//                        while(low<high && nums[high]==nums[high-1]) high--;
//                        low++;
//                        high--;
//                    } else if(nums[low]+nums[high]<val) {
//                        low++;
//                    } else {
//                        high--;
//                    }
//                }
//            }
//        }
//        return list;
//    }
    
    
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            if(i==0 || (i>0 && nums[i-1]!=nums[i])) {
                int val=-nums[i];
                if(val<0) return list;
                int low=i+1;
                int high=nums.length-1;
                
                while(low<high) {
                    if(nums[low]+nums[high]==val) {
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        low++;
                        high--;
                    } else if(nums[low]+nums[high]<val) {
                        while(low<high && nums[low]==nums[low+1]) low++;
                        low++;
                    } else {
                        while(low<high && nums[high]==nums[high-1]) high--;
                        high--;
                    }
                }
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        Main m=new Main();
        System.out.println(m.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(m.threeSum(new int[]{0,0,0}));
        System.out.println(m.threeSum(new int[]{0,0,0,0}));
    }
}
