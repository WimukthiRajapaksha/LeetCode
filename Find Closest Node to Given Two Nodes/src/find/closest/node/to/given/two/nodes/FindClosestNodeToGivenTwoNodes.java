/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.closest.node.to.given.two.nodes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindClosestNodeToGivenTwoNodes {

    /**
     * @param args the command line arguments
     */
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1=bfs(edges, node1);
        int[] dis2=bfs(edges, node2);
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0; i<dis1.length; i++) {
            if(min>Math.max(dis1[i], dis2[i])) {
                min=Math.max(dis1[i], dis2[i]);
                index=i;
            }
        }
        return index;
    }
    
    private int[] bfs(int[] edges, int root) {
        int[] distance=new int[edges.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[root]=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(root);
        boolean[] visited=new boolean[edges.length];
        while(!queue.isEmpty()) {
            int temp=queue.poll();
            visited[temp]=true;
            if(edges[temp]!=-1 && !visited[edges[temp]]) {
                queue.offer(edges[temp]);
                distance[edges[temp]]=distance[temp]+1;
            }
        }
        return distance;
    }
    
    
//    public int closestMeetingNode(int[] edges, int node1, int node2) {
//        int[] dist1=new int[edges.length];
//        int[] dist2=new int[edges.length];
//        Arrays.fill(dist1, Integer.MAX_VALUE);
//        Arrays.fill(dist2, Integer.MAX_VALUE);
//        dist1[node1]=0;
//        dist2[node2]=0;
//        boolean[] visi1=new boolean[edges.length];
//        boolean[] visi2=new boolean[edges.length];
//        dfs(node1, edges, visi1, dist1);
//        dfs(node2, edges, visi2, dist2);
//        int max=Integer.MAX_VALUE;
//        int index=-1;
//        for(int i=0; i<dist1.length; i++) {
//            if(max>Math.max(dist1[i], dist2[i])) {
//                max=Math.max(dist1[i], dist2[i]);
//                index=i;
//            }
//        }
//        return index;
//    }
//    
//    private void dfs(int root, int[] edges, boolean[] visited, int[] distance) {
//        visited[root]=true;
//        if(edges[root]!=-1 && !visited[edges[root]]) {
//            distance[edges[root]]=1+distance[root];
//            dfs(edges[root], edges, visited, distance);
//        }
//    }
    
    public static void main(String[] args) {
        FindClosestNodeToGivenTwoNodes f=new FindClosestNodeToGivenTwoNodes();
        System.out.println(f.closestMeetingNode(new int[]{2,2,3,-1}, 0, 1));
        System.out.println(f.closestMeetingNode(new int[]{1,2,-1}, 0, 2));
    }
}
