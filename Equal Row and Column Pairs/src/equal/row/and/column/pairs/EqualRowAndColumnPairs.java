/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equal.row.and.column.pairs;

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
public class EqualRowAndColumnPairs {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------OPTIMAL -> O(M*N), O(MAX(M, N))----------
//    public int equalPairs(int[][] grid) {
//        Map<String, Integer> map=new HashMap<>();
//        for(int[] i: grid) {
//            String gen=help(i);
//            map.put(gen, map.getOrDefault(gen, 0)+1);
//        }
//        int count=0;
//        for(int i=0; i<grid[0].length; i++) {
//            StringBuffer sb=new StringBuffer();
//            for(int j=0; j<grid.length; j++) {
//                sb.append(grid[j][i]).append("+");
//            }
//            count+=map.getOrDefault(sb.toString(), 0);
//        }
//        return count;
//    }
//    
//    private String help(int[] arr) {
//        StringBuffer sb=new StringBuffer();
//        for(int i: arr) {
//            sb.append(i).append("+");
//        }
//        return sb.toString();
//    }
    
    
//    -----------------OPTIMAL -> O(M*N), O(MAX(M, N))----------------
//    public int equalPairs(int[][] grid) {
//        Map<String, Integer> map=new HashMap<>();
//        for(int[] i: grid) {
//            map.put(Arrays.toString(i), map.getOrDefault(Arrays.toString(i), 0)+1);
//        }
//        int count=0;
//        for(int i=0; i<grid[0].length; i++) {
//            int[] arr=new int[grid.length];
//            for(int j=0; j<grid.length; j++) {
//                arr[j]=grid[j][i];
//            }
//            count+=map.getOrDefault(Arrays.toString(arr), 0);
//        }
//        return count;
//    }
    
    
    
    
    
//    ---------------OPTIMAL, BEAUTIFUL -> O(M*N), O(MAX(M, N))--------------------
    class Trie {
        int value;
        Map<Integer, Trie> map;
        int count;

        public Trie(int value) {
            this.map=new HashMap<>();
            this.value=value;
            this.count=0;
        }
        
        public Trie add(int value) {
            if(this.map.containsKey(value)) return this.map.get(value);
            Trie trie=new Trie(value);
            this.map.put(value, trie);
            return trie;
        }
        
        public void setEnd() {
            this.count++;
        }
        
        public int getEnd() {
            return this.count;
        }
    }
    
    public int equalPairs(int[][] grid) {
        Trie root=new Trie(0);
        for(int[] g: grid) {
            Trie temp=root;
            for(int i: g) {
                temp=temp.add(i);
            }
            temp.setEnd();
        }
        int count=0;
        for(int i=0; i<grid[0].length; i++) {
            Trie temp=root;
            for(int j=0; j<grid.length; j++) {
                if(temp.map.containsKey(grid[j][i])) {
                    temp=temp.map.get(grid[j][i]);
                } else {
                    break;
                }
            }
            count+=temp.count;
        }
        return count;
    }
    
    public static void main(String[] args) {
        EqualRowAndColumnPairs e=new EqualRowAndColumnPairs();
        System.out.println(e.equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        System.out.println(e.equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
    }
}
