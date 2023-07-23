/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluate.division;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class EvaluateDivision {

    /**
     * @param args the command line arguments
     */
    
//    ------------------OPTIMAL -> O(N), O(N)--------------------
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph=buildGraph(equations, values);
        System.out.println(graph);
        double[] ret=new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            ret[i]=dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }
        System.out.println(Arrays.toString(ret));
        return ret;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String source, String target, Set<String> visited) {
        if(!(graph.containsKey(source) && graph.containsKey(target))) {
            return -1;
        }
        if(graph.get(source).containsKey(target)) return graph.get(source).get(target);
        visited.add(source);
        for(Map.Entry<String, Double> en: graph.get(source).entrySet()) {
            if(!visited.contains(en.getKey())) {
                double temp=dfs(graph, en.getKey(), target, visited);
                if(temp!=-1) {
                    return temp*en.getValue();
                }
            }
        }
        return -1;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> eq, double[] val) {
        Map<String, Map<String, Double>> graph=new HashMap<>();
        for(int i=0; i<eq.size(); i++) {
            graph.putIfAbsent(eq.get(i).get(0), new HashMap<>());
            graph.putIfAbsent(eq.get(i).get(1), new HashMap<>());
            graph.get(eq.get(i).get(0)).put(eq.get(i).get(1), val[i]);
            graph.get(eq.get(i).get(1)).put(eq.get(i).get(0), 1/val[i]);
        }
        return graph;
    }
    
    
//    ------------------OPTIMAL -> O(N), O(N)--------------------
//    class Node {
//        double val;
//        String node;
//
//        public Node(double val, String node) {
//            this.val = val;
//            this.node = node;
//        }
//
//        @Override
//        public String toString() {
//            return val+" "+node;
//        }
//    }
//    
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        Map<String, List<Node>> graph=buildGraph(equations, values);
//        double[] ret=new double[queries.size()];
//        for(int i=0; i<queries.size(); i++) {
//            ret[i]=dfs(graph, queries.get(i).get(1), queries.get(i).get(0), new HashSet<>(Arrays.asList(queries.get(i).get(0))));
//        }
//        System.out.println(Arrays.toString(ret));
//        return ret;
//    }
//    
//    private double dfs(Map<String, List<Node>> graph, String tar, String curr, Set<String> visited) {
//        if(!(graph.containsKey(curr) && graph.containsKey(tar))) return -1;
//        if(curr.equals(tar)) return 1;
//        visited.add(curr);
//        for(Node n: graph.get(curr)) {
//            if(!visited.contains(n.node)) {
//                visited.add(n.node);
//                double temp=dfs(graph, tar, n.node, visited);
//                if(temp!=-1) {
//                    return temp*n.val;
//                }
//            }
//        }
//        return -1;
//    }
//    
//    private Map<String, List<Node>> buildGraph(List<List<String>> eq, double[] val) {
//        Map<String, List<Node>> map=new HashMap<>();
//        for(int i=0; i<eq.size(); i++) {
//            map.putIfAbsent(eq.get(i).get(0), new ArrayList<>());
//            map.get(eq.get(i).get(0)).add(new Node(val[i], eq.get(i).get(1)));
//            map.putIfAbsent(eq.get(i).get(1), new ArrayList<>());
//            map.get(eq.get(i).get(1)).add(new Node(1/val[i], eq.get(i).get(0)));
//        }
//        return map;
//    }
    
    public static void main(String[] args) {
        EvaluateDivision e=new EvaluateDivision();
        System.out.println(e.calcEquation(
                Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c")), 
                new double[]{2.0,3.0}, 
                Arrays.asList(Arrays.asList("a","c"))));
        
        System.out.println(e.calcEquation(
                Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c")), 
                new double[]{2.0,3.0}, 
                Arrays.asList(Arrays.asList("a","c"), Arrays.asList("b","a"), Arrays.asList("a","e"), 
                        Arrays.asList("a","a"), Arrays.asList("x","x"))));
        
        System.out.println(e.calcEquation(
                Arrays.asList(Arrays.asList("a","b"), Arrays.asList("c","d")), 
                new double[]{1,1.0}, 
                Arrays.asList(Arrays.asList("a","c"), Arrays.asList("b","d"), Arrays.asList("b","a"), 
                        Arrays.asList("d","c"))));
    }
}
