/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package total.cost.to.hire.k.workers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author wimukthirajapaksha
 */
public class TotalCostToHireKWorkers {

    /**
     * @param args the command line arguments
     */
    
    public long totalCost(int[] costs, int k, int candidates) {
        if(k==0) return 0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((int[] o1, int[] o2) -> {
            if(o1[0]==o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        for(int i=0; i<candidates; i++) {
            pq.offer(new int[]{costs[i], -1});
        }
        for(int i=Math.max(costs.length-candidates, candidates); i<costs.length; i++) {
            pq.offer(new int[]{costs[i], 1});
        }
        int l=candidates;
        int r=costs.length-1-candidates;
        long total=0;
        while(k>0) {
            int[] temp=pq.poll();
            total+=temp[0];
            k--;
            if(l>r) continue;
            if(temp[1]<0) {
                pq.offer(new int[]{costs[l++], -1});
            } else if(temp[1]>0) {
                pq.offer(new int[]{costs[r--], 1});
            }
        }
        return total;
    }
    
    public static void main(String[] args) {
        TotalCostToHireKWorkers t=new TotalCostToHireKWorkers();
        System.out.println(t.totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
        System.out.println(t.totalCost(new int[]{1,2,4,1}, 3, 3));
        System.out.println(t.totalCost(new int[]{31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58}, 11, 2));
    }
}
