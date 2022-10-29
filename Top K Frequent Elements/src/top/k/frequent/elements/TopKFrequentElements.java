/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.k.frequent.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 *
 * @author wimukthirajapaksha
 */
public class TopKFrequentElements {

    /**
     * @param args the command line arguments
     */
    
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] list=new ArrayList[nums.length+1];
        int maxFrequency=Integer.MIN_VALUE;
        int minFrequency=Integer.MAX_VALUE;
        for(int i: nums) {
            if(minFrequency>i) {
                minFrequency=i;
            }
            if(maxFrequency<i) {
                maxFrequency=i;
            }
        }
        
        int[] arr=new int[maxFrequency-minFrequency+1];
        
        for(int i: nums) {
            int t=++arr[i-minFrequency];
            if(list[t]==null) {
                list[t]=new ArrayList<>();
            }
            list[t].add(i);
        }
        System.out.println(Arrays.toString(list));
        int[] ret=new int[k];
        for(int i=list.length-1; i>=0; i--) {
            if(list[i] != null && list[i].size()==k) {
                for(int j=0; j<list[i].size(); j++) {
                    ret[j]=list[i].get(j);
                }
                return ret;
            }
        }
        System.out.println("--"+Arrays.toString(arr));
        return ret;
    }
    
    
    
//    public int[] topKFrequent(int[] nums, int k) {
//        List<Integer>[] list=new ArrayList[nums.length+1];
//        int[] arr=new int[30000];
//        int maxFrequency=0;
//        for(int i: nums) {
//            int t=++arr[i+10000];
//            if(list[t]==null) {
//                list[t]=new ArrayList<>();
//            }
//            maxFrequency = Math.max(maxFrequency, t);
//            list[t].add(i);
//        }
//        System.out.println(Arrays.toString(list));
//        int[] ret=new int[k];
//        for(int i=maxFrequency; i>=0; i--) {
//            if(list[i] != null && list[i].size()==k) {
//                for(int j=0; j<list[i].size(); j++) {
//                    ret[j]=list[i].get(j);
//                }
//                return ret;
//            }
//        }
//        return ret;
//    }
    
    
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int i: nums) {
//            map.put(i, map.getOrDefault(i, 0)+1);
//        }
//        Queue<int[]> pq=new PriorityQueue<>((o1, o2) -> {
//            return Integer.compare(o2[1], o1[1]);
//        });
//        for(int i: map.keySet()) {
//            pq.offer(new int[]{i, map.get(i)});
//        }
//        int[] arr=new int[k];
//        int i=0;
//        while(i<k) {
//            arr[i++]=pq.poll()[0];
//        }
//        return arr;
//    }
    
    public static void main(String[] args) {
        TopKFrequentElements t=new TopKFrequentElements();
        System.out.println(Arrays.toString(t.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(t.topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(t.topKFrequent(new int[]{1,1,1,2,2,3}, 3)));
        System.out.println(Arrays.toString(t.topKFrequent(new int[]{1,1,1,2,2,3}, 1)));
    }
}
