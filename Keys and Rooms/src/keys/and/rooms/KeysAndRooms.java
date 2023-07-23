/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keys.and.rooms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class KeysAndRooms {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------------------OPTIMAL -> O(N+E), O(N)---------------------------
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        visited[0]=true;
        while(!stack.isEmpty()) {
            int temp=stack.pop();
            for(int i: rooms.get(temp)) {
                if(visited[i]) continue;
                visited[i]=true;
                stack.push(i);
            }
        }
        for(boolean b: visited) {
            if(!b) return false;
        }
        return true;
    }
    
    
    
    
    
//    ----------------------OPTIMAL -> O(N+E), O(N)---------------------------
//    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        boolean[] visited=new boolean[rooms.size()];
//        dfs(rooms, visited, 0);
//        for(boolean v: visited) {
//            if(!v) return false;
//        }
//        return true;
//    }
//    
//    private void dfs(List<List<Integer>> list, boolean[] visited, int i) {
//        visited[i]=true;
//        for(int j: list.get(i)) {
//            if(visited[j]) {
//                continue;
//            }
//            dfs(list, visited, j);
//        }
//    }
    
    
    
//    ----------------------OPTIMAL -> O(N+E), O(N)---------------------------
//    int t;
//    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        boolean[] visited=new boolean[rooms.size()];
//        visited[0]=true;
//        t=rooms.size()-1;
//        return dfs(rooms, visited, 0);
//    }
//    
//    private boolean dfs(List<List<Integer>> list, boolean[] visited, int i) {
//        if(t==0) return true;
//        for(int j: list.get(i)) {
//            if(visited[j]) {
//                continue;
//            }
//            visited[j]=true;
//            t--;
//            if(dfs(list, visited, j)) {
//                return true;
//            }
//        }
//        return false;
//    }
    
    public static void main(String[] args) {
        KeysAndRooms k=new KeysAndRooms();
        System.out.println(k.canVisitAllRooms(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));
        System.out.println(k.canVisitAllRooms(Arrays.asList(Arrays.asList(1,3), Arrays.asList(3,0,1), Arrays.asList(2), Arrays.asList(0))));
    }
}
