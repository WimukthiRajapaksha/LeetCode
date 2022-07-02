/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insert.interval;

import java.util.LinkedList;

/**
 *
 * @author wimukthirajapaksha
 */
public class InsertInterval {

    /**
     * @param args the command line arguments
     */
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list=new LinkedList<>();
        int i=0;
        while(i<intervals.length && intervals[i][1]<newInterval[0]) {
            list.offer(intervals[i++]);
        }
        int[] uni=newInterval;
        while(i<intervals.length && intervals[i][0]<=newInterval[1]) {
            uni[0]=Math.min(uni[0], intervals[i][0]);
            uni[1]=Math.max(uni[1], intervals[i++][1]);
        }
        list.offer(uni);
        list.offer(uni);
        while(i<intervals.length) {
            list.offer(intervals[i++]);
        }
        int[][] arr=new int[list.size()][2];
        for(int j=0; j<list.size(); j++) {
            arr[j]=list.get(j);
        }
        return arr;
    }
    
//    -------------------ALTERNATE -> BUT SAME-------------------
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        LinkedList<int[]> list=new LinkedList<>();
//        int i=0;
//        while(i<intervals.length && intervals[i][1]<newInterval[0]) {
//            list.offer(intervals[i++]);
//        }
//        int[] uni=newInterval;
//        while(i<intervals.length && intervals[i][0]<=newInterval[1]) {
//            uni[0]=Math.min(uni[0], intervals[i][0]);
//            uni[1]=Math.max(uni[1], intervals[i++][1]);
//        }
//        list.offer(uni);
//        while(i<intervals.length) {
//            list.offer(intervals[i++]);
//        }
//        for(int[] ii: list) {
//            System.out.println(ii[0]+" "+ii[1]);
//        }
//        System.out.println();
//        return list.toArray(new int[list.size()][]);
//    }
    
    public static void main(String[] args) {
        InsertInterval i=new InsertInterval();
        i.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        i.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
    }
}
