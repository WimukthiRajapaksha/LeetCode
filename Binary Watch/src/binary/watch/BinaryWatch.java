/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.watch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class BinaryWatch {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------------------------OPTIMAL -> BACK TRACKING AND IMPRESSIVE APPROACH-------------------------
    int[] watch = {1,2,4,8,1,2,4,8,16,32};
    
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> l=new ArrayList<>();
        rec(l, turnedOn, 0, 0, 0);
        return l;
    }
    
    private void rec(List<String> list, int number, int start, int hours, int minutes) {
        if(number==0) {
            if(hours<12 && minutes<60) {
                StringBuffer sb=new StringBuffer();
                sb.append(hours).append(":").append(minutes<10 ? "0":"").append(minutes);
                list.add(sb.toString());
            }
        } else {
            for(int i=start; i<watch.length; i++) {
                if(i<4) {
                    rec(list, number-1, i+1, hours+watch[i], minutes);
                } else {
                    rec(list, number-1, i+1, hours, minutes+watch[i]);
                }
            }
        }
    }
    
    
    
    
    
//    ---------------------------OPTIMAL-------------------------
//    public List<String> readBinaryWatch(int turnedOn) {
//        List<String> l=new ArrayList<>();
//        for(int i=0; i<1024; i++) {
//            int h=i>>>6;
//            int m=(i&63);
//            if(h<12 && m<60 && Integer.bitCount(i)==turnedOn) {
//                StringBuffer sb=new StringBuffer();
//                sb.append(h).append(":").append(m<10 ? "0":"").append(m);
//                l.add(sb.toString());
//            }
//        }
//        return l;
//    }
    
    
    
    
//    ---------------------------OPTIMAL-------------------------
//    public List<String> readBinaryWatch(int turnedOn) {
//        List<String> l=new ArrayList<>();
//        if(turnedOn<0 || turnedOn>11) {
//            return l;
//        }
//        for(int h=0; h<12; h++) {
//            for(int m=0; m<60; m++) {
//                if(Integer.bitCount(h)+Integer.bitCount(m)==turnedOn) {
//                    StringBuffer sb=new StringBuffer();
//                    sb.append(h).append(":").append(m<10 ? "0":"").append(m);
//                    l.add(sb.toString());
//                }
//            }
//        }
//        return l;
//    }
    
    
    
    
    
//    ---------------------------OPTIMAL-------------------------
//    public List<String> readBinaryWatch(int turnedOn) {
//        List<String> l=new ArrayList<>();
//        if(turnedOn<0 || turnedOn>11) {
//            return l;
//        }
//        int h=0;
//        while(h<12) {
//            int c=Integer.bitCount(h);
//            for(int i=0; i<60; i++) {
//                if(c+Integer.bitCount(i)==turnedOn) {
//                    StringBuffer sb=new StringBuffer();
//                    sb.append(h).append(":").append(m<10 ? "0":"").append(m);
//                    l.add(sb.toString());
//                }
//            }
//            h++;
//        }
//        return l;
//    }
    
    
    
    
    
//    ----------------------------NOOB APPROACH--------------------------
//    public List<String> readBinaryWatch(int turnedOn) {
//        List<String> l=new ArrayList<>();
//        Map<Integer, List<Integer>> map=totMin();
//        int m=(turnedOn>5) ? 5: turnedOn;
//        int h=turnedOn-m;
//        while(m>=0) {
//            if(map.containsKey(h) && map.containsKey(m)) {
//                for(int i: map.get(h)) {
//                    if(i>11) {
//                        break;
//                    }
//                    for(int j: map.get(m)) {
//                        l.add(i+":"+String.format("%02d", j));
//                    }
//                }
//            }
//            m--;
//            h++;
//        }
//        return l;
//    }
//    
//    private Map<Integer, List<Integer>> totMin() {
//        Map<Integer, List<Integer>> map=new HashMap<>();
//        for(int j=0; j<60; j++) {
//            int c=0;
//            int t=0;
//            while((j>>>t)>0) {
//                if(((j>>>t)&1)==1) {
//                    c++;
//                }
//                t++;
//            }
//            if(map.containsKey(c)) {
//                map.get(c).add(j);
//            } else {
//                List<Integer> l=new ArrayList<>();
//                l.add(j);
//                map.put(c, l);
//            }
//        }
//        return map;
//    }
    
    public static void main(String[] args) {
        BinaryWatch b=new BinaryWatch();
        System.out.println(b.readBinaryWatch(1));
        System.out.println(b.readBinaryWatch(9));
        System.out.println(b.readBinaryWatch(2));
    }
}
