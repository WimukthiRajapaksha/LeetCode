/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.target.indices.after.sorting.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindTargetIndicesAfterSortingArray {

    /**
     * @param args the command line arguments
     */
    
    public List<Integer> targetIndices(int[] nums, int target) {
        int less=0;
        int count=0;
        for (int i: nums) {
            if (i<target) {
                less++;
            } else if (i==target) {
                count++;
            }
        }
        if (count==0) {
            return new ArrayList<>();
        }
        List<Integer> list=new ArrayList<>();
        for (int i=0; i<count; i++) {
            list.add(less++);
        }
        return list;
    }
    
//    ---------------------------ALTERNATE -> OPTIMAL---------------------------
//    public List<Integer> targetIndices(int[] nums, int target) {
//        int[] a=new int[101];
//        for (int i: nums) {
//            a[i]++;
//        }
//        for (int i: a) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        if (a[target]==0) {
//            return new ArrayList<>();
//        }
//        for (int i=1; i<a.length; i++) {
//            a[i]+=a[i-1];
//        }
//        for (int i: a) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        int b=a[target-1];
//        List<Integer> list=new ArrayList<>();
//        for (int i=b+1; i<=a[target]; i++) {
//            list.add(i-1);
//        }
//        return list;
//    }
    
    
//    --------------------------ALTERNATE -> NOT OPTIMAL-------------------------
//    public List<Integer> targetIndices(int[] nums, int target) {
//        Arrays.sort(nums);
//        List<Integer> list=new ArrayList<>();
//        for (int i=0; i<nums.length; i++) {
//            if (nums[i]>target) {
//                return list;
//            } else if (nums[i]==target) {
//                list.add(i);
//            }
//        }
//        return list;
//    }
    
    public static void main(String[] args) {
        FindTargetIndicesAfterSortingArray f=new FindTargetIndicesAfterSortingArray();
        System.out.println(f.targetIndices(new int[]{1,2,5,2,3}, 2));
        System.out.println(f.targetIndices(new int[]{1,2,5,2,3}, 3));
    }
}
