/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaters;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class Heaters {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------------------OPTIMAL -> MAX(O(N*LOGN), O(M*LOGN)), O(1)----------------------
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result=0;
        for(int h: houses) {
            int index=Arrays.binarySearch(heaters, h);
            if(index<0) {
                index=-(index+1);
                int dist1 = (index==0) ? Integer.MAX_VALUE : h-heaters[index-1];
                int dist2 = (index==heaters.length) ? Integer.MAX_VALUE : heaters[index] - h;
                result=Math.max(result, Math.min(dist1, dist2));
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Heaters h=new Heaters();
        System.out.println(h.findRadius(new int[]{1,2,3}, new int[]{2}));
        System.out.println(h.findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
        System.out.println(h.findRadius(new int[]{1,5}, new int[]{2}));
    }
}
