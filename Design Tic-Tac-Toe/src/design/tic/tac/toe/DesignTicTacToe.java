/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.tic.tac.toe;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */

//https://aaronice.gitbook.io/lintcode/data_structure/design-tic-tac-toe

class TicTacToe {
    int[] col;
    int[] row;
    int dia;
    int inDia;
    int n;
    public TicTacToe(int n) {
        col=new int[n];
        row=new int[n];
        this.n=n;
    }
    
    public int move(int row, int col, int player) {
        if(player==2) player=-1;
        this.row[col]+=player;
        this.col[row]+=player;
        if(row==col) dia+=player;
        if(row+col==n-1) {
            inDia+=player;
        }
        if(Math.abs(this.row[col])==n || Math.abs(this.col[row])==n || Math.abs(this.dia)==n || Math.abs(this.inDia)==n) {
            return player==-1 ? 2 : 1;
        }
        return 0;
    }
}




//class TicTacToe {
//    char[][] arr;
//    public TicTacToe(int n) {
//        arr=new char[n][n];
//    }
//    
//    public int move(int row, int col, int player) {
//        arr[row][col]=(char)(player+64);
//        if(hasWon(row, col, arr.length)) {
//            return player;
//        }
//        return 0;
//    }
//
//    private boolean hasWon(int row, int col, int n) {
//        char c=arr[row][col];
//        boolean found = true;
//        for(int i=0; i<n; i++) {
//            if(arr[i][col] != c) {
//                found=false;
//                break;
//            }
//        }
//        if(found) return true;
//        
//        found=true;
//        for(int i=0; i<n; i++) {
//            if(arr[row][i] != c) {
//                found=false;
//                break;
//            }
//        }
//        if(found) return true;
//        if(row==col) {
//            found=true;
//            for(int i=0; i<n; i++) {
//                if(arr[i][i]!=c) {
//                    found=false;
//                    break;
//                }
//            }
//            if(found) return true;
//        }
//        if(row+col==n-1) {
//            found=true;
//            for(int i=0; i<n; i++) {
//                if(arr[i][n-1-i]!=c) {
//                    found=false;
//                    break;
//                }
//            }
//            if(found) return true;
//        }
//        return false;
//    }
//}


public class DesignTicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        TicTacToe d=new TicTacToe(3);
//        d.move(0, 2, 2);
//        for(char[] c: d.arr) {
//            System.out.println(Arrays.toString(c));
//        }
//        System.out.println();
//        d.move(0, 1, 1);
//        for(char[] c: d.arr) {
//            System.out.println(Arrays.toString(c));
//        }
//        d.move(1, 2, 2);
//        System.out.println();
//        System.out.println(d.move(2, 2, 2));
//        for(char[] c: d.arr) {
//            System.out.println(Arrays.toString(c));
//        }
//        d.move(0, 1, 2);
    }
}
