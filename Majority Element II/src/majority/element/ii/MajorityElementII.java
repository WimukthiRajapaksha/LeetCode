/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majority.element.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class MajorityElementII {

    /**
     * @param args the command line arguments
     */
    
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int first=Integer.MIN_VALUE;
        int firstCount=0;
        int second=Integer.MIN_VALUE;
        int secondCount=0;
        for(int i: nums) {
            if(first==i) {
                firstCount++;
            } else if(second==i) {
                secondCount++;
            } else if (firstCount==0) {
                first=i;
                firstCount=1;
            } else if(secondCount==0) {
                second=i;
                secondCount=1;
            } else {
                firstCount--;
                secondCount--;
            }
        }
        int tempFirst=0;
        int tempSecond=0;
        for(int i: nums) {
            if(first==i) {
                tempFirst++;
            }
            if(second==i) {
                tempSecond++;
            }
        }
        if(tempFirst>nums.length/3) list.add(first);
        if(tempSecond>nums.length/3) list.add(second);
        return list;
    }
    
    
//    public List<Integer> majorityElement(int[] nums) {
//        List<Integer> list=new ArrayList<>();
//        int first=Integer.MIN_VALUE;
//        int firstCount=0;
//        int second=Integer.MIN_VALUE;
//        int secondCount=0;
//        for(int i: nums) {
//            if(first==i) {
//                firstCount++;
//            } else if(second==i) {
//                secondCount++;
//            } else if (firstCount==0) {
//                first=i;
//                firstCount=1;
//            } else if(secondCount==0) {
//                second=i;
//                secondCount=1;
//            } else {
//                firstCount--;
//                secondCount--;
//            }
//        }
//        if(eligible(nums, first)) list.add(first);
//        if(eligible(nums, second)) list.add(second);
//        return list;
//    }
//    
//    private boolean eligible(int[] arr, int v) {
//        int c=0;
//        for(int i: arr) {
//            if(i==v) c++;
//        }
//        return c>arr.length/3;
//    }
    
    
    
//    public List<Integer> majorityElement(int[] nums) {
//        List<Integer> list=new ArrayList<>();
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int i: nums) {
//            map.put(i, map.getOrDefault(i, 0)+1);
//        }
//        for(int i: map.keySet()) {
//            if(map.get(i)>nums.length/3) {
//                list.add(i);
//            }
//        }
//        return list;
//    }
    
    public static void main(String[] args) {
        MajorityElementII m=new MajorityElementII();
        System.out.println(m.majorityElement(new int[]{3,2,3}));
        System.out.println(m.majorityElement(new int[]{1}));
        System.out.println(m.majorityElement(new int[]{1,2}));
        System.out.println(m.majorityElement(new int[]{1,2,3,1,2,2,1,2,1,1,2,4}));
        System.out.println(m.majorityElement(new int[]{1,2,1,2,1,3,1,2,3,4}));
    }
}
