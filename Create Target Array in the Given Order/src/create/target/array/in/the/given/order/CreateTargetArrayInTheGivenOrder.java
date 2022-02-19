/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create.target.array.in.the.given.order;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class CreateTargetArrayInTheGivenOrder {

    /**
     * @param args the command line arguments
     */
    
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] arr=new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            for (int j=arr.length-1; j>index[i]; j--) {
                arr[j]=arr[j-1];
            }
            arr[index[i]]=nums[i];
        }
        for (int i: arr) {
            System.out.print(i+" ");
        }
        return arr;
    }
    
//    public int[] createTargetArray(int[] nums, int[] index) {
//        List<Integer> list=new ArrayList<>();
//        for (int i=0; i<nums.length; i++) {
//            list.add(index[i], nums[i]);
//        }
//        System.out.println(list);
//        for (int i=0; i<list.size(); i++) {
//            nums[i]=list.get(i);
//        }
//        return nums;
//    }
    
    public static void main(String[] args) {
        CreateTargetArrayInTheGivenOrder c=new CreateTargetArrayInTheGivenOrder();
        c.createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1});
    }
}
