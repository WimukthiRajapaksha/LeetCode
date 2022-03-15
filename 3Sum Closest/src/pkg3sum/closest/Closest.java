/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3sum.closest;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class Closest {

    /**
     * @param args the command line arguments
     */
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int temp;
        int diff=4000;
        int answer=0;
        int i=0;
        while(i<nums.length-2) {
            int b=i+1;
            int e=nums.length-1;
            while(b<e) {
                temp=nums[b]+nums[e]+nums[i];
                if(target==temp) {
                    return target;
                } else if(target>temp) {
                    if(target-temp<diff) {
                        diff=target-temp;
                        answer=temp;
                    }
                    while(b<e && nums[b]==nums[b+1]) b++;
                    b++;
                } else {
                    if(temp-target<diff) {
                        diff=temp-target;
                        answer=temp;
                    }
                    while(b<e && nums[e]==nums[e-1]) e--;
                    e--;
                }
            }
            i++;
            if(i>0 && nums[i]==nums[i-1]) i++;
        }
        return answer;
    }
    
    
    
//    ---------------------ALTERNATE----------------------
//    public int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
//        int temp;
//        int diff=Integer.MAX_VALUE/2;
//        int answer=0;
//        for(int i=0; i<nums.length-2; i++) {
//            int b=i+1;
//            int e=nums.length-1;
//            while(b<e) {
//                temp=nums[b]+nums[e]+nums[i];
//                if(target==temp) {
//                    return target;
//                } else if(target>temp) {
//                    if(target-temp<diff) {
//                        diff=target-temp;
//                        answer=temp;
//                    }
//                    while(b<e && nums[b]==nums[b+1]) b++;
//                    b++;
//                } else {
//                    if(temp-target<diff) {
//                        diff=temp-target;
//                        answer=temp;
//                    }
//                    while(b<e && nums[e]==nums[e-1]) e--;
//                    e--;
//                }
//            }
//        }
//        return answer;
//    }
    
    
//    ---------------------ALTERNATE----------------------
//    public int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
//        int ret=Integer.MAX_VALUE/2;
//        int temp;
//        for(int i=0; i<nums.length-2; i++) {
//            int b=i+1;
//            int e=nums.length-1;
//            while(b<e) {
//                temp=nums[b]+nums[e]+nums[i];
//                if(target==temp) {
//                    return target;
//                } else if(target>temp) {
//                    if(Math.abs(target-ret)>Math.abs(target-temp)) {
//                        ret=temp;
//                    }
//                    b++;
//                } else {
//                    if(Math.abs(target-ret)>Math.abs(target-temp)) {
//                        ret=temp;
//                    }
//                    e--;
//                }
//            }
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        Closest c=new Closest();
        System.out.println(c.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(c.threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1));
        System.out.println(c.threeSumClosest(new int[]{-1,0,1,1,55}, 3));
        System.out.println(c.threeSumClosest(new int[]{1,1,1,0}, 100));
        System.out.println(c.threeSumClosest(new int[]{-111,-111,3,6,7,16,17,18,19}, 13));
        System.out.println(c.threeSumClosest(new int[]{-100,-98,-2,-1}, -101));
    }
}
