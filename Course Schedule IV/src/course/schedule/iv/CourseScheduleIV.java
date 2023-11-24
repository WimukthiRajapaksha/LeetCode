/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.schedule.iv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class CourseScheduleIV {

    /**
     * @param args the command line arguments
     */
    
//    ----------OPTIMAL -> TOPOLOGICAL SORTING -> O(V+E), O(V^2)-------------
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ret=new ArrayList<>();
        List<Integer>[] graph=new ArrayList[numCourses];
        int[] indegree=new int[numCourses];
        Set<Integer>[] depend=new HashSet[numCourses];
        buildGraph(numCourses, prerequisites, graph, indegree);
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0) queue.offer(i);
        }
        for(int i=0; i<numCourses; i++) {
            depend[i]=new HashSet<>();
        }
        while(!queue.isEmpty()) {
            int temp=queue.poll();
            for(int i: graph[temp]) {
                indegree[i]--;
                if(indegree[i]==0) {
                    queue.offer(i);
                }
                depend[i].addAll(depend[temp]);
                depend[i].add(temp);
            }
        }
        for(int[] q: queries) {
            if(depend[q[1]].contains(q[0])) {
                ret.add(true);
            } else {
                ret.add(false);
            }
        }
        return ret;
    }
    
    private void buildGraph(int numCourses, int[][] prerequisites, List<Integer>[] graph, int[] indegree) {
        for(int i=0; i<numCourses; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int i=0; i<prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
    }
    
    public static void main(String[] args) {
        CourseScheduleIV c=new CourseScheduleIV();
        System.out.println(c.checkIfPrerequisite(2, new int[][]{{1,0}}, new int[][]{{0,1},{1,0}}));
        System.out.println(c.checkIfPrerequisite(2, new int[][]{}, new int[][]{{1,0},{0,1}}));
        System.out.println(c.checkIfPrerequisite(3, new int[][]{{1,2},{1,0},{2,0}}, new int[][]{{1,0},{1,2}}));
        System.out.println(c.checkIfPrerequisite(4, new int[][]{{2,3},{2,1},{0,3},{0,1}}, new int[][]{{0,1},{0,3},{2,3},{3,0},{2,0},{0,2}}));
    }
}
