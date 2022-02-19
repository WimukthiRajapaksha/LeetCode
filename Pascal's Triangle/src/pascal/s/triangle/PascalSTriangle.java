/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.s.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class PascalSTriangle {

    /**
     * @param args the command line arguments
     */
    
//    ---------------------ALTERNATE - RECURSIVE--------------------------------
//    public void gen(int i, List<List<Integer>> list) {
//        if (i==1) {
//            list.add(Arrays.asList(1));
//            return;
//        }
//        
//        gen(i-1, list);
//        List<Integer> li = new ArrayList<>();
//        for (int j=0; j<i; j++) {
//            if (j==0 || j==i-1) {
//                li.add(1);
//                continue;
//            }
//            li.add(list.get(i-2).get(j-1)+list.get(i-2).get(j));
//        }
//        list.add(li);
//    }
//    
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> list = new ArrayList<>();
//        gen(numRows, list);
//        System.out.println(list);
//        return list;
//    }
    
//    ---------------------ALTERNATE - ITERATIVE--------------------------------
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        int[] arr = new int[numRows];
//        for (int i=0; i<numRows; i++) {
//            temp.add(1);
//            arr[temp.size()-1]=1;
//            for (int j=i-1; j>0; j--) {
//                arr[j]=arr[j-1]+arr[j];
//                temp.set(j, arr[j]);
//            }
//            list.add(new ArrayList<>(temp));
//        }
//        System.out.println(list);
//        return list;
//    }
    
//    ---------------------ALTERNATE - ITERATIVE - USING ARRAY FOR LOOKUP--------------------------------
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        int[][] arr = new int[numRows][numRows];
//        for (int i=1; i<=numRows; i++) {
//            System.out.println(i);
//            temp = new ArrayList<>();
//            arr[i-1][0]=1;
//            temp.add(1);
//            for (int j=1; j<=i-1; j++) {
//                if (j==i-1) {
//                    temp.add(1);
//                    arr[i-1][j]=1;
//                    continue;
//                }
//                arr[i-1][j] = arr[i-2][j-1]+arr[i-2][j];
//                temp.add(arr[i-1][j]);
//            }
//            list.add(temp);
//            System.out.println(temp);
//        }
//        System.out.println(list);
//        return list;
//    }
    
//    ----------------------ITERATIVE - OPTIMAL--------------------------------
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        for (int i=0; i<numRows; i++) {
//            temp=new ArrayList<>();
//            for (int j=0; j<=i; j++) {
//                if (j==0||j==i) {
//                    temp.add(1);
//                    continue;
//                }
//                temp.add(list.get(list.size()-1).get(j)+list.get(list.size()-1).get(j-1));
//            }
//            list.add(temp);
//        }
//        System.out.println(list);
//        return list;
//    }
    
//    ----------------------ITERATIVE - OPTIMAL--------------------------------
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            temp=new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j==0||j==i) {
                    temp.add(1);
                    continue;
                }
                temp.add(prev.get(j)+prev.get(j-1));
            }
            prev=temp;
            list.add(temp);
        }
        System.out.println(list);
        return list;
    }
    
    public static void main(String[] args) {
        PascalSTriangle p = new PascalSTriangle();
        p.generate(5);
    }    
}
