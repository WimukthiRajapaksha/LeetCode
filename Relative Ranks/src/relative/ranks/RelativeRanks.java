/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relative.ranks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author wimukthirajapaksha
 */
public class RelativeRanks {

    /**
     * @param args the command line arguments
     */
    
//    -----------------ALTERNATE -> OPTIMAL----------------------
//    public String[] findRelativeRanks(int[] score) {
//        String[] ret=new String[score.length];
//        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(score[b], score[a]));
//        for(int i=0; i<score.length; i++) {
//            pq.offer(i);
//        }
//        int i=1;
//        while(!pq.isEmpty()) {
//            int val=pq.poll();
//            if(i==1) {
//                ret[val]="Gold Medal";
//            } else if(i==2) {
//                ret[val]="Silver Medal";
//            } else if(i==3) {
//                ret[val]="Bronze Medal";
//            } else {
//                ret[val]=String.valueOf(i);
//            }
//            i++;
//        }
//        for(String s: ret) {
//            System.out.println(s);
//        }
//        return ret;
//    }
    
    
//    -----------------ALTERNATE -> OPTIMAL----------------------
    public String[] findRelativeRanks(int[] score) {
        String[] ret=new String[score.length];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(b[0], a[0]));
        for(int i=0; i<score.length; i++) {
            pq.offer(new int[]{score[i], i});
        }
        int i=1;
        while(!pq.isEmpty()) {
            int[] val=pq.poll();
            if(i==1) {
                ret[val[1]]="Gold Medal";
            } else if(i==2) {
                ret[val[1]]="Silver Medal";
            } else if(i==3) {
                ret[val[1]]="Bronze Medal";
            } else {
                ret[val[1]]=String.valueOf(i);
            }
            i++;
        }
        for(String s: ret) {
            System.out.println(s);
        }
        return ret;
    }
    
    
    
//    -----------------ALTERNATE -> OPTIMAL----------------------
//    public String[] findRelativeRanks(int[] score) {
//        int[][] arr=new int[score.length][2];
//        for(int i=0; i<score.length; i++) {
//            arr[i][0]=score[i];
//            arr[i][1]=i;
//        }
//        Arrays.sort(arr, (a, b)->Integer.compare(b[0], a[0]));
//        String[] ret=new String[score.length];
//        for(int i=0; i<arr.length; i++) {
//            if(i==0) {
//                ret[arr[i][1]]="Gold Medal";
//            } else if(i==1) {
//                ret[arr[i][1]]="Silver Medal";
//            } else if(i==2) {
//                ret[arr[i][1]]="Bronze Medal";
//            } else {
//                ret[arr[i][1]]=String.valueOf(i+1);
//            }
//        }
//        for(String s: ret) {
//            System.out.println(s);
//        }
//        return ret;
//    }
    
    
    public static void main(String[] args) {
        RelativeRanks r=new RelativeRanks();
        r.findRelativeRanks(new int[]{5,4,3,2,1});
        System.out.println();
        r.findRelativeRanks(new int[]{10,3,8,9,4});
    }
}
