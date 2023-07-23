/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.rounds.to.complete.all.tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumRoundsToCompleteAllTasks {

    /**
     * @param args the command line arguments
     */
    
//    --------------OPTIMAL -> O(NLOG(N)), O(1)------------
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int sum=0;
        for(int i=0; i<tasks.length;) {
            int j=i+1;
            while(j<tasks.length && tasks[j]==tasks[i]) j++;
            if(j-i==1) return -1;
            sum+=(j-1-i)/3+1;
            i=j;
        }
        return sum;
    }
    
    
//    --------------OPTIMAL -> O(N), O(N)------------
//    public int minimumRounds(int[] tasks) {
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int i: tasks) {
//            map.put(i, map.getOrDefault(i, 0)+1);
//        }
//        int ret=0;
//        for(int i: map.values()) {
//            if(i==1) return -1;
//            ret+=((i-1)/3+1);
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        MinimumRoundsToCompleteAllTasks m=new MinimumRoundsToCompleteAllTasks();
        System.out.println(m.minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
        System.out.println(m.minimumRounds(new int[]{2,3,3}));
    }
}
