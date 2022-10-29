/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximal.square;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximalSquare {

    /**
     * @param args the command line arguments
     */
    
    
    
//    ------------------OPTIMAL -> O(M*N) -> O(N)-------------------
    public int maximalSquare(char[][] matrix) {
        int[] dp=new int[matrix[0].length+1];
        int max=0;
        int pre=0;
        for(int i=0; i<matrix.length; i++) {
            pre=0;
            for(int j=0; j<matrix[0].length; j++) {
                int t=dp[j+1];
                if(matrix[i][j]=='1') {
                    dp[j+1]=Math.min(Math.min(dp[j], dp[j+1]), pre)+1;
                    max=Math.max(max, dp[j+1]);
                } else {
                    dp[j+1]=0;
                }
                pre=t;
            }
        }
        return max*max;
    }
    
//    ------------------OPTIMAL -> O(M*N) -> O(M*N)-------------------
//    public int maximalSquare(char[][] matrix) {
//        int[][] dp=new int[matrix.length+1][matrix[0].length+1];
//        int max=0;
//        for(int i=0; i<matrix.length; i++) {
//            for(int j=0; j<matrix[i].length; j++) {
//                if(matrix[i][j]=='1') {
//                    dp[i+1][j+1]=Math.min(Math.min(dp[i+1][j], dp[i][j]), dp[i][j+1])+1;
//                    max=Math.max(max, dp[i+1][j+1]);
//                }
//            }
//        }
//        return max*max;
//    }
    
    
    
//    ------------------ALTERNATE -> NOT A GOOD SOLUTION -> O(M*N) -> O(1)-------------------
//    public int maximalSquare(char[][] matrix) {
//        int max=0;
//        for(int i=0; i<matrix.length; i++) {
//            for(int j=0; j<matrix[i].length; j++) {
//                if(i==0 || j==0) {
//                    max=Math.max(matrix[i][j]-'0', max);
//                    continue;
//                }
//                if(matrix[i][j]=='0') continue;
//                matrix[i][j]=(char)(Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i][j-1]))+1);
//                if(max<matrix[i][j]-'0') {
//                    max=matrix[i][j]-'0';
//                }
//            }
//        }
//        return max*max;
//    }
    
    public static void main(String[] args) {
        MaximalSquare m=new MaximalSquare();
        System.out.println(m.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        System.out.println(m.maximalSquare(new char[][]{{'0','1'},{'1','0'}}));
        System.out.println(m.maximalSquare(new char[][]{{'0','0','0','1','1','1','0'},{'0','0','0','1','1','1','0'},{'0','0','0','1','1','1','0'},{'0','1','1','1','1','1','1'}}));
    }
}


//'1','0','1','0','0'
//'1','0','1','1','1'
//'1','1','1','1','1'
//'1','0','0','1','0'