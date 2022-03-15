/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotate.image;

/**
 *
 * @author wimukthirajapaksha
 */
public class RotateImage {

    /**
     * @param args the command line arguments
     */
    
    public void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length/2; i++) {
            int[] t=matrix[i];
            matrix[i]=matrix[matrix.length-1-i];
            matrix[matrix.length-1-i]=t;
        }
        transpose(matrix);
    }
    
    private void transpose(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=i+1; j<matrix.length; j++) {
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
    }
    
    
    
//    public void rotate(int[][] matrix) {
//        this.transpose(matrix);
//        this.swap(matrix);
//        
//        for(int[] i: matrix) {
//            for(int j: i) {
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//    
//    private void swap(int[][] matrix) {
//        for(int i=0; i<matrix.length; i++) {
//            for(int j=0; j<matrix.length/2; j++) {
//                int t=matrix[i][j];
//                matrix[i][j]=matrix[i][matrix.length-1-j];
//                matrix[i][matrix.length-1-j]=t;
//            }
//        }
//    }
//    
//    private void transpose(int[][] matrix) {
//        for(int i=0; i<matrix.length; i++) {
//            for(int j=i+1; j<matrix.length; j++) {
//                int t=matrix[i][j];
//                matrix[i][j]=matrix[j][i];
//                matrix[j][i]=t;
//            }
//        }
//    }
    
    public static void main(String[] args) {
        RotateImage r=new RotateImage();
        r.rotate(new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}});
        r.rotate(new int[][]{{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}});
        r.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
