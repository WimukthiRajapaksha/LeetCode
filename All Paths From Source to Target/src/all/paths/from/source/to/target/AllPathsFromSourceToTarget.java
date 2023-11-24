/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package all.paths.from.source.to.target;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class AllPathsFromSourceToTarget {

    /**
     * @param args the command line arguments
     */
    
//    --------------OPTIMAL -> O(N* 2^N), O(N)-------------
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        help(list, 0, graph, new ArrayList<>());
        return list;
    }

    private void help(List<List<Integer>> list, int parent, int[][] graph, List<Integer> temp) {
        temp.add(parent);
        if(parent==graph.length-1) {
            list.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        for(int i: graph[parent]) {
            help(list, i, graph, temp);
        }
        temp.remove(temp.size()-1);
    }
    
    public static void main(String[] args) {
        AllPathsFromSourceToTarget a=new AllPathsFromSourceToTarget();
        System.out.println(a.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
    }
}
