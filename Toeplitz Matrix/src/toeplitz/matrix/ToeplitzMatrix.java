/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toeplitz.matrix;

/**
 *
 * @author wimukthirajapaksha
 */
public class ToeplitzMatrix {

    /**
     * @param args the command line arguments
     */
    
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length==1 || matrix[0].length==1) return true;
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[i].length; j++) {
                if(matrix[i][j]!=matrix[i-1][j-1]) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        ToeplitzMatrix t=new ToeplitzMatrix();
        System.out.println(t.isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
        System.out.println(t.isToeplitzMatrix(new int[][]{{1,2},{2,2}}));
    }
}
