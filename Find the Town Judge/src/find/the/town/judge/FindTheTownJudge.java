/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.the.town.judge;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindTheTownJudge {

    /**
     * @param args the command line arguments
     */
    
//    ----------------OPTIMAL -> O(N), O(N)------------
//    public int findJudge(int n, int[][] trust) {
//        int[] indegree=new int[n];
//        int[] outdegree=new int[n];
//        for(int[] t: trust) {
//            indegree[t[1]-1]++;
//            outdegree[t[0]-1]++;
//        }
//        for(int i=0; i<n; i++) {
//            if(indegree[i]==n-1 && outdegree[i]==0) return i+1;
//        }
//        return -1;
//    }
    
    
//    ----------------OPTIMAL -> O(N), O(N)------------
    public int findJudge(int n, int[][] trust) {
        int[] degree=new int[n];
        for(int[] t: trust) {
            degree[t[1]-1]++;
            degree[t[0]-1]--;
        }
        for(int i=0; i<n; i++) {
            if(degree[i]==n-1) return i+1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        FindTheTownJudge f=new FindTheTownJudge();
        System.out.println(f.findJudge(2, new int[][]{{1,2}}));
        System.out.println(f.findJudge(3, new int[][]{{1,3},{2,3}}));
        System.out.println(f.findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
    }
}
