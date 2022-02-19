/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.s.triangle.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author wimukthirajapaksha
 */
public class PascalSTriangleII {

    /**
     * @param args the command line arguments
     */
    
//    ------------------------------ITERATIVE -> USING ARRAY-----------------------------------
//    public List<Integer> getRow(int rowIndex) {
//        Integer[] array = new Integer[rowIndex+1];
//        for (int i=0; i<=rowIndex; i++) {
//            array[i]=1;
//            for (int j=i-1; j>0; j--) {
//                array[j]=array[j]+array[j-1];
//            }
//        }
//        return Arrays.asList(array);
//    }
    
//    ------------------------------ITERATIVE - USING TWO LISTS-----------------------------------
//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> array = new ArrayList<>();
//        List<Integer> prev = new ArrayList<>();
//        for (int i=0; i<=rowIndex; i++) {
//            array=new ArrayList<>();
//            for (int j=0; j<=i; j++) {
//                if (j==0||j==i) {
//                    array.add(1);
//                    continue;
//                }
//                array.add(prev.get(j)+prev.get(j-1));
//            }
//            prev=array;
//        }
//        System.out.println(array);
//        return array;
//    }
    
//    ------------------------------ITERATIVE-----------------------------------
//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> list = new ArrayList<>();
//        for (int i=0; i<=rowIndex; i++) {
//            list.add(1);
//            for (int j=i-1; j>0; j--) {
//                list.set(j, list.get(j)+list.get(j-1));
//            }
//        }
//        return list;
//    }
    
//    ------------------------------RECURSIVE-----------------------------------
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex==0) {
            list.add(1);
            return list;
        }
        list = getRow(rowIndex-1);
        list.add(1);
        for (int i=list.size()-2; i>0; i--) {
            list.set(i, list.get(i)+list.get(i-1));
        }
        return list;
    }
    
    public static void main(String[] args) {
        PascalSTriangleII p = new PascalSTriangleII();
        p.getRow(5);
    }
}
