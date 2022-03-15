/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid.sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class ValidSudoku {

    /**
     * @param args the command line arguments
     */
    
//    --------------OPTIMAL -> BEAUTIFUL-----------------
    public boolean isValidSudoku(char[][] board) {
        int[] row=new int[9];
        int[] col=new int[9];
        int[] box=new int[9];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j]=='.') continue;
                int v=1<<board[i][j]-'1';
                if((row[i]&v) == 0) row[i]|=v;
                else return false;
                
                if((col[j]&v)==0) col[j]|=v;
                else return false;
                
                int p=3*(i/3)+(j/3);
                if((box[p]&v)==0) box[p]|=v;
                else return false;
            }
        }
        return true;
    }
    
//    ------------------------NICE---------------------
//    public boolean isValidSudoku(char[][] board) {
//        Set<String> set=new HashSet<>();
//        for(int i=0; i<9; i++) {
//            for(int j=0; j<9; j++) {
//                if(board[i][j]=='.') continue;
//                String s="("+board[i][j]+")";
//                if (!set.add(s+i) || !set.add(j+s) || !set.add((i/3)+s+(j/3))) return false;
//            }
//        }
//        return true;
//    }

      
    
    
//    -------------------NOT NICE---------------------
//    public boolean isValidSudoku(char[][] board) {
//        int[] co=new int[9];
//        for(char[] c: board) {
//            for(char cc: c) {
//                if(cc=='.') continue;
//                if(co[cc-'1']!=0) return false;
//                co[cc-'1']++;
//            }
//            co=new int[9];
//        }
//        for(int i=0; i<board[0].length; i++) {
//            for(char[] cc: board) {
//                if(cc[i]=='.') continue;
//                if(co[cc[i]-'1']!=0) return false;
//                co[cc[i]-'1']++;
//            }
//            co=new int[9];
//        }
//        for(int i=0; i<3; i++) {
//            for(int j=0; j<3; j++) {
//                for(int k=0; k<3; k++) {
//                    for(int l=0; l<3; l++) {
//                        if(board[(3*i)+k][(3*j)+l]=='.') continue;
//                        if(co[board[(3*i)+k][(3*j)+l]-'1']!=0) return false;
//                        co[board[(3*i)+k][(3*j)+l]-'1']++;
//                    }
//                }
//                co=new int[9];
//            }
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        ValidSudoku v=new ValidSudoku();        
        System.out.println(v.isValidSudoku(new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        }));
        
        System.out.println(v.isValidSudoku(new char[][]{
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        }));
    }
}
