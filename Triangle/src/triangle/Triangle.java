/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class Triangle {

    /**
     * @param args the command line arguments
     */
    
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] val=new int[triangle.get(triangle.size()-1).size()];
        for(int i=0; i<val.length; i++) {
            val[i]=triangle.get(triangle.size()-1).get(i);
        }
        for(int i=triangle.size()-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                val[j] = triangle.get(i).get(j)+Math.min(val[j], val[j+1]);
            }
        }
        return val[0];
    }
    
    
    
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int[] val=new int[triangle.get(triangle.size()-1).size()];
//        for(int i=0; i<val.length; i++) {
//            val[i]=triangle.get(triangle.size()-1).get(i);
//        }
//        for(int i=triangle.size()-2; i>=0; i--) {
//            for(int j=0; j<=i; j++) {
//                val[j] = triangle.get(i).get(j)+Math.min(val[j], val[j+1]);
//            }
//        }
//        return val[0];
//    }
    
    
    
//    public int minimumTotal(List<List<Integer>> triangle) {
//        for(int i=triangle.size()-2; i>=0; i--) {
//            for(int j=0; j<triangle.get(i).size(); j++) {
//                triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
//            }
//        }
//        return triangle.get(0).get(0);
//    }
    
    public static void main(String[] args) {
        Triangle t=new Triangle();
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        l1.add(2);
        List<Integer> l2=new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3=new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4=new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);
        System.out.println(t.minimumTotal(l));
    }
}
