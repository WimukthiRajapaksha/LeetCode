/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unique.paths;

/**
 *
 * @author wimukthirajapaksha
 */
public class UniquePaths {

    /**
     * @param args the command line arguments
     */
    
    public int uniquePaths(int m, int n) {
        int[] arr=new int[n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 || j==0) {
                    arr[j]=1;
                    continue;
                }
                arr[j]+=arr[j-1];
            }
        }
        return arr[n-1];
    }
    
//    -----------------ALTERNATE -> OPTIMAL-------------------
//    public int uniquePaths(int m, int n) {
//        int[][] arr=new int[m][n];
//        for(int i=0; i<m; i++) {
//            for(int j=0; j<n; j++) {
//                if(i==0 || j==0) {
//                    arr[i][j]=1;
//                    continue;
//                }
//                arr[i][j]=arr[i][j-1]+arr[i-1][j];
//            }
//        }
//        return arr[m-1][n-1];
//    }
    
    
//    -----------------ALTERNATE -> OPTIMAL-------------------
//    public int uniquePaths(int m, int n) {
//        int[][] arr=new int[m][n];
//        for(int i=0; i<n; i++) {
//            arr[0][i]=1;
//        }
//        for(int i=0; i<m; i++) {
//            arr[i][0]=1;
//        }
//        for(int i=1; i<m; i++) {
//            for(int j=1; j<n; j++) {
//                arr[i][j]=arr[i][j-1]+arr[i-1][j];
//            }
//        }
//        return arr[m-1][n-1];
//    }
    
    
//    --------------------ALTERNATE -> NOT OPTIMAL--------------------
//    public int uniquePaths(int m, int n) {
//        if(m==1 || n==1) {
//            return 1;
//        }
//        int t=0;
//        t+=uniquePaths(m-1, n);
//        t+=uniquePaths(m, n-1);
//        return t;
//    }
    
    public static void main(String[] args) {
        UniquePaths u=new UniquePaths();
        System.out.println(u.uniquePaths(3, 7));
        System.out.println(u.uniquePaths(3, 2));
        System.out.println(u.uniquePaths(51, 9));
    }
}
