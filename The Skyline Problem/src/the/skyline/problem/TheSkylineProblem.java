/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.skyline.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

/**
 *
 * @author wimukthirajapaksha
 */
public class TheSkylineProblem {

    /**
     * @param args the command line arguments
     */
    
//    -----------------OPTIMAL -> O(NLOG(N)), O(N)-------------------------
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result=new ArrayList<>();
        List<int[]> heights=new ArrayList<>();
        for(int[] b: buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (o1, o2)-> {
            if(o1[0]!=o2[0]) {
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });
        TreeMap<Integer, Integer> map=new TreeMap<>((o1,o2)->Integer.compare(o2, o1));
        map.put(0, 1);
        int prev=0;
        for(int[] h: heights) {
            if(h[1]<0) {
                map.put(-h[1], map.getOrDefault(-h[1], 0)+1);
            } else {
                if(map.get(h[1])==1) {
                    map.remove(h[1]);
                } else {
                    map.put(h[1], map.getOrDefault(h[1], 0)-1);
                }
            }
            int curr=map.firstKey();
            if(curr!=prev) {
                result.add(Arrays.asList(h[0], curr));
                prev=curr;
            }
        }
        return result;
    }
    
//    -----------------GOOD SOLUTION -> O(N^2), O(N)-------------------------
//    public List<List<Integer>> getSkyline(int[][] buildings) {
//        List<List<Integer>> result=new ArrayList<>();
//        List<int[]> heights=new ArrayList<>();
//        for(int[] b: buildings) {
//            heights.add(new int[]{b[0], -b[2]});
//            heights.add(new int[]{b[1], b[2]});
//        }
//        Collections.sort(heights, (o1, o2)-> {
//            if(o1[0]!=o2[0]) {
//                return o1[0]-o2[0];
//            }
//            return o1[1]-o2[1];
//        });
//        Queue<Integer> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o2, o1));
//        pq.offer(0);
//        int prev=0;
//        for(int[] h: heights) {
//            if(h[1]<0) {
//                pq.offer(-h[1]);
//            } else {
//                pq.remove(h[1]);
//            }
//            int curr=pq.peek();
//            if(curr!=prev) {
//                result.add(Arrays.asList(h[0], curr));
//                prev=curr;
//            }
//        }
//        return result;
//    }
    
    public static void main(String[] args) {
        TheSkylineProblem t=new TheSkylineProblem();
        System.out.println(t.getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}}));
    }
}
