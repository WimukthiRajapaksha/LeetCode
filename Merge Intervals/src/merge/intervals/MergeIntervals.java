/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class MergeIntervals {

    /**
     * @param args the command line arguments
     */
    
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list=new LinkedList<>();
        for(int[] i: intervals) {
            if(list.isEmpty() || (list.getLast()[1]<i[0])) {
                list.add(i);
            } else {
                list.getLast()[1]=Math.max(list.getLast()[1], i[1]);
            }
        }
        for(int[] i: list) {
            System.out.print(i[0]+" "+i[1]+" -> ");
        }
        System.out.println();
        return list.toArray(new int[list.size()][]);
    }
    
    public static void main(String[] args) {
        MergeIntervals m=new MergeIntervals();
        m.merge(new int[][]{{1,3},{2,6},{1,10},{15,18}});
        m.merge(new int[][]{{1,4},{4,5}});
        m.merge(new int[][]{{1,4},{5,6}});
    }
}
