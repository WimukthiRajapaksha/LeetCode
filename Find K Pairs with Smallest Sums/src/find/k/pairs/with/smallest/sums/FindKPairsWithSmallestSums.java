/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.k.pairs.with.smallest.sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindKPairsWithSmallestSums {

    /**
     * @param args the command line arguments
     */
    
//    -------------------OPTIMAL -> O(KLOGK) -> O(K)--------------------
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        Queue<int[]> queue=new PriorityQueue<>((o1,o2)->Integer.compare(nums1[o1[0]]+nums2[o1[1]],nums1[o2[0]]+nums2[o2[1]]));
//        if(k==0 || nums1.length==0 || nums2.length==0) return new ArrayList<>();
//        for(int i=0; i<Math.min(nums1.length, k); i++) {
//            queue.offer(new int[]{i, 0});
//        }
//        List<List<Integer>> ret=new ArrayList<>();
//        while(!queue.isEmpty() && ret.size()!=k) {
//            int[] temp=queue.poll();
//            ret.add(Arrays.asList(nums1[temp[0]], nums2[temp[1]]));
//            if(temp[1]==nums2.length-1) continue;
//            queue.offer(new int[]{temp[0], temp[1]+1});
//        }
//        return ret;
//    }
    
    
//    -------------------OPTIMAL -> O(KLOGK) -> O(K)--------------------
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> queue=new PriorityQueue<>((o1,o2)->Integer.compare(nums1[o1[0]]+nums2[o1[1]],nums1[o2[0]]+nums2[o2[1]]));
        queue.offer(new int[]{0,0});
        List<List<Integer>> ret=new ArrayList<>();
        boolean[] visited=new boolean[nums1.length*nums2.length];
        visited[0]=true;
        while(!queue.isEmpty() && ret.size()!=k) {
            int[] temp=queue.poll();
            if(temp[0]+1<nums1.length && nums1[temp[0]]+nums2[temp[1]]<=nums1[temp[0]+1]+nums2[temp[1]] && !visited[((temp[0]+1)*nums2.length)+temp[1]]) {
                queue.offer(new int[]{temp[0]+1, temp[1]});
                visited[((temp[0]+1)*nums2.length)+temp[1]]=true;
            }
            if(temp[1]+1<nums2.length && nums1[temp[0]]+nums2[temp[1]]<=nums1[temp[0]]+nums2[temp[1]+1] && !visited[(temp[0]*nums2.length)+(temp[1]+1)]) {
                queue.offer(new int[]{temp[0], temp[1]+1});
                visited[(temp[0]*nums2.length)+(temp[1]+1)]=true;
            }
            List<Integer> list=Arrays.asList(nums1[temp[0]], nums2[temp[1]]);
            ret.add(list);
        }
        return ret;
    }
    
    
    
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        Queue<int[]> queue=new PriorityQueue<>((o1,o2)->Integer.compare(nums1[o1[0]]+nums2[o1[1]],nums1[o2[0]]+nums2[o2[1]]));
//        queue.offer(new int[]{0,0});
//        List<List<Integer>> ret=new ArrayList<>();
//        Set<Integer> visited=new HashSet<>();
//        visited.add(0);
//        while(!queue.isEmpty() && ret.size()!=k) {
//            int[] temp=queue.poll();
//            if(temp[0]+1<nums1.length && nums1[temp[0]]+nums2[temp[1]]<=nums1[temp[0]+1]+nums2[temp[1]] && !visited.contains(((temp[0]+1)*nums2.length)+temp[1])) {
//                queue.offer(new int[]{temp[0]+1, temp[1]});
//                visited.add(((temp[0]+1)*nums2.length)+temp[1]);
//            }
//            if(temp[1]+1<nums2.length && nums1[temp[0]]+nums2[temp[1]]<=nums1[temp[0]]+nums2[temp[1]+1] && !visited.contains((temp[0]*nums2.length)+(temp[1]+1))) {
//                queue.offer(new int[]{temp[0], temp[1]+1});
//                visited.add((temp[0]*nums2.length)+(temp[1]+1));
//            }
//            List<Integer> list=Arrays.asList(nums1[temp[0]], nums2[temp[1]]);
//            ret.add(list);
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        FindKPairsWithSmallestSums f=new FindKPairsWithSmallestSums();
        System.out.println(f.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 9));
        System.out.println(f.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
        System.out.println(f.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2));
        System.out.println(f.kSmallestPairs(new int[]{1,2}, new int[]{3}, 3));
    }
}
