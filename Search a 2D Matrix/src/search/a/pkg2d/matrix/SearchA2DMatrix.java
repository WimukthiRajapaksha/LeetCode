/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.a.pkg2d.matrix;

/**
 *
 * @author wimukthirajapaksha
 */
public class SearchA2DMatrix {

    /**
     * @param args the command line arguments
     */
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target>matrix[matrix.length-1][matrix[0].length-1] || target<matrix[0][0]) return false;
        return bst(matrix, 0, (matrix.length*matrix[0].length)-1, target);
    }
    
    public boolean bst(int[][] matrix, int i, int j, int t) {
        if(i>j) return false;
        int m=i+(j-i)/2;
        if(matrix[m/matrix[0].length][m%matrix[0].length]==t) return true;
        else if (matrix[m/matrix[0].length][m%matrix[0].length]<t) return bst(matrix, m+1, j, t);
        else return bst(matrix, i, m-1, t);
    }
    
    
//    ---------------------------ALTERNATE -> NOT OPTIMAL FOR LARGER SIZED INPUTS------------------------------
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int i=0;
//        int j=matrix[0].length-1;
//        while(i<matrix.length && j>=0) {
//            if(matrix[i][j]==target) return true;
//            else if (matrix[i][j]<target) i++;
//            else j--;
//        }
//        return false;
//    }
    
    public static void main(String[] args) {
        SearchA2DMatrix s=new SearchA2DMatrix();
        System.out.println(s.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 60));
//        System.out.println(s.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
    }
}
