/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sliding.window.maximum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author wimukthirajapaksha
 */
public class SlidingWindowMaximum {

    /**
     * @param args the command line arguments
     */
    
//    -----------------------OPTIMAL -> O(N), O(N)-----------------------
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        left[0]=nums[0];
        right[right.length-1]=nums[nums.length-1];

        for(int i=1; i<nums.length; i++) {
            left[i]=(i%k==0) ? nums[i] : Math.max(left[i-1], nums[i]);
            int j=nums.length-1-i;
            right[j]=((j+1)%k==0) ? nums[j] : Math.max(right[j+1], nums[j]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int[] ret=new int[nums.length+1-k];
        for(int i=0; i<ret.length; i++) {
            ret[i]=Math.max(right[i], left[i+k-1]);
        }
        System.out.println(Arrays.toString(ret));
        return ret;
    }
    
    
//    -----------------------OPTIMAL -> O(N), O(K)-----------------------
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(k==1) return nums;
//        Deque<Integer> deque=new LinkedList<>();
//        int[] arr=new int[nums.length-k+1];
//        for(int i=0; i<nums.length; i++) {
//            if(i>=k && deque.peekFirst()==i-k) {
//                deque.poll(); // pollFirst() equivalent
//            }
//            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]) {
//                deque.pollLast();
//            }
//            deque.addLast(i);
//            if(i>=k-1) {
//                arr[i-k+1]=nums[deque.peek()];
//            }
//        }
//        return arr;
//    }
    
    
//    -----------------------OPTIMAL -> O(N), O(N)-----------------------
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int t=10000;
//        if(k==1) return nums;
//        int[] ret=new int[nums.length-k+1];
//        int[] hashTable=new int[100000];
//        PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o2, o1));
//        for(int i=0; i<k-1; i++) {
//            pq.offer(nums[i]);
//            hashTable[nums[i]+t]++;
//        }
//        for(int i=k-1; i<nums.length; i++) {
//            pq.offer(nums[i]);
//            hashTable[nums[i]+t]++;
//            if(i-k>=0) {
//                hashTable[nums[i-k]+t]--;
//                while(hashTable[pq.peek()+t]<=0) {
//                    pq.poll();
//                }
//            }
//            ret[i-k+1]=pq.peek();
//        }
//        System.out.println(Arrays.toString(ret));
//        return ret;
//    }
    
    public static void main(String[] args) {
        SlidingWindowMaximum s=new SlidingWindowMaximum();
        System.out.println(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        System.out.println(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 8));
        System.out.println(s.maxSlidingWindow(new int[]{7,2,4}, 2));
    }
}
