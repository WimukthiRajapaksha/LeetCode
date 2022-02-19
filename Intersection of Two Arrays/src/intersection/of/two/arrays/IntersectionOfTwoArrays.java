/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intersection.of.two.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class IntersectionOfTwoArrays {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------------------OPTIMAL -> ALTERNATE-------------------
//    public int[] intersection(int[] nums1, int[] nums2) {
//        int[] f=new int[1001];
//        int c=0;
//        for(int i: nums1) {
//            if(f[i]==0) f[i]=1;
//        }
//        for(int i: nums2) {
//            if(f[i]==1) {
//                f[i]=2;
//                c++;
//            }
//        }
//        int[] r=new int[c];
//        int j=0;
//        for(int i=0; i<f.length; i++) {
//            if(f[i]==2) {
//                r[j++]=i;
//            }
//        }
//        return r;
//    }
    
    
    
//    ---------------------OPTIMAL -> ALTERNATE-------------------
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] f=new int[1001];
        Stack<Integer> s=new Stack<>();
        for(int i: nums1) f[i]=1;
        for(int i: nums2) {
            if(f[i]==1) {
                s.push(i);
                f[i]=0;
            }
        }
        int[] r=new int[s.size()];
        int i=0;
        while(!s.isEmpty()) r[i++]=s.pop();
        return r;
    }
    
    
    public static void main(String[] args) {
        
    }
}
