/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane.seat.assignment.probability;

/**
 *
 * @author wimukthirajapaksha
 */
public class AirplaneSeatAssignmentProbability {

    /**
     * @param args the command line arguments
     */
    
    public double nthPersonGetsNthSeat(int n) {
        if(n==1) return 1.0;
        return nthPersonGetsNthSeat(n-1)/n;
    }
    
    public static void main(String[] args) {
        AirplaneSeatAssignmentProbability a=new AirplaneSeatAssignmentProbability();
        System.out.println(a.nthPersonGetsNthSeat(1));
        System.out.println(a.nthPersonGetsNthSeat(2));
        System.out.println(a.nthPersonGetsNthSeat(10000));
    }
}
