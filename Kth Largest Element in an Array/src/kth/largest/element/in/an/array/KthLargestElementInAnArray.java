/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kth.largest.element.in.an.array;

import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author wimukthirajapaksha
 */
public class KthLargestElementInAnArray {

    /**
     * @param args the command line arguments
     */
    
//    ------------- ALTERNATE -> O(NLOGK) -> O(K)----------------
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> queue=new PriorityQueue<>((o1,o2)->Integer.compare(o2, o1));
//        for(int i: nums) {
//            queue.offer(i);
//        }
//        int t=0;
//        while(k-->0) {
//            t=queue.poll();
//        }
//        return t;
//    }
    
    
    
//    ------------- ALTERNATE -> OPTIMAL -> O(N) -> O(1)----------------
//    public int findKthLargest(int[] nums, int k) {
//        int place=nums.length-k;
//        int s=0;
//        int e=nums.length-1;
//        while(true) {
//            int i=partition(nums, s, e);
//            System.out.print(i+" "+place);
//            if(i==place) {
//                System.out.println();
//                return nums[i];
//            } else if(i<place) {
//                s=i+1;
//            } else {
//                e=i-1;
//            }
//        }
//    }
//    
//    private int partition(int[] nums, int l, int r) {
//        int i=l-1;
//        int j=l;
//        int pevot=nums[r];
//        while(j<r) {
//            if(nums[j]<pevot) {
//                swap(nums, ++i, j++);
//            } else {
//                j++;
//            }
//        }
//        swap(nums, ++i, r);
//        return i;
//    }
//    
//    private void swap(int[] arr, int i, int j) {
//        int t=arr[i];
//        arr[i]=arr[j];
//        arr[j]=t;
//    }
    
    
    
    
//    ------------- ALTERNATE -> OPTIMAL -> O(N) -> O(1)----------------
//    public int findKthLargest(int[] nums, int k) {
//        int place=nums.length-k;
//        int s=0;
//        int e=nums.length-1;
//        while(s<e) {
//            int i=partition(nums, s, e);
//            if(i==place) {
//                System.out.println();
//                return nums[i];
//            } else if(i<place) {
//                s=i+1;
//            } else {
//                e=i-1;
//            }
//        }
//        return nums[k];
//    }
//    
//    private int partition(int[] nums, int l, int r) {
//        int i=l-1;
//        int j=l;
//        int pevot=nums[r];
//        while(j<=r) {
//            if(nums[j]<pevot) {
//                swap(nums, ++i, j++);
//            } else {
//                j++;
//            }
//        }
//        swap(nums, ++i, r);
//        return i;
//    }
//    
//    private void swap(int[] arr, int i, int j) {
//        int t=arr[i];
//        arr[i]=arr[j];
//        arr[j]=t;
//    }
    
    
    
    
//    -------------MOST OPTIMAL -> WITH RANDOM POINTER -> O(N) -> O(1)----------------
    public int findKthLargest(int[] nums, int k) {
        int place=nums.length-k;
        int s=0;
        int e=nums.length-1;
        Random rand=new Random();
        while(s<=e) {
            int randInt=rand.nextInt(e-s+1)+s;
            swap(nums, randInt, e);
            int i=partition(nums, s, e);
            if(i==place) {
                return nums[i];
            } else if(i<place) {
                s=i+1;
            } else {
                e=i-1;
            }
        }
        return nums[k];
    }
    
    private int partition(int[] nums, int l, int r) {
        int i=l-1;
        int j=l;
        int pevot=nums[r];
        while(j<r) {
            if(nums[j]<pevot) {
                swap(nums, ++i, j++);
            } else {
                j++;
            }
        }
        swap(nums, ++i, r);
        return i;
    }
    
    private void swap(int[] arr, int i, int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    
    public static void main(String[] args) {
        KthLargestElementInAnArray k=new KthLargestElementInAnArray();
        System.out.println(k.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(k.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
//        System.out.println(k.findKthLargest(new int[]{}, 0));
    }
}
