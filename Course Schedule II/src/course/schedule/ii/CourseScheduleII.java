/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.schedule.ii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class CourseScheduleII {

    /**
     * @param args the command line arguments
     */
    
//    -----------------OPTIMAL -> BFS -> O(V+E), O(V+E)-----------
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph=new ArrayList[numCourses];
        int[] degree=new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int[] i: prerequisites) {
            graph[i[1]].add(i[0]);
            degree[i[0]]++;
        }
        List<Integer> ret=new ArrayList<>(numCourses);
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(degree[i]==0) {
                queue.offer(i);
                ret.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int temp=queue.poll();
            for(int i: graph[temp]) {
                degree[i]--;
                if(degree[i]==0) {
                    queue.offer(i);
                    ret.add(i);
                }
            }
        }
        if(ret.size()!=numCourses) return new int[]{};
        System.out.println(ret);
        int[] returnList=new int[ret.size()];
        for(int i=0; i<ret.size(); i++) {
            returnList[i]=ret.get(i);
        }
        return returnList;
    }
    
    
//    ----------------------ALTERNATE -> OPTIMAL -> DFS -> CHANGED EDGE DIRECTION -> O(V+E) , O(V+E)----------
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        List<Integer>[] graph=new ArrayList[numCourses];
//        for(int i=0; i<numCourses; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        for(int[] i: prerequisites) {
//            graph[i[1]].add(i[0]);
//        }
//        List<Integer> ret=new ArrayList<>(numCourses);
//        Boolean[] visited=new Boolean[numCourses];
//        for(int i=0; i<numCourses; i++) {
//            if((visited[i] == null || !visited[i]) && !acylicDfs(graph, ret, visited, i)) {
//                return new int[]{};
//            }
//        }
//        System.out.println(ret);
//        int[] returnList=new int[ret.size()];
//        for(int i=ret.size()-1; i>=0; i--) {
//            returnList[ret.size()-1-i]=ret.get(i);
//        }
//        return returnList;
//    }
//    
//    private boolean acylicDfs(List<Integer>[] arr, List<Integer> list, Boolean[] visited, int place) {
//        if(visited[place]!=null && !visited[place]) return true;
//        if(visited[place]!=null && visited[place]) return false;
//        visited[place]=true;
//        for(int i: arr[place]) {
//            if(!acylicDfs(arr, list, visited, i)) {
//                return false;
//            }
//        }
//        list.add(place);
//        visited[place]=false;
//        return true;
//    }
    
    
    
    
    
//    ----------------------ALTERNATE -> OPTIMAL -> DFS -> CHANGED EDGE DIRECTION -> O(V+E) , O(V+E)----------
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        List<Integer>[] graph=new ArrayList[numCourses];
//        for(int i=0; i<numCourses; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        for(int[] i: prerequisites) {
//            graph[i[0]].add(i[1]);
//        }
//        List<Integer> ret=new ArrayList<>();
//        Set<Integer> visited=new HashSet<>();
//        for(int i=0; i<numCourses; i++) {
//            if(!visited.contains(i) && dfs(graph, ret, visited, new HashSet<>(), i)) {
//                return new int[]{};
//            }
//        }
//        for(List<Integer> i: graph) {
//            System.out.println(i);
//        }
//        System.out.println(ret);
//        int[] returnList=new int[ret.size()];
//        for(int i=0; i<ret.size(); i++) {
//            returnList[i]=ret.get(i);
//        }
//        return returnList;
//    }
//    
//    private boolean dfs(List<Integer>[] arr, List<Integer> list, Set<Integer> visited, Set<Integer> cycle, int place) {
//        if(visited.contains(place)) return false;
//        if(cycle.contains(place)) return true;
//        cycle.add(place);
//        for(int i: arr[place]) {
//            if(dfs(arr, list, visited, cycle, i)) {
//                return true;
//            }
//        }
//        list.add(place);
//        cycle.remove(place);
//        visited.add(place);
//        return false;
//    }
    
    public static void main(String[] args) {
        CourseScheduleII c=new CourseScheduleII();
        c.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        c.findOrder(6, new int[][]{{0,5},{2,5},{2,4},{2,0},{3,0},{1,3},{1,4}});
        c.findOrder(2, new int[][]{{1,0}});
        c.findOrder(1, new int[][]{});
    }
}


//[0, 1, 2, 3]
//[5, 0, 3, 4, 1, 2]
//[0, 1]