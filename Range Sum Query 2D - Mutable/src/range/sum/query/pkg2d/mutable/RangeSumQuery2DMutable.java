/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package range.sum.query.pkg2d.mutable;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */

class SegmentTree {
    int start, end;
    SegmentTree left, right;
    int sum;

    public SegmentTree(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }

    @Override
    public String toString() {
        return left+" "+sum+" "+right;
    }
}

class NumMatrix {
    SegmentTree[] mat;
    
    public NumMatrix(int[][] matrix) {
        mat=new SegmentTree[matrix.length];
        for(int i=0; i<matrix.length; i++) {
            mat[i]=build(matrix[i], 0, matrix[i].length-1);
        }
    }
    
    private SegmentTree build(int[] arr, int start, int end) {
        SegmentTree temp=new SegmentTree(start, end);
        if(start==end) {
            temp.sum=arr[start];
        } else {
            int mid=start+(end-start)/2;
            temp.left=build(arr, start, mid);
            temp.right=build(arr, mid+1, end);
            temp.sum=temp.left.sum+temp.right.sum;
        }
        return temp;
    }
    
    public void update(int row, int col, int val) {
        update(mat[row], col, val);
    }
    
    
//    ------------------------O(LOGN)------------------------------
    private void update(SegmentTree root, int position, int val) {
        if(root.start==root.end) {
            root.sum=val;
        } else {
            int mid=root.start+(root.end-root.start)/2;
            if(position<=mid) {
                update(root.left, position, val);
            } else {
                update(root.right, position, val);
            }
            root.sum=root.left.sum+root.right.sum;
        }
    }
    
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int s=0;
        for(int i=row1; i<=row2; i++) {
            s+=sumRegion(mat[i], col1, col2);
        }
        return s;
    }
    
    private int sumRegion(SegmentTree root, int start, int end) {
        if(root.start==start && root.end==end) {
            return root.sum;
        } else {
            int mid=root.start+(root.end-root.start)/2;
            if(end<=mid) {
                return sumRegion(root.left, start, end);
            } else if(start>=mid+1) {
                return sumRegion(root.right, start, end);
            } else {
                return sumRegion(root.left, start, mid)+sumRegion(root.right, mid+1, end);
            }
        }
    }
}

public class RangeSumQuery2DMutable {
    public static void main(String[] args) {
        NumMatrix n=new NumMatrix(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        System.out.println(n.sumRegion(2, 1, 4, 3));
        n.update(3, 2, 2);
        System.out.println(n.sumRegion(2, 1, 4, 3));
        
        NumMatrix nn=new NumMatrix(new int[][]{{0,-5,9,1,-8,5,8,1,1,5}});
        for(SegmentTree s: nn.mat) {
            System.out.println(s);
        }
        System.out.println(nn.sumRegion(0, 5, 0, 9));
        nn.update(0, 3, -1);
        for(SegmentTree s: nn.mat) {
            System.out.println(s);
        }
        System.out.println(nn.sumRegion(0, 3, 0, 6));
    }
}
