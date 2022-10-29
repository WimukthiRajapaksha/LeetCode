/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.performance.of.a.team;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumPerformanceOfATeam {

    /**
     * @param args the command line arguments
     */
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[] arr=new int[n];
        for(int i=0; i<n; i++) {
            arr[i]=speed[i]*efficiency[i];
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int max=0;
        for(int i=n-1; i>n-1-k; i--) {
            max+=arr[i];
        }
        return max;
    }
    
    public static void main(String[] args) {
        MaximumPerformanceOfATeam m=new MaximumPerformanceOfATeam();
        System.out.println(m.maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 2));
    }
}
