/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class WordSearch {

    /**
     * @param args the command line arguments
     */
    
//    boolean[][] visited;
//    public boolean exist(char[][] board, String word) {
//        visited = new boolean[board.length][board[0].length];
//        for(int i=0; i<board.length; i++) {
//            for(int j=0; j<board[i].length; j++) {
//                if(board[i][j]==word.charAt(0) && backtrack(i, j, board, word, 0)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    
//    private boolean backtrack(int i, int j, char[][] board, String word, int k) {
//        if(k==word.length()) return true;
//        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j]!=word.charAt(k) || visited[i][j]) return false;
//        char c=board[i][j];
//        visited[i][j]=true;
//        boolean ret=backtrack(i-1, j, board, word, k+1) || backtrack(i, j-1, board, word, k+1) || backtrack(i+1, j, board, word, k+1) || backtrack(i, j+1, board, word, k+1);
//        visited[i][j]=false;
//        return ret;
//    }
    
    
    
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j]==word.charAt(0) && backtrack(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(int i, int j, char[][] board, String word, int k) {
        if(k==word.length()) return true;
        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j]!=word.charAt(k)) return false;
        char c=board[i][j];
        board[i][j] ^= 256;
        boolean ret=backtrack(i-1, j, board, word, k+1) || backtrack(i, j-1, board, word, k+1) || backtrack(i+1, j, board, word, k+1) || backtrack(i, j+1, board, word, k+1);
        board[i][j] ^= 256;
        return ret;
    }
    
    public static void main(String[] args) {
        WordSearch w=new WordSearch();
        System.out.println(w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }
}
