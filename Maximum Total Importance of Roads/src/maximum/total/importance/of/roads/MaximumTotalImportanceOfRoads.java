/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.total.importance.of.roads;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumTotalImportanceOfRoads {

    /**
     * @param args the command line arguments
     */
    
    public long maximumImportance(int n, int[][] roads) {
        int[] indegree=new int[n];
        for(int[] i: roads) {
            indegree[i[0]]++;
            indegree[i[1]]++;
        }
        Arrays.sort(indegree);
        long count=0;
        for(int i=0; i<indegree.length; i++) {
            count+=(indegree[i]*(long)(i+1));
        }
        return count;
    }
    
    public static void main(String[] args) {
        MaximumTotalImportanceOfRoads m=new MaximumTotalImportanceOfRoads();
        System.out.println(m.maximumImportance(5, new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
        System.out.println(m.maximumImportance(5, new int[][]{{0,3},{2,4},{1,3}}));
    }
}
