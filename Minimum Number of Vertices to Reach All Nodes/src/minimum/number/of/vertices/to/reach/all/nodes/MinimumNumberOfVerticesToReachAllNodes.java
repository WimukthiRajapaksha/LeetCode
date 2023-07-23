/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.number.of.vertices.to.reach.all.nodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumNumberOfVerticesToReachAllNodes {

    /**
     * @param args the command line arguments
     */
    
//    ----------------------OPTIMAL -> O(V+E), O(V)-----------------(N==V)-----------
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] arr=new boolean[n];
        for(List<Integer> e: edges) {
            arr[e.get(1)]=true;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==false) {
                list.add(i);
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        MinimumNumberOfVerticesToReachAllNodes m=new MinimumNumberOfVerticesToReachAllNodes();
        System.out.println(m.findSmallestSetOfVertices(6, 
            Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(0,2),
                Arrays.asList(2,5),Arrays.asList(3,4),
                Arrays.asList(4,2
            ))));
    }
}
