/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.provinces;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOfProvinces {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------OPTIMAL -> DFS -> O(N^2), O(N)-------------
//    public int findCircleNum(int[][] isConnected) {
//        boolean[] visited=new boolean[isConnected.length];
//        int count=0;
//        for(int i=0; i<isConnected.length; i++) {
//            if(!visited[i]) {
//                count++;
//                dfs(visited, isConnected, i);
//            }
//        }
//        return count;
//    }
//    
//    private void dfs(boolean[] visited, int[][] isConnected, int i) {
//        if(visited[i]) return;
//        visited[i]=true;
//        for(int j=0; j<isConnected.length; j++) {
//            if(i!=j && isConnected[i][j]==1) dfs(visited, isConnected, j);
//        }
//    }
    
    
    
//    ------------OPTIMAL -> DFS -> O(N^2), O(N)-----------------------
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited=new boolean[isConnected.length];
        int count=0;
        for(int i=0; i<isConnected.length; i++) {
            if(!visited[i]) {
                count++;
                bfs(visited, isConnected, i);
            }
        }
        return count;
    }
    
    private void bfs(boolean[] visited, int[][] isConnected, int i) {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(i);
        while(!queue.isEmpty()) {
            int t=queue.poll();
            for(int j=0; j<isConnected.length; j++) {
                if(isConnected[t][j]==1 && t!=j && !visited[j]) {
                    queue.offer(j);
                    visited[j]=true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        NumberOfProvinces n=new NumberOfProvinces();
        System.out.println(n.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(n.findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
        System.out.println(n.findCircleNum(new int[][]{{1}}));
    }
}
