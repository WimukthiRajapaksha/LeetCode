/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package destroy.sequential.targets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class DestroySequentialTargets {

    /**
     * @param args the command line arguments
     */
    
//    -----------OPTIMAL -> O(N), O(M)--------------
//    public int destroyTargets(int[] nums, int space) {
//        Map<Integer, Integer> map=new HashMap<>();
//        Set<Integer> set=new HashSet<>();
//        int max=Integer.MIN_VALUE;
//        for(int i: nums) {
//            int temp=map.getOrDefault(i%space, 0)+1;
//            map.put(i%space, temp);
//            if(temp>max) {
//                max=temp;
//                set.clear();
//            }
//            if(temp==max) {
//                set.add(i%space);
//            }
//        }
//        int ret=Integer.MAX_VALUE;
//        for(int i: nums) {
//            if(ret>i && set.contains(i%space)) ret=i;
//        }
//        return ret;
//    }
    
    
//    -----------OPTIMAL -> O(N), O(M)--------------
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int i: nums) {
            int temp=map.getOrDefault(i%space, 0)+1;
            map.put(i%space, temp);
            if(temp>max) {
                max=temp;
            }
        }
        int ret=Integer.MAX_VALUE;
        for(int i: nums) {
            if(ret>i && max==map.get(i%space)) ret=i;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        DestroySequentialTargets d=new DestroySequentialTargets();
        System.out.println(d.destroyTargets(new int[]{3,7,8,1,1,5}, 2));
        System.out.println(d.destroyTargets(new int[]{1,3,5,2,4,6}, 2));
        System.out.println(d.destroyTargets(new int[]{6,2,5}, 100));
        System.out.println(d.destroyTargets(new int[]{1,5,3,2,2}, 10000));
        System.out.println(d.destroyTargets(new int[]{625879766,235326233,250224393,501422042,683823101,948619719,680305710,733191937,182186779,353350082}, 4));
    }
}
