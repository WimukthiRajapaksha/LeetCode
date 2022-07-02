/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teemo.attacking;

/**
 *
 * @author wimukthirajapaksha
 */
public class TeemoAttacking {

    /**
     * @param args the command line arguments
     */
    
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int t=0;
        for(int i=0; i<timeSeries.length-1; i++) {
            if(timeSeries[i]+duration<=timeSeries[i+1]) {
                t+=duration;
            } else {
                t+=timeSeries[i+1]-timeSeries[i];
            }
        }
        t+=duration;
        return t;
    }
    
    public static void main(String[] args) {
        TeemoAttacking t=new TeemoAttacking();
        System.out.println(t.findPoisonedDuration(new int[]{1,4}, 2));
        System.out.println(t.findPoisonedDuration(new int[]{1,2}, 2));
        System.out.println(t.findPoisonedDuration(new int[]{1,2,3,4,5,6,7,8,9}, 1));
        System.out.println(t.findPoisonedDuration(new int[]{1,2,3,4,5}, 5));
    }
}
