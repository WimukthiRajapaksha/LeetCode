/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.compatibility.score.sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumCompatibilityScoreSum {

    /**
     * @param args the command line arguments
     */
    
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return help(students, 0, mentors, new boolean[mentors.length]);
    }
    
    public int help(int[][] students, int i, int[][] mentors, boolean[] visitedMentors) {
        int count=0;
        for(int j=0; j<mentors.length; j++) {
            if(visitedMentors[j]) continue;
            visitedMentors[j]=true;
            count=Math.max(count, help(students, i+1, mentors, visitedMentors)+count(students[i], mentors[j]));
            visitedMentors[j]=false;
        }
        return count;
    }
    
    private int count(int[] s, int[] m) {
        int cou=0;
        for(int i=0; i<s.length; i++) {
            if(s[i]==m[i]) {
                cou++;
            }
        }
        return cou;
    }
    
    public static void main(String[] args) {
        MaximumCompatibilityScoreSum m=new MaximumCompatibilityScoreSum();
        System.out.println(m.maxCompatibilitySum(new int[][]{{1,1,0},{1,0,1},{0,0,1}}, new int[][]{{1,0,0},{0,0,1},{1,1,0}}));
    }
}
