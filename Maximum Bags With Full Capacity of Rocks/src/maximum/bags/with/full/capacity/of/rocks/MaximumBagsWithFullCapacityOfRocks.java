/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.bags.with.full.capacity.of.rocks;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumBagsWithFullCapacityOfRocks {

    /**
     * @param args the command line arguments
     */
    
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for(int i=0; i<capacity.length; i++) {
            capacity[i]-=rocks[i];
        }
        Arrays.sort(capacity);
        if(capacity[0]>additionalRocks) return 0;
        for(int i=1; i<capacity.length; i++) {
            capacity[i]+=capacity[i-1];
            if(capacity[i]>additionalRocks) return i;
        }
        return capacity.length;
    }
    
    public static void main(String[] args) {
        MaximumBagsWithFullCapacityOfRocks m=new MaximumBagsWithFullCapacityOfRocks();
        System.out.println(m.maximumBags(new int[]{2,3,4,5}, new int[]{1,2,4,4}, 2));
    }
}
