/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue.reconstruction.by.height;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author wimukthirajapaksha
 */
public class QueueReconstructionByHeight {

    /**
     * @param args the command line arguments
     */
    
//    -----------------OPTIMAL -> O((N*LOGN)+N^2), O(N)-----------
//    public int[][] reconstructQueue(int[][] people) {
//        int[][] queue=new int[people.length][2];
//        for(int i=0; i<queue.length; i++) {
//            queue[i]=new int[]{-1,-1};
//        }
//        Arrays.sort(people, (o1,o2)->Integer.compare(o1[0], o2[0]));
//
//        for(int[] p: people) {
//            System.out.println(Arrays.toString(p));
//            int nf=p[1];
//            int c=0;
//            while(nf>0 || (c<queue.length && queue[c][0]!=-1)) {
//                if(queue[c][0]==-1) nf--;
//                if(queue[c][0]==p[0]) nf--;
//                c++;
//            }
//            if(c<queue.length) queue[c]=p;
//        }
//        System.out.println();
//        return queue;
//    }
    
    
//    -----------------OPTIMAL -> O((N*LOGN)+N^2), O(N)-----------
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2)-> {
            if(o1[0]!=o2[0]) {
                return Integer.compare(o2[0], o1[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
        List<int[]> queue=new LinkedList<>();
        for(int[] p: people) {
            queue.add(p[1], p);
        }
        int[][] ret=new int[people.length][2];
        for(int i=0; i<ret.length; i++) {
            ret[i]=queue.get(i);
        }
        return ret;
    }
    
    public static void main(String[] args) {
        QueueReconstructionByHeight q=new QueueReconstructionByHeight();
        int[][] arr=q.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
        for(int[] a: arr) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
        arr=q.reconstructQueue(new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}});
        for(int[] a: arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}


//[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]

//
//
//
//
//
