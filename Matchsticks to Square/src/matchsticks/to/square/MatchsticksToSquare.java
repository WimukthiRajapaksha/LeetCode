/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchsticks.to.square;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javafx.util.Pair;

/**
 *
 * @author wimukthirajapaksha
 */
public class MatchsticksToSquare {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------OPTIMAL -> O(4^N) -> O(N)-----------------
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length<4) return false;
        long sum=0;
        for(int i: matchsticks) {
            sum+=i;
        }
        if(sum%4!=0) return false;
        Arrays.sort(matchsticks);
        if(matchsticks[matchsticks.length-1]>sum/4) return false;
        return backtrack(new int[4], matchsticks, matchsticks.length-1, (int)(sum/4));
    }
    
    private boolean backtrack(int[] grid, int[] array, int i, int max) {
        if(i==-1) return (grid[0]==grid[1] && grid[2]==grid[3] && grid[0]==grid[2]);
        for(int j=0; j<4; j++) {
            if(grid[j]+array[i]>max) continue;
            int k=j;
            while(--k>=0) {
                if(grid[k]==grid[j]) break;
            }
            if(k!=-1) {
                continue;
            }
            grid[j]+=array[i];
            if (backtrack(grid, array, i-1, max)) return true;
            grid[j]-=array[i];
        }
        return false;
    }
    
    
    
//    ---------------------------OPTIMAL -> CAN BE OPTIMIZED ONE MORE STEP--------------------
//    public boolean makesquare(int[] matchsticks) {
//        if(matchsticks.length<4) return false;
//        long sum=0;
//        for(int i: matchsticks) {
//            sum+=i;
//        }
//        if(sum%4!=0) return false;
//        Arrays.sort(matchsticks);
//        if(matchsticks[matchsticks.length-1]>sum/4) return false;
//        return backtrack(new int[4], matchsticks, matchsticks.length-1, (int)(sum/4));
//    }
//    
//    private boolean backtrack(int[] grid, int[] array, int i, int max) {
//        if(i==-1) return (grid[0]==grid[1] && grid[2]==grid[3] && grid[0]==grid[2]);
//        for(int j=0; j<4; j++) {
//            if(grid[j]+array[i]>max) continue;
//            grid[j]+=array[i];
//            if (backtrack(grid, array, i-1, max)) return true;
//            grid[j]-=array[i];
//        }
//        return false;
//    }
    
    public static void main(String[] args) {
        MatchsticksToSquare m=new MatchsticksToSquare();
        System.out.println(m.makesquare(new int[]{1,1,2,2,2}));
        System.out.println(m.makesquare(new int[]{3,3,3,3,4}));
        System.out.println(m.makesquare(new int[]{1,2,3,4,5,6,7,8,9,10,5,4,3,2,1}));
        System.out.println(m.makesquare(new int[]{5969561,8742425,2513572,3352059,9084275,2194427,1017540,2324577,6810719,8936380,7868365,2755770,9954463,9912280,4713511}));
        System.out.println(m.makesquare(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,102}));
    }
}