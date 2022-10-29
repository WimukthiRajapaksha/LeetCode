/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kth.smallest.element.in.a.sorted.matrix;

/**
 *
 * @author wimukthirajapaksha
 */
public class KthSmallestElementInASortedMatrix {
//    ------------------OPTIMAL -> BINARY SEARCH------------
    public int kthSmallest(int[][] matrix, int k) {
        int low=matrix[0][0];
        int high=matrix[matrix.length-1][matrix[0].length-1];
        while(low<=high) {
            int mid=low+(high-low)/2;
            int count=0;
            int j=matrix[0].length-1;
            for(int i=0; i<matrix.length; i++) {
                while(j>=0 && mid<matrix[i][j]) j--;
                count+=(j+1);
            }
            if(count<k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }

//    ------------------OPTIMAL -> BINARY SEARCH -> NOT CLEAR TERMINATION CONDITION------------
//    public int kthSmallest(int[][] matrix, int k) {
//        int low=matrix[0][0];
//        int high=matrix[matrix.length-1][matrix[0].length-1];
//        while(low<=high) {
//            int mid=low+(high-low)/2;
//            int count=0;
//            int j=matrix[0].length-1;
//            int maxNumber=low;
//            for(int i=0; i<matrix.length; i++) {
//                while(j>=0 && matrix[i][j]>mid) j--;
//                count+=(j+1);
//                if(j>=0) maxNumber=Math.max(maxNumber, matrix[i][j]);
//            }
//            if(count==k) return maxNumber;
//            if(count<k) low=mid+1;
//            else high=mid-1;
//        }
//        return low;
//    }

//    ------------------ALTERNATE -> NOT OPTIMAL-----------------------
//    public int kthSmallest(int[][] matrix, int k) {
//        PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o2,o1));
//        for(int[] i: matrix) {
//            for(int j: i) {
//                pq.offer(j);
//                if(pq.size()>k) {
//                    pq.poll();
//                }
//            }
//        }
//        System.out.println(pq);
//        return pq.poll();
//    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix k=new KthSmallestElementInASortedMatrix();
        System.out.println(k.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));
    }
}
