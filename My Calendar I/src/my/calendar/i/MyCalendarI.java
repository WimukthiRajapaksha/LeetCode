/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.calendar.i;

import java.util.ArrayList;
import java.util.List;


//class MyCalendar {
//    TreeMap<Integer, Integer> treeMap;
//    public MyCalendar() {
//        this.treeMap=new TreeMap<>();
//    }
//
//    public boolean book(int start, int end) {
//        int[] book=new int[]{start, end};
//        Integer floor=treeMap.floorKey(start);
//        Integer ceil=treeMap.ceilingKey(start);
//        if((floor!=null && treeMap.get(floor)>start) || (ceil!=null && ceil<end)) return false;
//        this.treeMap.put(start, end);
//        return true;
//    }
//}

//class MyCalendar {
//    TreeSet<int[]> treeSet;
//    public MyCalendar() {
//        this.treeSet=new TreeSet<>((o1,o2)->o1[0]-o2[0]);
//    }
//
//    public boolean book(int start, int end) {
//        int[] book=new int[]{start, end};
//        int[] floor=this.treeSet.floor(book);
//        int[] ceil=this.treeSet.ceiling(book);
//        if((floor!=null && floor[1]>start) || (ceil!=null && ceil[0]<end)) return false;
//        this.treeSet.add(book);
//        return true;
//    }
//}

class MyCalendar {
    List<int[]> list;
    public MyCalendar() {
        list=new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if(list.size()==0) {
            list.add(new int[]{start, end});
            return true;
        }
        int val=bs(0, list.size()-1, new int[]{start, end});
        boolean ret=true;
        if(val>0) ret&=list.get(val-1)[1]<=start;
        if(val<this.list.size()) {
            ret &= list.get(val)[0]>=end;
        }
        if(ret) list.add(val, new int[]{start, end});
        return ret;
    }

    private int bs(int l, int r, int[] t) {
        if(l>r) return l;
        int m=l+(r-l)/2;
        if(this.list.get(m)[1]<t[1]) {
            return bs(m+1, r, t);
        } else {
            return bs(l, m-1, t);
        }
    }
}

public class MyCalendarI {
    public static void main(String[] args) {
        MyCalendar m=new MyCalendar();
        System.out.println(m.book(10,20));
        System.out.println(m.book(15,25));
        System.out.println(m.book(20,30));
        System.out.println(m.book(5,40));
    }
}
