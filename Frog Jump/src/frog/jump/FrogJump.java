/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frog.jump;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class FrogJump {

    /**
     * @param args the command line arguments
     */
    
    public boolean canCross(int[] stones) {
        return false;
    }
    
    public static void main(String[] args) {
        FrogJump f=new FrogJump();
        System.out.println(f.canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(f.canCross(new int[]{0,1,2,3,4,8,9,11}));
    }
}
