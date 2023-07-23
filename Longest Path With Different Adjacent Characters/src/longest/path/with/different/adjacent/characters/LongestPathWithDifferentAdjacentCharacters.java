/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.path.with.different.adjacent.characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestPathWithDifferentAdjacentCharacters {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------------OPTIMAL -> O(N), O(N)------------------------
    int longestPath = 0;

    public int dfs(int currentNode, List<Integer>[] graph, String s) {
        int longestChain = 0, secondLongestChain = 0;
        for (int child : graph[currentNode]) {
            int longestChainStartingFromChild = dfs(child, graph, s);
            if (s.charAt(currentNode) == s.charAt(child)) {
                continue;
            }
            if (longestChainStartingFromChild >= longestChain) {
                secondLongestChain = longestChain;
                longestChain = longestChainStartingFromChild;
            } else if (longestChainStartingFromChild >= secondLongestChain) {
                secondLongestChain = longestChainStartingFromChild;
            }
        }

        longestPath = Math.max(longestPath, longestChain + secondLongestChain + 1);
        return longestChain + 1;
    }

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] graph=new ArrayList[parent.length];
        for(int i=0; i<graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            graph[parent[i]].add(i);
        }
        dfs(0, graph, s);
        return longestPath;
    }
    
    public static void main(String[] args) {
        LongestPathWithDifferentAdjacentCharacters l=new LongestPathWithDifferentAdjacentCharacters();
        System.out.println(l.longestPath(new int[]{-1,0,0,1,1,2}, "abacbe"));
    }
}
