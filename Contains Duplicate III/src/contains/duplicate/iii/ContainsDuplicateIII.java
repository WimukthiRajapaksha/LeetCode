/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contains.duplicate.iii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class ContainsDuplicateIII {

    /**
     * @param args the command line arguments
     */
    
//    -------------------------OPTIMAL -> O(N) -> O(1)--------------------------
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k==0) return false;
        Map<Long, Long> map=new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            long temp=position((long)nums[i]-Integer.MIN_VALUE, (long)t+1);
            if(map.containsKey(temp)) return true;
            if(map.containsKey(temp-1) && Math.abs(nums[i]-map.get(temp-1))<=(long)t) return true;
            if(map.containsKey(temp+1) && Math.abs(nums[i]-map.get(temp+1))<=(long)t) return true;
            map.put(temp, (long)nums[i]);
            if(i>=k) map.remove(position((long)nums[i-k]-Integer.MIN_VALUE, (long)t+1));
        }
        return false;
    }
    
    private long position(long i, long l) {
        return i/l;
    }
    
    
//    -------------------------OPTIMAL -> ONE LINE CONDITION OF ABOVE -> O(N) -> O(1)--------------------------
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        if(k==0) return false;
//        Map<Long, Long> map=new HashMap<>();
//        for(int i=0; i<nums.length; i++) {
//            long temp=position((long)nums[i]-Integer.MIN_VALUE, (long)t+1);
//            if((map.containsKey(temp)) || (map.containsKey(temp-1) && Math.abs(nums[i]-map.get(temp-1))<=(long)t) || (map.containsKey(temp+1) && Math.abs(nums[i]-map.get(temp+1))<=(long)t)) return true;
//            map.put(temp, (long)nums[i]);
//            if(i>=k) map.remove(position((long)nums[i-k]-Integer.MIN_VALUE, (long)t+1));
//        }
//        return false;
//    }
//    
//    private long position(long i, long l) {
//        return i/l;
//    }
    
    
    
//    -----------------------------NOT OPTIMAL-----------------------------------
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        Set<Long> set=new HashSet<>();
//        for(int i=0; i<nums.length; i++) {
//            if(i>k) {
//                set.remove((long)nums[i-k-1]);
//            }
//            if(check(set, nums[i], t)) return true;
//            set.add((long)nums[i]);
//        }
//        return false;
//    }
//    
//    private boolean check(Set<Long> set, long i, long t) {
//        for(long j=i-t; j<=i+t; j++) {
//            if(set.contains(j)) return true;
//        }
//        return false;
//    }
    
    
//    -------------------------NOT OPTIMAL -> BRUTE FORCE--------------------------
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        for(int i=0; i<nums.length-1; i++) {
//            for(int j=i+1; j<Math.min(nums.length, i+k+1); j++) {
//                if(Math.abs((long)nums[i]-nums[j])<=t) return true;
//            }
//        }
//        return false;
//    }
    
    public static void main(String[] args) {
        ContainsDuplicateIII c=new ContainsDuplicateIII();
        System.out.println(c.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
        System.out.println(c.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
        System.out.println(c.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
        System.out.println(c.containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647}, 1, 1));
        System.out.println(c.containsNearbyAlmostDuplicate(new int[]{2147483647,-1,2147483647}, 1, 2147483647));
    }
}

