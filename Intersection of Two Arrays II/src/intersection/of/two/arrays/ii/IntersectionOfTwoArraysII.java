/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intersection.of.two.arrays.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class IntersectionOfTwoArraysII {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> map=new HashMap<>();
        for(int i: nums1) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        System.out.println(map);
        List<Integer> list=new ArrayList<>();
        for(int i: nums2) {
            if(map.containsKey(i) && map.get(i)>0) {
                list.add(i);
                map.put(i, map.get(i)-1);
            }
        }
        int[] re=new int[list.size()];
        int j=0;
        for(int i: list) {
            re[j++]=i;
        }
        return re;
    }
    
    
    
    
//    --------------------ALTERNATE------------------
//    public int[] intersect(int[] nums1, int[] nums2) {
//        int[] a=new int[1001];
//        for(int i: nums1) {
//            a[i]++;
//        }
//        List<Integer> l=new ArrayList<>();
//        for(int i: nums2) {
//            if(a[i]>0) {
//                l.add(i);
//                a[i]--;
//            }
//        }
//        int[] r=new int[l.size()];
//        for(int i=0; i<l.size(); i++) {
//            r[i]=l.get(i);
//        }
//        return r;
//    }
    
    public static void main(String[] args) {
        IntersectionOfTwoArraysII i=new IntersectionOfTwoArraysII();
        i.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
    }
}