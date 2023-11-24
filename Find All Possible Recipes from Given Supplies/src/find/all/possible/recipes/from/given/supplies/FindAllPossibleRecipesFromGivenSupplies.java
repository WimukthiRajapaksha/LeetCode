/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.all.possible.recipes.from.given.supplies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindAllPossibleRecipesFromGivenSupplies {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------------OPTIMAL -> O(V+E) -> O(V)-------------------
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph=new HashMap<>();
        Map<String, Integer> counts=new HashMap<>();
        for(int i=0; i<recipes.length; i++) {
            for(int j=0; j<ingredients.get(i).size(); j++) {
                graph.putIfAbsent(ingredients.get(i).get(j), new ArrayList<>());
                graph.get(ingredients.get(i).get(j)).add(recipes[i]);
                counts.put(recipes[i], counts.getOrDefault(recipes[i], 0)+1);
            }
        }
        Queue<String> queue=new LinkedList<>();
        for(String s: supplies) {
            queue.offer(s);
        }
        List<String> ret=new ArrayList<>();
        while(!queue.isEmpty()) {
            String temp=queue.poll();
            if(!graph.containsKey(temp)) continue;
            for(String s: graph.get(temp)) {
                counts.put(s, counts.get(s)-1);
                if(counts.get(s)==0) {
                    queue.offer(s);
                    ret.add(s);
                }
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
        FindAllPossibleRecipesFromGivenSupplies f=new FindAllPossibleRecipesFromGivenSupplies();
        System.out.println(f.findAllRecipes(new String[]{"bread"}, Arrays.asList(Arrays.asList("yeast","flour")), new String[]{"yeast","flour","corn"}));
        System.out.println(f.findAllRecipes(new String[]{"bread","sandwich"}, Arrays.asList(Arrays.asList("yeast","flour"), Arrays.asList("bread","meat")), new String[]{"yeast","flour","meat"}));
        System.out.println(f.findAllRecipes(new String[]{"bread","sandwich","burger"}, Arrays.asList(Arrays.asList("yeast","flour"), Arrays.asList("bread","meat"), Arrays.asList("sandwich","meat","bread")), new String[]{"yeast","flour","meat"}));
    }
}
