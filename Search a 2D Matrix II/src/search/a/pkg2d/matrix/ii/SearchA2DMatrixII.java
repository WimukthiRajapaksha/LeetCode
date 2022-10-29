/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.a.pkg2d.matrix.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class SearchA2DMatrixII {

    /**
     * @param args the command line arguments
     */
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int c=0;
        int r=matrix[0].length-1;
        while(c<matrix.length && r>=0) {
            if(matrix[c][r]==target) return true;
            else if(matrix[c][r]<target) {
                c++;
            } else {
                r--;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        SearchA2DMatrixII s=new SearchA2DMatrixII();
        System.out.println(s.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
    }
}
