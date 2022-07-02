/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unique.binary.search.trees;

/**
 *
 * @author wimukthirajapaksha
 */
public class UniqueBinarySearchTrees {

    /**
     * @param args the command line arguments
     */
    
    public int numTrees(int n) {
        int[] arr=new int[n+1];
        arr[0]=1;
        for(int i=1; i<arr.length; i++) {
            int c=0;
            for(int j=i-1; j>=0; j--) {
                c+=(arr[j]*arr[i-1-j]);
            }
            arr[i]=c;
        }
        return arr[arr.length-1];
    }
    
    public static void main(String[] args) {
        UniqueBinarySearchTrees u=new UniqueBinarySearchTrees();
        System.out.println(u.numTrees(6));
    }
}
