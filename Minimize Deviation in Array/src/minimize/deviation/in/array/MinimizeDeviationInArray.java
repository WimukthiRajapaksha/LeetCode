/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimize.deviation.in.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimizeDeviationInArray {

    /**
     * @param args the command line arguments
     */
    
//    ----------OPTIMAL -> O(N LOGN), O(N)------------------
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o2, o1));
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==1) nums[i]*=2;
            pq.offer(nums[i]);
            min=Math.min(min, nums[i]);
        }
        int diff=Integer.MAX_VALUE;
        while(pq.peek()%2==0) {
            int max=pq.poll();
            diff=Math.min(diff, max-min);
            min=Math.min(max/2, min);
            pq.offer(max/2);
        }
        return Math.min(diff, pq.peek()-min);
    }
    
    public static void main(String[] args) {
        MinimizeDeviationInArray m=new MinimizeDeviationInArray();
        System.out.println(m.minimumDeviation(new int[]{1,2,3,4})==1);
        System.out.println(m.minimumDeviation(new int[]{4,1,5,20,3})==3);
        System.out.println(m.minimumDeviation(new int[]{2,10,8})==3);
        System.out.println(m.minimumDeviation(new int[]{3,5})==1);
        System.out.println(m.minimumDeviation(new int[]{10,4,3})==2);
    }
}
