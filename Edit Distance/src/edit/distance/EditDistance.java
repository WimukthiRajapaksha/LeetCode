/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edit.distance;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class EditDistance {

    /**
     * @param args the command line arguments
     */
    
//    -------------------------OPTIMAL, SPACE OPTIMIZED -> O(M*N), O(N)-------------------------
    public int minDistance(String word1, String word2) {
        int[] arr=new int[word2.length()+1];
        for(int i=0; i<arr.length; i++) {
            arr[i]=i;
        }
        for(int i=0; i<word1.length(); i++) {
            int prev=arr[0];
            arr[0]=i+1;
            for(int j=1; j<arr.length; j++) {
                if(word1.charAt(i)==word2.charAt(j-1)) {
                    int t=arr[j];
                    arr[j]=prev;
                    prev=t;
                } else {
                    int t=arr[j];
                    arr[j]=Math.min(arr[j], Math.min(arr[j-1], prev))+1;
                    prev=t;
                }
            }
        }
        return arr[arr.length-1];
    }
    
    
    
//    -------------------------OPTIMAL -> O(M*N), O(M*N)-------------------------
//    public int minDistance(String word1, String word2) {
//        int[][] arr=new int[word1.length()+1][word2.length()+1];
//        for(int i=0; i<arr.length; i++) {
//            arr[i][0]=i;
//        }
//        for(int i=0; i<arr[0].length; i++) {
//            arr[0][i]=i;
//        }
//        for(int i=1; i<arr.length; i++) {
//            for(int j=1; j<arr[i].length; j++) {
//                if(word1.charAt(i-1)==word2.charAt(j-1)) {
//                    arr[i][j]=arr[i-1][j-1];
//                } else {
//                    arr[i][j]=Math.min(arr[i-1][j-1], Math.min(arr[i][j-1], arr[i-1][j]))+1;
//                }
//            }
//        }
//        for(int[] i: arr) {
//            System.out.println(Arrays.toString(i));
//        }
//        return arr[arr.length-1][arr[0].length-1];
//    }
    
    public static void main(String[] args) {
        EditDistance e=new EditDistance();
        System.out.println(e.minDistance("horse", "ros"));
        System.out.println(e.minDistance("execution", "intention"));
    }
}
