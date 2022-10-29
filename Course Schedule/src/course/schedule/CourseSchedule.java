/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.schedule;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.NodeData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class CourseSchedule {

    /**
     * @param args the command line arguments
     */
    
//    -------------OPTIMAL -> BFS -> O(V+E)-------------------
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] arr=new ArrayList[numCourses];
        int[] count=new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            arr[i]=new ArrayList<>();
        }
        for(int[] i: prerequisites) {
            arr[i[0]].add(i[1]);
            count[i[1]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0; i<count.length; i++) {
            if(count[i]==0) {
                queue.offer(i);
            }
        }
        int totalEdges=prerequisites.length;
        while(!queue.isEmpty()) {
            int v=queue.poll();
            for(int i: arr[v]) {
                totalEdges--;
                if(--count[i]==0) {
                    queue.offer(i);
                }
            }
        }
        return totalEdges==0;
    }
    
    
//    -------------OPTIMAL -> DFS -> O(V+E)-------------------
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        List<Integer>[] arr=new ArrayList[numCourses];
//        for(int i=0; i<numCourses; i++) {
//            arr[i]=new ArrayList<>();
//        }
//        for(int[] i: prerequisites) {
//            arr[i[0]].add(i[1]);
//        }
//        boolean[] visited=new boolean[numCourses];
//        for(int i=0; i<numCourses; i++) {
//            if(dfsCycle(arr, visited, i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//    
//    private boolean dfsCycle(List<Integer>[] adjList, boolean[] visited, int i) {
//        if(adjList[i].isEmpty()) return false;
//        if(visited[i]) return true;
//        visited[i]=true;
//        for(int val: adjList[i]) {
//            if(dfsCycle(adjList, visited, val)) {
//                return true;
//            }
//        }
//        adjList[i].clear();
//        return false;
//    }
    
    
    
//    -------------OPTIMAL -> DFS -> O(V+E)---------------------
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        Map<Integer, List<Integer>> map=new HashMap<>();
//        for(int[] i: prerequisites) {
//            map.putIfAbsent(i[0], new ArrayList<>());
//            map.get(i[0]).add(i[1]);
//        }
//        Boolean[] visited=new Boolean[numCourses];
//        return !isCyclic(map, visited);
//    }
//    
//    private boolean isCyclic(Map<Integer, List<Integer>> map, Boolean[] visited) {
//        for(int i: map.keySet()) {
//            List<Integer> list=map.get(i);
//            if(dfs(list, visited, map, i)) return true;
//        }
//        return false;
//    }
//    
//    private boolean dfs(List<Integer> list, Boolean[] visited, Map<Integer, List<Integer>> map, int i) {
//        if(list==null || (visited[i]!=null && !visited[i])) return false;
//        if(visited[i]!=null && visited[i]) return true;
//        visited[i]=true;
//        for(int j: list) {
//            if(dfs(map.get(j), visited, map, j)) return true;
//        }
//        visited[i]=false;
//        return false;
//    }
    
    public static void main(String[] args) {
        CourseSchedule c=new CourseSchedule();
        System.out.println(c.canFinish(2, new int[][]{{1,0}}));
        System.out.println(c.canFinish(2, new int[][]{{1,0},{0,1}}));
//        System.out.println(c.canFinish(5, new int[][]{{0,2},{0,1},{1,3},{4,1},{3,2}}));
        System.out.println(c.canFinish(5, new int[][]{{0,2},{0,1},{1,3},{4,1},{3,4}}));
        System.out.println(c.canFinish(1, new int[][]{}));
    }
}
