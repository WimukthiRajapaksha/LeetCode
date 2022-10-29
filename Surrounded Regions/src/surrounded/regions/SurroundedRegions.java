/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surrounded.regions;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class SurroundedRegions {

    /**
     * @param args the command line arguments
     */
    
    int[][] directions;
    public void solve(char[][] board) {
        directions = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
        for(int i=0; i<board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length-1, i);
        }
        for(int i=1; i<board.length-1; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length-1);
        }
        for(char[] c: board) {
            for(int i=0; i<c.length; i++) {
                if(c[i]=='Z') {
                    c[i]='O';
                } else if(c[i]=='O') {
                    c[i]='X';
                }
            }
        }
    }
    
    private void dfs(char[][] b, int i, int j) {
        if(i==-1 || j==-1 || i==b.length || j==b[0].length || b[i][j]!='O') {
            return;
        }
        b[i][j]='Z';
        for(int[] d: directions) {
            dfs(b, i+d[0], j+d[1]);
        }
    }
    
    public static void main(String[] args) {
        SurroundedRegions s=new SurroundedRegions();
        char[][] arr=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        s.solve(arr);
        for(char[] c: arr) {
            System.out.println(Arrays.toString(c));
        }
        System.out.println();
        arr=new char[][]{{'X'}};
        s.solve(arr);
        for(char[] c: arr) {
            System.out.println(Arrays.toString(c));
        }
    }
}
