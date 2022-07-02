/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package next.greater.element.i;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class NextGreaterElementI {

    /**
     * @param args the command line arguments
     */
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length];
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums2.length; i++) {
            map.put(nums2[i], i+1);
        }
        System.out.println(map);
        for(int i=0; i<nums1.length; i++) {
            int t=map.get(nums1[i]);
            arr[i]=-1;
            for(int j=t; j<nums2.length; j++) {
                if(nums1[i]<nums2[j]) {
                    arr[i]=nums2[j];
                    break;
                }
            }
        }
        for(int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        return arr;
    }
    
    
//    -----------------------ALTERNATE--------------------------------
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Stack<Integer> stack=new Stack<>();
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int i=1; i<nums2.length; i++) {
//            if(nums2[i-1]>nums2[i]) {
//                stack.push(nums2[i-1]);
//            }  else {
//                stack.push(nums2[i-1]);
//                while(!stack.isEmpty() && stack.peek()<nums2[i]) {
//                    map.put(stack.pop(), nums2[i]);
//                }
//            }
//        }
//        for(int i=0; i<nums1.length; i++) {
//            nums1[i]=map.getOrDefault(nums1[i], -1);
//        }
//        System.out.println(map);
//        for(int i: nums1) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        return nums1;
//    }
    
    public static void main(String[] args) {
        NextGreaterElementI n=new NextGreaterElementI();
        n.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        n.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4});
        n.nextGreaterElement(new int[]{2}, new int[]{2});
        n.nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{6,5,4,3,2,1,7});
    }
}

