/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiral.matrix.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class SpiralMatrixII {

    /**
     * @param args the command line arguments
     */
    
    public int[][] generateMatrix(int n) {
        int[][] arr=new int[n][n];
        int i=0;
        int j=n;
        int k=0;
        int l=n;
        int t=1;
        while(t<=n*n) {
            for(int a=k; a<l && t<=n*n; a++) {
                arr[i][a]=t++;
            }
            i++;
            for(int a=i; a<j && t<=n*n; a++) {
                arr[a][l-1]=t++;
            }
            l--;
            for(int a=l-1; a>k && t<=n*n; a--) {
                arr[j-1][a]=t++;
            }
            j--;
            for(int a=j; a>=i && t<=n*n; a--) {
                arr[a][k]=t++;
            }
            k++;
        }
        for(int[] a: arr) {
            for(int v: a) {
                System.out.print(v+" ");
            }
            System.out.println();
        }
        return arr;
    }
    
    
//    ------------------ALTERNATE -> OPTIMAL---------------------
//    public int[][] generateMatrix(int n) {
//        int[][] arr=new int[n][n];
//        int i=0;
//        int j=n;
//        int k=0;
//        int l=n;
//        int t=1;
//        while(i<j && k<l) {
//            for(int a=k; a<l; a++) {
//                arr[i][a]=t++;
//            }
//            i++;
//            for(int a=i; a<j; a++) {
//                arr[a][l-1]=t++;
//            }
//            l--;
//            if(i>=j || k>=l) continue;
//            for(int a=l-1; a>k; a--) {
//                arr[j-1][a]=t++;
//            }
//            j--;
//            for(int a=j; a>=i; a--) {
//                arr[a][k]=t++;
//            }
//            k++;
//        }
//        for(int[] a: arr) {
//            for(int v: a) {
//                System.out.print(v+" ");
//            }
//            System.out.println();
//        }
//        return arr;
//    }
    
    public static void main(String[] args) {
        SpiralMatrixII s=new SpiralMatrixII();
        s.generateMatrix(5);
    }
}
