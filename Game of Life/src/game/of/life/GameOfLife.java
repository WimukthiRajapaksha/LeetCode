/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.of.life;

/**
 *
 * @author wimukthirajapaksha
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     */
    
//    ------------OPTIMAL -> O(M*N), O(1)-------------
    public void gameOfLife(int[][] board) {
        int[][] dir=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                int count=0;
                for(int[] d: dir) {
                    count += (i+d[0]>=0 && i+d[0]<board.length && j+d[1]>=0 && j+d[1]<board[0].length) ? (board[i+d[0]][j+d[1]]&1) : 0;
                }
                if((count | board[i][j])==3) {
                    board[i][j]|=2;
                }
            }
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                board[i][j]>>>=1;
            }
        }
    }
    
    public static void main(String[] args) {
        GameOfLife g=new GameOfLife();
        g.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
