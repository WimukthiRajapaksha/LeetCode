/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roman.to.integer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class RomanToInteger {

    /**
     * @param args the command line arguments
     */
    
    public int romanToInt(String s) {
        int curr = 0;
        int sum=0;
        for (int i=s.length()-1; i>=0; i--) {
            switch(s.charAt(i)) {
                case 'I':
                    curr = 1;
                    break;
                case 'V':
                    curr = 5;
                    break;
                case 'X':
                    curr = 10;
                    break;
                case 'L':
                    curr = 50;
                    break;
                case 'C':
                    curr = 100;
                    break;
                case 'D':
                    curr = 500;
                    break;
                case 'M':
                    curr = 1000;
                    break;
            }
            if (4*curr<sum) {
                sum-=curr;
            } else {
                sum+=curr;
            }
        }
        System.out.println(sum);
        return sum;
        
        
//        -----------------------ALTERNATES-----------------------
//        Map<Character, Integer> map = new HashMap<>();
//        map.put('I', 1);
//        map.put('V', 5);
//        map.put('X', 10);
//        map.put('L', 50);
//        map.put('C', 100);
//        map.put('D', 500);
//        map.put('M', 1000);
//        
//        int sum=map.get(s.charAt(s.length()-1));
//        for (int i=0; i<s.length()-1; i++) {
//            if (map.get(s.charAt(i))<map.get(s.charAt(i+1))) {
//                sum-=map.get(s.charAt(i));
//            } else {
//                sum+=map.get(s.charAt(i));
//            }
//        }
//        sum+=map.get(s.charAt(s.length()-1));
//        System.out.println(sum);
//
////        for (int i=s.length()-1; i>0; i--) {
////            if (map.get(s.charAt(i))>map.get(s.charAt(i-1))) {
////                sum-=map.get(s.charAt(i-1));
////            } else {
////                sum+=map.get(s.charAt(i-1));
////            }
//////            System.out.println(sum+" "+s.charAt(i-1));
////        }
//////        sum+=map.get(s.charAt(s.length()-1));
////        System.out.println(sum);
//        return sum;

            
        
        
        
        
        
        
        
//        Map<Character, Integer> map = new HashMap<>();
//        map.put('I', 1);
//        map.put('V', 5);
//        map.put('X', 10);
//        map.put('L', 50);
//        map.put('C', 100);
//        map.put('D', 500);
//        map.put('M', 1000);        
//        
//        int[] list = new int[s.length()];
//        
//        for (int i=0; i<s.length(); i++) {
//            list[i]=map.get(s.charAt(i));
//        }
//        for (int i: list) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        int sum=0;
//        int i=0;
//        while(i<list.length) {
//            System.out.println(list[i]+" "+i);
//            if(i<list.length-1 && list[i]*10>=list[i+1] && list[i]<list[i+1]) {
//                sum+=list[i+1]-list[i];
//                i+=2;
//            } else {
//                sum+=list[i];
//                i++;
//            }
//        }
//        System.out.println(sum);
//        return 0;
        
        
        
        
//        Map<Character, Integer> map = new HashMap<>();
//        map.put('I', 1);
//        map.put('V', 5);
//        map.put('X', 10);
//        map.put('L', 50);
//        map.put('C', 100);
//        map.put('D', 500);
//        map.put('M', 1000);
//        
//        int val = 0;
//        int pre = 0;
//        int i=0;
//        while(i<s.length()) {
//            if(pre*10>=map.get(s.charAt(i)) && pre<map.get(s.charAt(i))) {
//                val+=map.get(s.charAt(i))-pre;
//                pre=0;
//            } else {
//                val+=pre;
//                pre=map.get(s.charAt(i));
//            }
//            i++;
//            System.out.println(val);
//        }
//        val+=pre;
//        System.out.println(val);
//        return val;
    }
    
    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();
        r.romanToInt("LVIII");
        System.out.println("-----------");
        r.romanToInt("MCMXCIV");
    }
}
