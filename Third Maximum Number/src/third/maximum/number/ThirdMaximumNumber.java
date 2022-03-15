/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package third.maximum.number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class ThirdMaximumNumber {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------OPTIMAL -> STILL WONDERING HOW THIS IS WORKING---------------
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            if(nums[i]!=Integer.MIN_VALUE && (nums[i]==first||nums[i]==second||nums[i]==third))
                continue;
            if(nums[i]>first){                
                third=second;
                second=first;
                first=nums[i];                
            } else if(nums[i]>second){
                third=second;
                second=nums[i];                  
            } else if(nums[i]>third){
                third=nums[i];                   
            }
            count++;
        }
        if(count<3)return first;
        else return third;
    }
    
    
//    --------------------OPTIMAL -> MIND BLOWING APPROACH--------------------
//    public int thirdMax(int[] nums) {
//        Integer a=null;
//        Integer b=null;
//        Integer c=null;
//        
//        for(Integer i: nums) {
//            if(i.equals(a) || i.equals(b) || i.equals(c)) continue;
//            if(a==null || a<i) {
//                c=b;
//                b=a;
//                a=i;
//            } else if(b==null || b<i) {
//                c=b;
//                b=i;
//            } else if(c==null || c<i) {
//                c=i;
//            }
//        }
//        if(c==null) c=a;
//        return c;
//    }
    
    
//    ----------------NOT OPTIMAL -> CHILDISH SOLUTION------------------------
//    public int thirdMax(int[] nums) {
//        int a=Integer.MIN_VALUE;
//        int b=Integer.MIN_VALUE;
//        int c=Integer.MIN_VALUE;
//        Set<Integer> set=new HashSet<>();
//        for(int i: nums) {
//            if(set.add(i)) {
//                if(a<i) {
//                    c=b;
//                    b=a;
//                    a=i;
//                } else if(b<i && i<a) {
//                    c=b;
//                    b=i;
//                } else if(c<i && i<b) {
//                    c=i;
//                }
//            }
//        }
//        if(set.size()<3) c=a;
//        return c;
//    }
    
    public static void main(String[] args) {
        ThirdMaximumNumber t=new ThirdMaximumNumber();
        System.out.println(t.thirdMax(new int[]{3,2,1}));
        System.out.println(t.thirdMax(new int[]{2,2,3,1}));
        System.out.println(t.thirdMax(new int[]{1,2,-2147483648}));
        System.out.println(t.thirdMax(new int[]{-2147483648,-2147483648,-2147483648,-2147483648,1,1,1}));
    }
}
