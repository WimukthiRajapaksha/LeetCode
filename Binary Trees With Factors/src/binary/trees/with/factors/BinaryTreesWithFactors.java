/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.trees.with.factors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class BinaryTreesWithFactors {

    /**
     * @param args the command line arguments
     */
    
//    public int numFactoredBinaryTrees(int[] arr) {
//        long c=0;
//        Arrays.sort(arr);
//        Map<Integer, Long> map=new HashMap<>();
//        for(int i=0; i<arr.length; i++) {
//            long t=1;
//            for(int j=0; j<i; j++) {
//                if(arr[j]*arr[j]>arr[i]) break;
//                if(arr[i]%arr[j]==0 && map.containsKey(arr[i]/arr[j])) {
//                    if(arr[j]==arr[i]/arr[j]) {
//                        t+=map.get(arr[j])*map.get(arr[j]);
//                        continue;
//                    }
//                    t+=(2*map.get(arr[j])*map.get(arr[i]/arr[j]));
//                }
//            }
//            map.put(arr[i], t);
//            c=c+t;
//        }
//        return (int)(c%1000000007);
//    }
    
    
    public int numFactoredBinaryTrees(int[] arr) {
        long c=0;
        Arrays.sort(arr);
        Map<Integer, Long> map=new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            long t=1;
            for(int j=0; j<i; j++) {
                if(arr[i]%arr[j]==0 && map.containsKey(arr[i]/arr[j])) {
                    t+=(map.get(arr[j])*map.get(arr[i]/arr[j]));
                }
            }
            map.put(arr[i], t);
            c=c+t;
        }
        return (int)(c%1000000007);
    }
    
    public static void main(String[] args) {
        BinaryTreesWithFactors b=new BinaryTreesWithFactors();
        System.out.println(b.numFactoredBinaryTrees(new int[]{2,4,5,10}));
        System.out.println(b.numFactoredBinaryTrees(new int[]{2,4}));
        System.out.println(b.numFactoredBinaryTrees(new int[]{18,3,6,2}));
    }
}
