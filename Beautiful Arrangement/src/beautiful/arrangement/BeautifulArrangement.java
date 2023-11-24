/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautiful.arrangement;

import java.util.Arrays;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class BeautifulArrangement {

    /**
     * @param args the command line arguments
     */
    
//    ---------------OPTIMAL -> O(K), O(N)-----------
//    public int countArrangement(int n) {
//        return count(new boolean[n], 1);
//    }
//    
//    private int count(boolean[] visited, int i) {
//        if(i==visited.length+1) {
//            return 1;
//        }
//        int count=0;
//        for(int j=0; j<visited.length; j++) {
//            if(!visited[j] && ((j+1)%i==0 || i%(j+1)==0)) {
//                visited[j]=true;
//                count+=count(visited, i+1);
//                visited[j]=false;
//            }
//        }
//        return count;
//    }
    
    
//    ---------------OPTIMAL -> O(K), O(N)-----------
    public int countArrangement(int n) {
        return count(0, 1, n);
    }
    
    private int count(int visited, int i, int n) {
        if(i==n+1) {
            return 1;
        }
        int count=0;
        for(int j=0; j<n; j++) {
            if((visited&(1<<j))==0 && ((j+1)%i==0 || i%(j+1)==0)) {
                visited^=(1<<j);
                count+=count(visited, i+1, n);
                visited^=(1<<j);
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        BeautifulArrangement b=new BeautifulArrangement();
//        System.out.println(b.countArrangement(1));
//        System.out.println(b.countArrangement(2));
//        System.out.println(b.countArrangement(3));
//        System.out.println(b.countArrangement(4));
        System.out.println(b.countArrangement(5));
//        System.out.println(b.countArrangement(6));
//        System.out.println(b.countArrangement(7));
//        System.out.println(b.countArrangement(8));
//        System.out.println(b.countArrangement(9));
//        System.out.println(b.countArrangement(10));
//        System.out.println(b.countArrangement(11));
//        System.out.println(b.countArrangement(12));
//        System.out.println(b.countArrangement(13));
//        System.out.println(b.countArrangement(14));
//        System.out.println(b.countArrangement(15));
    }
}
