/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elimination.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class EliminationGame {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------OPTIMAL -> O(LOGN), O(1)-----------------
    public int lastRemaining(int n) {
        int head=1;
        int step=1;
        boolean fromLeft=true;
        int remain=n;
        while(remain>1) {
            if(fromLeft || remain%2==1) {
                head+=step;
            }
            remain/=2;
            step*=2;
            fromLeft=!fromLeft;
        }
        return head;
    }
    
    
//    ----------------NOT OPTIMAL -> ERROR---------------------
//    public int lastRemaining(int n) {
//        int[] arr=new int[n];
//        for(int i=1; i<=n; i++) {
//            arr[i-1]=i;
//        }
//        return remove(arr, arr.length, true);
//    }
//    
//    public int remove(int[] arr, int index, boolean fromBegin) {
//        System.out.println(Arrays.toString(arr));
//        if(index==1) return arr[0];
//        int init=index;
//        if(fromBegin) {
//            if(index%2==0) {
//                index--;
//            }
//            for(int i=0; (i*2)+1<init; i++) {
//                arr[i]=arr[(i*2)+1];
//            }
//        } else {
//            int i=0;
//            if(index%2==1) {
//                i=1;
//            }
//            while(i<=index) {
//                arr[i/2]=arr[i];
//                i+=2;
//            }
//        }
//        return remove(arr, init/2, !fromBegin);
//    }
    
    public static void main(String[] args) {
        EliminationGame e=new EliminationGame();
        System.out.println(e.lastRemaining(9));
        System.out.println(e.lastRemaining(10));
        System.out.println(e.lastRemaining(1));
    }
}
