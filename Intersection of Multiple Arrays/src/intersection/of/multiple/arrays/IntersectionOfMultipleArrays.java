/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intersection.of.multiple.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class IntersectionOfMultipleArrays {

    /**
     * @param args the command line arguments
     */
    
    public List<Integer> intersection(int[][] nums) {
        int[] arr=new int[1000];
        for(int[] i: nums) {
            for(int j: i) {
                arr[j-1]++;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==nums.length) {
                list.add(i+1);
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        IntersectionOfMultipleArrays i=new IntersectionOfMultipleArrays();
        System.out.println(i.intersection(new int[][]{{3,1,2,4,5},{1,2,3,4},{3,4,5,6}}));
        System.out.println(i.intersection(new int[][]{{1,2,3},{4,5,6}}));
    }
}
