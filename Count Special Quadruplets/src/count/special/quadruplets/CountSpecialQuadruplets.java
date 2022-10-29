/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.special.quadruplets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountSpecialQuadruplets {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------------OPTIMAL -> O(N^2)----------------------------
    public int countQuadruplets(int[] nums) {
        int c=0;
        int[] arr=new int[301];
        arr[nums[nums.length-1]-nums[nums.length-2]+100]=1;
        for(int i=nums.length-3; i>=0; i--) {
            for(int j=i-1; j>=0; j--) {
                c+=arr[nums[j]+nums[i]+100];
            }
            for(int j=nums.length-1; j>i; j--) {
                if(nums[j]-nums[i]>=0) {
                    arr[nums[j]-nums[i]+100]++;
                }
            }
        }
        return c;
    }
    
    
//    -------------OPTIMAL -> ALTERNATE -> BETTER TO USE A ARRAY INSTEAD OF MAP -> O(N^2)--------------
//    public int countQuadruplets(int[] nums) {
//        int c=0;
//        Map<Integer, Integer> map=new HashMap<>();
//        map.put(nums[nums.length-1]-nums[nums.length-2], 1);
//        for(int i=nums.length-3; i>=0; i--) {
//            for(int j=i-1; j>=0; j--) {
//                c+=map.getOrDefault(nums[j]+nums[i], 0);
//            }
//            for(int j=nums.length-1; j>i; j--) {
//                map.put(nums[j]-nums[i], map.getOrDefault(nums[j]-nums[i], 0)+1);
//            }
//        }
//        System.out.println(map);
//        return c;
//    }
    
    
//    --------------------ALTERNATE -> O(N^3)----------------------------
//    public int countQuadruplets(int[] nums) {
//        int[] arr=new int[301];
//        int c=0;
//        arr[nums[nums.length-1]] = 1;
//        for(int i=nums.length-2; i>=2; i--) {
//            for(int j=i-1; j>=1; j--) {
//                for(int k=j-1; k>=0; k--) {
//                    c+=arr[nums[i]+nums[j]+nums[k]];
//                }
//            }
//            arr[nums[i]]++;
//        }
//        return c;
//    }
    
    
    
//    --------------------ALTERNATE -> O(N^4)----------------------------
//    public int countQuadruplets(int[] nums) {
//        int c=0;
//        for(int i=0; i<nums.length-3; i++) {
//            for(int j=i+1; j<nums.length-2; j++) {
//                for(int k=j+1; k<nums.length-1; k++) {
//                    for(int l=k+1; l<nums.length; l++) {
//                        if(nums[l]==nums[i]+nums[j]+nums[k]) {
//                            c++;
//                        }
//                    }
//                }
//            }
//        }
//        return c;
//    }
    
    
    public static void main(String[] args) {
        CountSpecialQuadruplets c=new CountSpecialQuadruplets();
        System.out.println(c.countQuadruplets(new int[]{1,2,3,6}));
        System.out.println(c.countQuadruplets(new int[]{3,3,6,4,5}));
        System.out.println(c.countQuadruplets(new int[]{1,1,1,3,5}));
        System.out.println(c.countQuadruplets(new int[]{1,1,1,3,}));
    }
}
