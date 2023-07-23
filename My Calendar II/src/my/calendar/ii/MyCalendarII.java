/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.calendar.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author wimukthirajapaksha
 */



class MyCalendarTwo {
    Map<Integer, Integer> map;

    public MyCalendarTwo() {
        map=new TreeMap<>((o1, o2)-> Integer.compare(o1, o2));
    }
    
    
//    -------------------------------OPTIMAL -> RUN N TIMES -> O(N^2), O(N)----------------------
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0)+1);
        map.put(end, map.getOrDefault(end, 0)-1);
        int count=0;
        for(int i: map.keySet()) {
            count+=map.get(i);
            if(count>2) {
                map.put(start, map.get(start)-1);
                map.put(end, map.get(end)+1);
                if(map.get(start)==0) map.remove(start);
                if(map.get(end)==0) map.remove(end);
                return false;
            }
        }
        return true;
    }
}


//class MyCalendarTwo {
//    List<int[]> once;
//    List<int[]> twice;
//
//    public MyCalendarTwo() {
//        once=new ArrayList<>();
//        twice=new ArrayList<>();
//    }
//    
//    
////    -------------------------------OPTIMAL -> RUN N TIMES -> O(N^2), O(N)----------------------
//    public boolean book(int start, int end) {
//        for(int[] t: twice) {
//            if(start<t[1] && t[0]<end) return false;
//        }
//        for(int[] o: once) {
//            if(start<o[1] && o[0]<end) {
//                twice.add(new int[]{Math.max(start, o[0]), Math.min(end, o[1])});
//            }
//        }
//        once.add(new int[]{start, end});
//        return true;
//    }
//}

public class MyCalendarII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyCalendarTwo m=new MyCalendarTwo();
        System.out.println(m.book(10, 20));
        System.out.println(m.book(50, 60));
        System.out.println(m.book(10, 40));
        System.out.println(m.book(5, 15));
        System.out.println(m.book(5, 10));
        System.out.println(m.book(25, 55));
    }
}
