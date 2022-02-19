/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contains.duplicate.ii;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class ContainsDuplicateII {

    /**
     * @param args the command line arguments
     */
    
//    -----------------------------ALTERNATE---------------------------------
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int i=0; i<nums.length; i++) {
//            Integer v = map.put(nums[i], i);
//            if(v!=null) {
//                if(i-v<=k) return true;
//            }
//        }
//        return false;
//    }
    
    
//    -----------------------------ALTERNATE---------------------------------
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Set<Integer> set=new HashSet<>();
//        for(int i=0; i<nums.length; i++) {
//            if(i>k) {
//                set.remove(nums[i-k-1]);
//            }
//            if (set.contains(nums[i])) return true;
//            set.add(nums[i]);
//        }
//        return false;
//    }
    
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            Integer v=map.put(nums[i], i);
            if(v!=null && (i-v)<=k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    
    public static void main(String[] args) {
        ContainsDuplicateII c=new ContainsDuplicateII();
        System.out.println(c.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
        System.out.println(c.containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(c.containsNearbyDuplicate(new int[]{99,99}, 2));
        System.out.println(c.containsNearbyDuplicate(new int[]{2,2}, 3));
        System.out.println(c.containsNearbyDuplicate(new int[]{1,2,3,4,5,6,7,8,9,9}, 3));
        System.out.println(c.containsNearbyDuplicate(new int[]{1}, 1));
    }
}
