/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.recent.calls;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */


//--------  OPTIMAL -> O(N), O(N)-------------
//class RecentCounter {
//    private int prev=0;
//    private List<Integer> list;
//
//    public RecentCounter() {
//        list=new ArrayList<>();
//    }
//    
//    public int ping(int t) {
//        list.add(t);
//        while(list.get(prev)<t-3000) {
//            prev++;
//        }
//        return list.size()-prev;
//    }
//}



//--------  OPTIMAL -> O(N), O(N)-------------
//class RecentCounter {
//    private Queue<Integer> queue;
//
//    public RecentCounter() {
//        queue=new LinkedList<>();
//    }
//    
//    public int ping(int t) {
//        queue.offer(t);
//        while(queue.peek()<t-3000) {
//            queue.poll();
//        }
//        return queue.size();
//    }
//}



//--------  OPTIMAL -> O(N), O(N)-------------
class RecentCounter {
    private List<Integer> list;

    public RecentCounter() {
        list=new ArrayList<>();
    }
    
    public int ping(int t) {
        list.add(t);
        int l=0;
        int r=list.size()-1;
        while(l<r) {
            int m=l+(r-l)/2;
            if(list.get(m)<t-3000) {
                l=m+1;
            } else {
                r=m;
            }
        }
        return list.size()-l;
    }
}

public class NumberOfRecentCalls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RecentCounter r=new RecentCounter();
        System.out.println(r.ping(1));
        System.out.println(r.ping(100));
        System.out.println(r.ping(3001));
        System.out.println(r.ping(3002));
    }
}
