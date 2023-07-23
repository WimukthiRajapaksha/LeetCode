/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time.needed.to.inform.all.employees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class TimeNeededToInformAllEmployees {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------OPTIMAL -> DFS -> O(N), O(N)-------------------
//    class Tree {
//        List<Tree> sub;
//        int t;
//
//        public Tree(int t) {
//            sub=new ArrayList<>();
//            this.t=t;
//        }
//
//        @Override
//        public String toString() {
//            return " "+t;
//        }
//    }
//    
//    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//        Tree[] arr=new Tree[n];
//        for(int i=0; i<n; i++) {
//            arr[i]=new Tree(informTime[i]);
//        }
//        for(int i=0; i<manager.length; i++) {
//            if(manager[i]!=-1) {
//                arr[manager[i]].sub.add(arr[i]);
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//        return dfs(arr[headID], informTime, 0);
//    }
//    
//    public int dfs(Tree h, int[] times, int t) {
//        int max=t;
//        for(Tree tree: h.sub) {
//            max=Math.max(max, dfs(tree, times, t+h.t));
//        }
//        return max;
//    }
    
    
//    --------------OPTIMAL -> DFS -> O(N), O(N)-------------------
//    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//        List<Integer>[] arr=new ArrayList[n];
//        for(int i=0; i<n; i++) {
//            arr[i]=new ArrayList<>();
//        }
//        for(int i=0; i<n; i++) {
//            if(manager[i]!=-1) arr[manager[i]].add(i);
//        }
//        System.out.println(Arrays.toString(arr));
//        return dfs(headID, arr, informTime, 0);
//    }
//    
//    public int dfs(int h, List<Integer>[] tree, int[] times, int t) {
//        int max=0;
//        for(int i: tree[h]) {
//            max=Math.max(max, dfs(i, tree, times, t+times[h]));
//        }
//        return max+t;
//    }
    
    
    
    
//    --------------OPTIMAL -> DFS -> BOTTOM-UP -> O(N), O(N)-------------------
//    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//        int ret=0;
//        for(int i=0; i<n; i++) {
//            ret=Math.max(ret, dfs(i, manager, informTime));
//        }
//        return ret;
//    }
//    
//    private int dfs(int i, int[] manager, int[] informTime) {
//        if(manager[i]!=-1) {
//            informTime[i]+=dfs(manager[i], manager, informTime);
//            manager[i]=-1;
//        }
//        return informTime[i];
//    }
    
    
    
    
    
//    --------------OPTIMAL -> BFS -> O(N), O(N)-------------------
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] arr=new ArrayList[n];
        for(int i=0; i<n; i++) {
            arr[i]=new ArrayList<>();
        }
        for(int i=0; i<n; i++) {
            if(manager[i]!=-1) arr[manager[i]].add(i);
        }
        System.out.println(Arrays.toString(arr));
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{headID, 0});
        int max=0;
        while(!queue.isEmpty()) {
            int[] t=queue.poll();
            max=Math.max(max, t[1]+informTime[t[0]]);
            for(int i: arr[t[0]]) {
                queue.offer(new int[]{i, t[1]+informTime[t[0]]});
            }
        }
        return max;
    }
    
    
    public static void main(String[] args) {
        TimeNeededToInformAllEmployees t=new TimeNeededToInformAllEmployees();
        System.out.println(t.numOfMinutes(1, 0, new int[]{-1}, new int[]{0}));
        System.out.println(t.numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}));
    }
}
