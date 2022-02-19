/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package happy.number;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class HappyNumber {

    /**
     * @param args the command line arguments
     */
    
    public boolean isHappy(int n) {
        if(n==1) {
            return true;
        }
        int m=v(n);
        while(m!=n) {
            System.out.println(n+" "+m);
            n=v(n);
            m=v(v(m));
            if(m==1) return true;
        }
        return false;
    }
    
    public int v(int n) {
        int r=0;
        while(n>0) {
            r+=(n%10)*(n%10);
            n/=10;
        }
        return r;
    }
    
//    public boolean isHappy(int n) {
//        Set<Integer> set=new HashSet<>();
//        while(n<Integer.MAX_VALUE) {
//            System.out.println(set);
//            int i=0;
//            while(n>0) {
//                i+=(n%10)*(n%10);
//                n/=10;
//            }
//            System.out.println(i);
//            n=i;
//            System.out.println(n);
//            if (n==1) {
//                return true;
//            } else if(set.contains(n)) {
//                return false;
//            } else {
//                set.add(n);
//            }
//        }
//        return false;
//    }
    
//    public boolean isHappy(int n) {
//        Set<Integer> set=new HashSet<>();
//        while(n<Integer.MAX_VALUE) {
//            System.out.println(set);
//            n=v(n);
//            System.out.println(n);
//            if (n==1) {
//                return true;
//            } else if(set.contains(n)) {
//                return false;
//            } else {
//                set.add(n);
//            }
//        }
//        return false;
//    }
//    
//    public int v(int n) {
//        int r=0;
//        while(n>0) {
//            r+=(n%10)*(n%10);
//            n/=10;
//        }
//        return r;
//    }
    
    public static void main(String[] args) {
        HappyNumber h=new HappyNumber();
//        System.out.println(h.isHappy(19));
//        System.out.println(h.isHappy(2));
        System.out.println(h.isHappy(1));
    }
}
