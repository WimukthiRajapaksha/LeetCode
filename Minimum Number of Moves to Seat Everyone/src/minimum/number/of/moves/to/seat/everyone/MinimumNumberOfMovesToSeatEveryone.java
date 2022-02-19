/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.number.of.moves.to.seat.everyone;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumNumberOfMovesToSeatEveryone {

    /**
     * @param args the command line arguments
     */
    
    public int minMovesToSeat(int[] seats, int[] students) {
        int count=0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i=0; i<seats.length; i++) {
            count+=Math.abs(seats[i]-students[i]);
        }
        System.out.println(count);
        return count;
    }
    
    public static void main(String[] args) {
        MinimumNumberOfMovesToSeatEveryone m=new MinimumNumberOfMovesToSeatEveryone();
        m.minMovesToSeat(new int[]{4,1,5,9}, new int[]{1,3,2,6});
        m.minMovesToSeat(new int[]{12,14,19,19,12}, new int[]{19,2,17,20,7});
    }
}
