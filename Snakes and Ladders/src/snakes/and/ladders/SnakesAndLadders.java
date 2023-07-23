/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.and.ladders;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class SnakesAndLadders {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------------OPTIMAL -> O(N^2), O(N^2)------------------------
    public int snakesAndLadders(int[][] board) {
        int count=0;
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[board.length*board[0].length+6];
        queue.add(1);
        visited[1]=true;
        while(!queue.isEmpty()) {
            count++;
            int size=queue.size();
            while(size>0) {
                int temp=queue.poll();
                for(int i=6; i>=1; i--) {
                    int posVal=getValue(board, temp+i);
                    if(posVal>=board.length*board.length) {
                        return count;
                    }
                    if(!visited[posVal]) {
                        visited[posVal]=true;
                        queue.add(posVal);
                    }
                }
                size--;
            }
        }
        return -1;
    }
    
    private int getValue(int[][] board, int i) {
        if(i>board.length*board.length) return i;
        int n=board.length;
        int row=n-1-(i-1)/n;
        int col=(i-1)/n%2==0 ? (i-1)%n : n-1-(i-1)%n;
        return board[row][col]==-1 ? i : board[row][col];
    }
    
    
//    ------------------OPTIMAL -> O(N^2), O(N^2)------------------------
//    public int snakesAndLadders(int[][] board) {
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int i=board.length-1; i>=0; i--) {
//            boolean fromBeg=(board.length-1-i)%2==0;
//            for(int j=0; j<board[i].length; j++) {
//                if(board[i][j]==-1) {
//                    continue;
//                }
//                int place=0;
//                if(fromBeg) {
//                    place=((board.length-1-i)*board[0].length)+j+1;
//                } else {
//                    place=((board.length-1-i)*board[0].length)+(board[i].length-1-j+1);
//                }
//                if(place!=board[i][j]) {
//                    map.put(place, board[i][j]);
//                }
//            }
//        }
//        int count=0;
//        Queue<Integer> queue=new LinkedList<>();
//        boolean[] visited=new boolean[board.length*board[0].length+6];
//        queue.add(1);
//        visited[1]=true;
//        while(!queue.isEmpty()) {
//            count++;
//            int size=queue.size();
//            while(size>0) {
//                int temp=queue.poll();
//                for(int i=6; i>=1; i--) {
//                    int curr=temp+i;
//                    if(map.containsKey(curr)) {
//                        curr=map.get(curr);
//                    }
//                    if(visited[curr]) {
//                        continue;
//                    }
//                    if(curr>=board.length*board[0].length) {
//                        return count;
//                    }
//                    visited[curr]=true;
//                    queue.add(curr);
//                }
//                size--;
//            }
//        }
//        return -1;
//    }
    
    
    
//    ------------------OPTIMAL -> O(N^2), O(N^2)------------------------
//    public int snakesAndLadders(int[][] board) {
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int i=board.length-1; i>=0; i--) {
//            boolean fromBeg=(board.length-1-i)%2==0;
//            for(int j=0; j<board[i].length; j++) {
//                if(board[i][j]==-1) {
//                    continue;
//                }
//                int place=0;
//                if(fromBeg) {
//                    place=((board.length-1-i)*board[0].length)+j+1;
//                } else {
//                    place=((board.length-1-i)*board[0].length)+(board[i].length-1-j+1);
//                }
//                if(place!=board[i][j]) {
//                    map.put(place, board[i][j]);
//                }
//            }
//        }
//        int count=0;
//        Queue<Integer> queue=new LinkedList<>();
//        Set<Integer> visited=new HashSet<>();
//        queue.add(1);
//        visited.add(1);
//        while(!queue.isEmpty()) {
//            count++;
//            int size=queue.size();
//            while(size>0) {
//                int temp=queue.poll();
//                for(int i=6; i>=1; i--) {
//                    int curr=temp+i;
//                    if(map.containsKey(curr)) {
//                        curr=map.get(curr);
//                    }
//                    if(visited.contains(curr)) {
//                        continue;
//                    }
//                    if(curr>=board.length*board[0].length) {
//                        return count;
//                    }
//                    visited.add(curr);
//                    queue.add(curr);
//                }
//                size--;
//            }
//        }
//        return -1;
//    }
    
    public static void main(String[] args) {
        SnakesAndLadders s=new SnakesAndLadders();
        System.out.println(s.snakesAndLadders(new int[][]{
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,35,-1,-1,13,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,15,-1,-1,-1,-1}
        }));
        
        System.out.println(s.snakesAndLadders(new int[][]{
            {-1,-1},
            {-1,3}
        }));
        
        System.out.println(s.snakesAndLadders(new int[][]{
            {1,1,-1},
            {1,1,1},
            {-1,1,1}
        }));
        
        System.out.println(s.snakesAndLadders(new int[][]{
            {-1,4,-1},
            {6,2,6},
            {-1,3,-1}
        }));
        
        System.out.println(s.snakesAndLadders(new int[][]{
            {-1,-1,30,14,15,-1},
            {23,9,-1,-1,-1,9},
            {12,5,7,24,-1,30},
            {10,-1,-1,-1,25,17},
            {32,-1,28,-1,-1,32},
            {-1,-1,23,-1,13,19}
        }));
    }
}
