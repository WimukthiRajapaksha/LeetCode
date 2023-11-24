/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.time.to.make.rope.colorful;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumTimeToMakeRopeColorful {

    /**
     * @param args the command line arguments
     */
    
//    ----------------OPTIMAL -> O(N) -> O(1)---------
//    public int minCost(String colors, int[] neededTime) {
//        int i=0;
//        int totalTime=0;
//        while(i<colors.length()) {
//            int j=i;
//            int sum=0;
//            int max=0;
//            while(j<colors.length() && colors.charAt(i)==colors.charAt(j)) {
//                sum+=neededTime[j];
//                max=Math.max(max, neededTime[j]);
//                j++;
//            }
//            totalTime+=sum-max;
//            i=j;
//        }
//        return totalTime;
//    }
    
    
    
//    ----------------OPTIMAL -> O(N) -> O(1)---------
    public int minCost(String colors, int[] neededTime) {
        int totalTime=0;
        int max=neededTime[0];
        int currSum=neededTime[0];
        for(int i=1; i<colors.length(); i++) {
            if(colors.charAt(i-1)!=colors.charAt(i)) {
                totalTime+=currSum-max;
                max=0;
                currSum=0;
            }
            max=Math.max(max, neededTime[i]);
            currSum+=neededTime[i];
        }
        return totalTime+currSum-max;
    }
    
    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful m=new MinimumTimeToMakeRopeColorful();
        System.out.println(m.minCost("abaac", new int[]{1,2,3,4,5}));
        System.out.println(m.minCost("abc", new int[]{1,2,3}));
        System.out.println(m.minCost("aabaa", new int[]{1,2,3,4,1}));
    }
}
