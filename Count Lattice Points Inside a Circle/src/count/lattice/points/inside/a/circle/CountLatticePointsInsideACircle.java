/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.lattice.points.inside.a.circle;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountLatticePointsInsideACircle {

    /**
     * @param args the command line arguments
     */
    
    public int countLatticePoints(int[][] circles) {
        Set<String> set=new HashSet<>();
        for(int[] i: circles) {
            add(i, set);
        }
        return set.size();
    }
    
    private void add(int[] arr, Set<String> set) {
        int t=(int)Math.floor(arr[2]*Math.pow(2, 1/2)/2);
        for(int i=arr[0]-t; i<=arr[0]+t; i++) {
            for(int j=arr[1]-t; j<=arr[1]+t; j++) {
                set.add(i+"-"+j);
            }
        }
        set.add((arr[0]-arr[2])+"-"+arr[1]);
        set.add((arr[0]+arr[2])+"-"+arr[1]);
        set.add(arr[0]+"-"+(arr[1]-arr[2]));
        set.add(arr[0]+"-"+(arr[1]+arr[2]));
    }
    
    public static void main(String[] args) {
        CountLatticePointsInsideACircle c=new CountLatticePointsInsideACircle();
        System.out.println(c.countLatticePoints(new int[][]{{2,2,1}}));
        System.out.println(c.countLatticePoints(new int[][]{{2,2,2},{3,4,1}}));
        System.out.println(c.countLatticePoints(new int[][]{{8,9,6},{9,8,4},{4,1,1},{8,5,1},{7,1,1},{6,7,5},{7,1,1},{7,1,1},{5,5,3}}));
    }
}
