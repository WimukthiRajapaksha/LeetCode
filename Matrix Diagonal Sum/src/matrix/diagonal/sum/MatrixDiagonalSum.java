/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.diagonal.sum;

/**
 *
 * @author wimukthirajapaksha
 */
public class MatrixDiagonalSum {

    /**
     * @param args the command line arguments
     */
    
    public int diagonalSum(int[][] mat) {
        int c=0;
        int i=0;
        int j=mat.length-1;
        for(int[] m: mat) {
            c+= (i==j) ? m[i] : m[i]+m[j];
            i++;
            j--;
        }
        System.out.println(c);
        return c;
    }
    
    public static void main(String[] args) {
        MatrixDiagonalSum m=new MatrixDiagonalSum();
//        m.diagonalSum(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
        m.diagonalSum(new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}});
    }
}
