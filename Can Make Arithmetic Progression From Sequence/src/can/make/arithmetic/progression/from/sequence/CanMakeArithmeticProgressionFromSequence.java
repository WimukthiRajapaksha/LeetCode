/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package can.make.arithmetic.progression.from.sequence;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class CanMakeArithmeticProgressionFromSequence {

    /**
     * @param args the command line arguments
     */
    
//    -----------OPTIMAL -> O(N*LOG N), O(1)-------------
//    public boolean canMakeArithmeticProgression(int[] arr) {
//        Arrays.sort(arr);
//        int diff=arr[1]-arr[0];
//        for(int i=1; i<arr.length-1; i++) {
//            if(diff!=arr[i+1]-arr[i]) return false;
//        }
//        return true;
//    }
    
    
    
//    -----------OPTIMAL -> O(N), O(1)-------------
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i: arr) {
            if(min>i) min=i;
            if(max<i) max=i;
        }
        if((max-min)%(arr.length-1)!=0) return false;
        int diff=(max-min)/(arr.length-1);
        int i=0;
        while(i<arr.length) {
            if(arr[i]==min+(i*diff)) {
                i++;
            } else if((arr[i]-min)%diff!=0) return false;
            else {
                int newP=(arr[i]-min)/diff;
                if(arr[i]==arr[newP]) return false;
                int val=arr[newP];
                arr[newP]=arr[i];
                arr[i]=val;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        CanMakeArithmeticProgressionFromSequence c=new CanMakeArithmeticProgressionFromSequence();
        System.out.println(c.canMakeArithmeticProgression(new int[]{3,5,1}));
        System.out.println(c.canMakeArithmeticProgression(new int[]{1,2,4}));
    }
}
