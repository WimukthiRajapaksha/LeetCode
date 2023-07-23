/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.queens;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class NQueens {

    /**
     * @param args the command line arguments
     */
    
//    ------------------------OPTIMAL, BIT MANIPULATION -> O(N!), O(N)------------------
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        char[][] arr=new char[n][n];
        for(char[] c: arr) {
            for(int i=0; i<c.length; i++) {
                c[i]='.';
            }
        }
        backtrack(list, arr, 0, 0, 0, 0);
        return list;
    }
    
    private void backtrack(List<List<String>> list, char[][] arr, int row, int positiveDiagonal, int negativeDiagonal, int t) {
        if(arr.length==t) {
            List<String> temp=new ArrayList<>();
            for(int i=0; i<arr.length; i++) {
                temp.add(String.valueOf(arr[i]));
            }
            list.add(temp);
            return;
        }
        for(int i=0; i<arr.length; i++) {
            if((positiveDiagonal & (1<<t+i))==0 && 
                    (negativeDiagonal & (1<<arr.length-1+t-i))==0 && 
                    (row& (1<<i))==0) {
                arr[t][i]='Q';
                row^=1<<i;
                positiveDiagonal^=1<<t+i;
                negativeDiagonal^=1<<arr.length-1+t-i;
                backtrack(list, arr, row, positiveDiagonal, negativeDiagonal, t+1);
                positiveDiagonal^=1<<t+i;
                negativeDiagonal^=1<<arr.length-1+t-i;
                arr[t][i]='.';
                row^=1<<i;
            }
        }
    }
    
    
//    ------------------------OPTIMAL -> O(N!), O(N)------------------
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> list=new ArrayList<>();
//        char[][] arr=new char[n][n];
//        for(char[] c: arr) {
//            for(int i=0; i<c.length; i++) {
//                c[i]='.';
//            }
//        }
//        backtrack(list, arr, new int[n], new int[2*n], new int[2*n], 0);
//        return list;
//    }
//    
//    private void backtrack(List<List<String>> list, char[][] arr, int[] row, int[] positiveDiagonal, int[] negativeDiagonal, int t) {
//        if(arr.length==t) {
//            List<String> temp=new ArrayList<>();
//            for(int i=0; i<arr.length; i++) {
//                temp.add(String.valueOf(arr[i]));
//            }
//            list.add(temp);
//            return;
//        }
//        for(int i=0; i<arr.length; i++) {
//            if(positiveDiagonal[t+i]==0 && negativeDiagonal[arr.length-1+t-i]==0 && row[i]==0) {
//                arr[t][i]='Q';
//                row[i]=1;
//                positiveDiagonal[t+i]=1;
//                negativeDiagonal[arr.length-1+t-i]=1;
//                backtrack(list, arr, row, positiveDiagonal, negativeDiagonal, t+1);
//                positiveDiagonal[t+i]=0;
//                negativeDiagonal[arr.length-1+t-i]=0;
//                arr[t][i]='.';
//                row[i]=0;
//            }
//        }
//    }
    
    
    
//    ------------------------OPTIMAL -> O(N*N!), O(N)------------------
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> list=new ArrayList<>();
//        char[][] arr=new char[n][n];
//        for(char[] c: arr) {
//            for(int i=0; i<c.length; i++) {
//                c[i]='.';
//            }
//        }
//        backtrack(list, new ArrayList<>(), arr, 0);
//        return list;
//    }
//    
//    private void backtrack(List<List<String>> list, List<Integer> places, char[][] arr, int t) {
//        if(arr.length==t) {
//            List<String> temp=new ArrayList<>();
//            for(int i=0; i<arr.length; i++) {
//                temp.add(String.valueOf(arr[i]));
//            }
//            list.add(temp);
//            return;
//        }
//        for(int i=0; i<arr.length; i++) {
//            arr[t][i]='Q';
//            places.add(i);
//            if(isValid(places)) {
//                backtrack(list, places, arr, t+1);
//            }
//            places.remove(places.size()-1);
//            arr[t][i]='.';
//        }
//    }
//    
//    private boolean isValid(List<Integer> places) {
//        int l=places.size()-1;
//        for(int i=0; i<places.size()-1; i++) {
//            int diff=Math.abs(places.get(i)-places.get(l));
//            if(diff==0 || diff==l-i) {
//                return false;
//            }
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        NQueens n=new NQueens();
        System.out.println(n.solveNQueens(4));
        System.out.println(n.solveNQueens(12));
    }
}
