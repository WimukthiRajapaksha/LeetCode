/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package check.pkgif.it.is.a.straight.line;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class CheckIfItIsAStraightLine {

    /**
     * @param args the command line arguments
     */
    
//    -------OPTIMAL -> O(N), O(1)---------------------
    public boolean checkStraightLine(int[][] coordinates) {
        int x=deltaX(coordinates[0], coordinates[1]);
        int y=deltaY(coordinates[0], coordinates[1]);
        
        for(int i=0; i<coordinates.length-1; i++) {
            if(y*deltaX(coordinates[i], coordinates[i+1])!=x*deltaY(coordinates[i], coordinates[i+1])) {
                return false;
            } 
        }
        return true;
    }
    
    private int deltaX(int[] i, int[] j) {
        return j[0]-i[0];
    }
    
    private int deltaY(int[] i, int[] j) {
        return j[1]-i[1];
    }
    
    
    public static void main(String[] args) {
        CheckIfItIsAStraightLine c=new CheckIfItIsAStraightLine();
        System.out.println(c.checkStraightLine(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
        System.out.println(c.checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
        System.out.println(c.checkStraightLine(new int[][]{{0,0},{0,1},{0,-1}}));
    }
}
