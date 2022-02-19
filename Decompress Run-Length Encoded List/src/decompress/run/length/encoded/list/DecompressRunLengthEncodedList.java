/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decompress.run.length.encoded.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class DecompressRunLengthEncodedList {

    /**
     * @param args the command line arguments
     */
    
    public int[] decompressRLElist(int[] nums) {
        int cou=0;
        for (int i=0; i<nums.length; i+=2) {
            cou+=nums[i];
        }
        int[] list=new int[cou];
        for (int i=0,t=0; i<nums.length; i+=2) {
            for (int j=0; j<nums[i]; j++) {
                list[t++]=nums[i+1];
            }
        }
        for (int i: list) {
            System.out.print(i+" ");
        }
        System.out.println();
        return list;
    }
    
//    -------------------------ALTERNATE -> NOT OPTIMAL-------------------------
//    public int[] decompressRLElist(int[] nums) {
//        List<Integer> list=new ArrayList<>();
//        for (int i=0; i<nums.length; i+=2) {
//            for (int j=0; j<nums[i]; j++) {
//                list.add(nums[i+1]);
//            }
//        }
//        int[] l=new int[list.size()];
//        for (int i=0; i<list.size(); i++) {
//            l[i]=list.get(i);
//        }
//        return l;
//    }
    
    public static void main(String[] args) {
        DecompressRunLengthEncodedList d=new DecompressRunLengthEncodedList();
        d.decompressRLElist(new int[]{1,2,3,4});
        d.decompressRLElist(new int[]{1,1,2,3});
    }
}
