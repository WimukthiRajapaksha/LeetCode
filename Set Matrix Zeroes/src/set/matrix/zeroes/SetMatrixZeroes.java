/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.matrix.zeroes;

/**
 *
 * @author wimukthirajapaksha
 */
public class SetMatrixZeroes {

    /**
     * @param args the command line arguments
     */
    
    public void setZeroes(int[][] matrix) {
        boolean isZeroCol=false;
        
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0]==0) isZeroCol=true;
            for(int j=1; j<matrix[i].length; j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=matrix.length-1; i>=0; i--) {
            for(int j=matrix[i].length-1; j>0; j--) {
                if(matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j]=0;
                }
            }
            if(isZeroCol) {
                matrix[i][0]=0;
            }
        }
        
        System.out.println();
        for(int[] i: matrix) {
            for(int j: i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    
    
//    ---------------------OPTIMAL -> LENGTHY-------------------
//    public void setZeroes(int[][] matrix) {
//        boolean isZeroCol=false;
//        
//        for(int i=0; i<matrix.length; i++) {
//            if(matrix[i][0]==0) {
//                isZeroCol=true;
//                break;
//            }
//        }
//        
//        for(int i=0; i<matrix.length; i++) {
//            for(int j=1; j<matrix[i].length; j++) {
//                if(matrix[i][j]==0) {
//                    matrix[i][0]=0;
//                    matrix[0][j]=0;
//                }
//            }
//        }
//        
//        for(int i=1; i<matrix.length; i++) {
//            for(int j=1; j<matrix[0].length; j++) {
//                if(matrix[i][0]==0 || matrix[0][j]==0) {
//                    matrix[i][j]=0;
//                }
//            }
//        }
//        
//        if(matrix[0][0]==0) {
//            for(int i=0; i<matrix[0].length; i++) {
//                matrix[0][i]=0;
//            }
//        }
//        
//        if(isZeroCol) {
//            for(int i=0; i<matrix.length; i++) {
//                matrix[i][0]=0;
//            }
//        }
//        
//        System.out.println();
//        for(int[] i: matrix) {
//            for(int j: i) {
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
//    }
    
    
    
//    ---------------------ALTERNATE -> NOT SPACE OPTIMAL AS REQUIRED IN THE PROBLEM-------------------
//    public void setZeroes(int[][] matrix) {
//        boolean[] row=new boolean[matrix.length];
//        boolean[] col=new boolean[matrix[0].length];
//        
//        for(int i=0; i<matrix.length; i++) {
//            for(int j=0; j<matrix[i].length; j++) {
//                if(matrix[i][j]==0) {
//                    row[i]=true;
//                    col[j]=true;
//                }
//            }
//        }
//        
//        for(int i=0; i<row.length; i++) {
//            if(row[i]) {
//                for(int j=0; j<matrix[i].length; j++) {
//                    matrix[i][j]=0;
//                }
//            }
//        }
//        for(int i=0; i<col.length; i++) {
//            if(col[i]) {
//                for(int j=0; j<matrix.length; j++) {
//                    matrix[j][i]=0;
//                }
//            }
//        }
//        
//        for(int[] i: matrix) {
//            for(int j: i) {
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
//    }
    
    
    public static void main(String[] args) {
        SetMatrixZeroes s=new SetMatrixZeroes();
        s.setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
        s.setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
        s.setZeroes(new int[][]{{1,0,3}});
        s.setZeroes(new int[][]{{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}});
    }
}
