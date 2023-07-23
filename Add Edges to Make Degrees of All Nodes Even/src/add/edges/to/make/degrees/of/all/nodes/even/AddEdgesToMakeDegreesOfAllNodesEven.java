/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add.edges.to.make.degrees.of.all.nodes.even;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class AddEdgesToMakeDegreesOfAllNodesEven {

    /**
     * @param args the command line arguments
     */
    
    public boolean isPossible(int n, List<List<Integer>> edges) {
        List<Integer>[] graph=new ArrayList[n+1];
        for(List<Integer> e: edges) {
            if(graph[e.get(0)]==null) {
                graph[e.get(0)]=new ArrayList<>();
            }
            if(graph[e.get(1)]==null) {
                graph[e.get(1)]=new ArrayList<>();
            }
            graph[e.get(0)].add(e.get(1));
            graph[e.get(1)].add(e.get(0));
        }
        
        for(List<Integer> g: graph) {
            System.out.println(g);
        }
        int oddCount=0;
        for(List<Integer> g: graph) {
            if(g.size()%2==1) oddCount++;
        }
        if(oddCount>4) return false;
        if(oddCount==1) return false;
        if(oddCount==0) return true;
        
        return false;
    }
    
    public static void main(String[] args) {
        AddEdgesToMakeDegreesOfAllNodesEven a=new AddEdgesToMakeDegreesOfAllNodesEven();
        List<List<Integer>> list=Arrays.asList(Arrays.asList(1,2), Arrays.asList(2,3), Arrays.asList(3,4), Arrays.asList(4,2), Arrays.asList(1,4), Arrays.asList(2,5));
        System.out.println(a.isPossible(5, list));
    }
}
