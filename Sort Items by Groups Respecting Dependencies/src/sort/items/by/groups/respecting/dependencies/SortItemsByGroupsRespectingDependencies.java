/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort.items.by.groups.respecting.dependencies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class SortItemsByGroupsRespectingDependencies {

    /**
     * @param args the command line arguments
     */
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int max=m;
        for(int i=0; i<group.length; i++) {
            if(group[i]==-1) {
                group[i]=max++;
            }
        }
        int[] indegreeItem=new int[n];
        List<Integer>[] graphItem=graphItems(beforeItems, n, indegreeItem);
        int[] indegreeGroup=new int[max];
        Set<Integer>[] graphGroup=graphGroup(beforeItems, group, max, indegreeGroup);
        for(List<Integer> g: graphItem) System.out.println(g);
        System.out.println(Arrays.toString(indegreeItem));
        System.out.println();
        for(Set<Integer> g: graphGroup) System.out.println(g);
        System.out.println(Arrays.toString(indegreeGroup));
        return new int[]{};
    }
    
    private List<Integer>[] graphItems(List<List<Integer>> items, int n, int[] indegree) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int i=0; i<items.size(); i++) {
            for(int j: items.get(i)) {
                graph[i].add(j);
                indegree[i]++;
            }
        }
        return graph;
    }
    
    private Set<Integer>[] graphGroup(List<List<Integer>> items, int[] groups, int m, int[] indegree) {
        Set<Integer>[] graph=new HashSet[m];
        for(int i=0; i<m; i++) {
            graph[i]=new HashSet<>();
        }
        for(int i=0; i<items.size(); i++) {
            for(int j: items.get(i)) {
                if(groups[j]!=groups[i]) {
                    graph[groups[i]].add(groups[j]);
                    indegree[groups[i]]++;
                }
            }
        }
        return graph;
    }
    
    public static void main(String[] args) {
        SortItemsByGroupsRespectingDependencies s=new SortItemsByGroupsRespectingDependencies();
        System.out.println(s.sortItems(8, 2, new int[]{-1,-1,1,0,0,1,0,-1}, Arrays.asList(Arrays.asList(),Arrays.asList(6),Arrays.asList(5),Arrays.asList(6),Arrays.asList(3,6),Arrays.asList(),Arrays.asList(),Arrays.asList())));
    }
}
