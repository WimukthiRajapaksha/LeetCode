/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unique.paths.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class UniquePathsII {

    /**
     * @param args the command line arguments
     */
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int[] arr=new int[obstacleGrid[0].length];
        arr[0]=1;
        for(int i=0; i<obstacleGrid.length; i++) {
            for(int j=0; j<obstacleGrid[i].length; j++) {
                if(obstacleGrid[i][j]==1) {
                    arr[j]=0;
                } else if(j>0) {
                    arr[j]+=arr[j-1];
                }
            }
        }
        
        return arr[arr.length-1];
    }


//    -----------------ALTERNATE -> OPTIMAL-------------------
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int[][] arr=new int[obstacleGrid.length][obstacleGrid[0].length];
//        for(int i=0; i<obstacleGrid.length; i++) {
//            if(obstacleGrid[i][0]==1 || (i>0 && arr[i-1][0]==0)) {
//                arr[i][0]=0;
//            } else {
//                arr[i][0]=1;
//            }
//        }
//        for(int i=0; i<obstacleGrid[0].length; i++) {
//            if(obstacleGrid[0][i]==1 || (i>0 && arr[0][i-1]==0)) {
//                arr[0][i]=0;
//            } else {
//                arr[0][i]=1;
//            }
//        }
//        for(int i=1; i<arr.length; i++) {
//            for(int j=1; j<arr[i].length; j++) {
//                if(obstacleGrid[i][j]!=1) {
//                    arr[i][j]=arr[i-1][j]+arr[i][j-1];
//                }
//            }
//        }
//        
//        for(int i=0; i<arr.length; i++) {
//            for(int j=0; j<arr[i].length; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
//        
//        return arr[arr.length-1][arr[0].length-1];
//    }
    
    public static void main(String[] args) {
        UniquePathsII u=new UniquePathsII();
        System.out.println(u.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(u.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
    }
}
