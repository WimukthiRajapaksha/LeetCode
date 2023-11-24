/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.of.interesting.subarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountOfInterestingSubarrays {

    /**
     * @param args the command line arguments
     */
    
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> map=new HashMap<>();
        int prefCount=0;
        long count=0;
        map.put(0, 1l);
        for(int i=0; i<nums.size(); i++) {
            prefCount = (prefCount+(nums.get(i)%modulo == k ? 1 : 0))%modulo;
            int targetRem=(prefCount-k+modulo)%modulo;
            count+=map.getOrDefault(targetRem, 0l);
            map.put(prefCount, map.getOrDefault(prefCount, 0l)+1);
        }
        return count;
    }
    
    public static void main(String[] args) {
        CountOfInterestingSubarrays c=new CountOfInterestingSubarrays();
        System.out.println(c.countInterestingSubarrays(Arrays.asList(3,1,9,6), 3, 0));
    }
}
