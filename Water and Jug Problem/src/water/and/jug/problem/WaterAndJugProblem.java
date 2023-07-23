/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package water.and.jug.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class WaterAndJugProblem {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------------OPTIMAL -> O(N), O(1)--------------------
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity+jug2Capacity<targetCapacity) return false;
        int temp=gcd(jug1Capacity, jug2Capacity);
        return targetCapacity%temp==0;
    }
    
    private int gcd(int i, int j) {
        if(j==0) return i;
        return gcd(j, i%j);
    }
    
    public static void main(String[] args) {
        WaterAndJugProblem w=new WaterAndJugProblem();
        System.out.println(w.canMeasureWater(3, 5, 4));
        System.out.println(w.canMeasureWater(2, 6, 5));
        System.out.println(w.canMeasureWater(1, 2, 3));
        System.out.println(w.canMeasureWater(34, 5, 6));
        System.out.println(w.canMeasureWater(1, 1, 12));
    }
}
