/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.number.of.teams;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountNumberOfTeams {

    /**
     * @param args the command line arguments
     */
    
    public int numTeams(int[] rating) {
        int val=calculate(rating);
        for(int i=0; i<rating.length/2; i++) {
            int temp=rating[i];
            rating[i]=rating[rating.length-1-i];
            rating[rating.length-1-i]=temp;
        }
        return val+calculate(rating);
    }
    
    private int calculate(int[] rating) {
        int[] less=new int[rating.length];
        int[] more=new int[rating.length];
        for(int i=0; i<rating.length; i++) {
            for(int j=0; j<i; j++) {
                if(rating[j]<rating[i]) {
                    less[i]++;
                }
            }
        }
        for(int i=rating.length-1; i>=0; i--) {
            for(int j=i+1; j<rating.length; j++) {
                if(rating[i]<rating[j]) {
                    more[i]++;
                }
            }
        }
        int count=0;
        for(int i=0; i<rating.length; i++) {
            count+=(less[i]*more[i]);
        }
        System.out.println(Arrays.toString(less));
        System.out.println(Arrays.toString(more));
        return count;
    }
    
    public static void main(String[] args) {
        CountNumberOfTeams c=new CountNumberOfTeams();
        System.out.println(c.numTeams(new int[]{1,2,3,4}));
        System.out.println(c.numTeams(new int[]{2,5,3,4,1}));
        System.out.println(c.numTeams(new int[]{2,1,3}));
    }
}
