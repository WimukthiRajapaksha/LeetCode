/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jump.game.ii;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class JumpGameII {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------------GOOD SOLUTION, BUT NOT BEAUTIFUL-------------------------
//    public int jump(int[] nums) {
//        if(nums.length<=1) return 0;
//        int l=0;
//        int r=1;
//        int count=0;
//        while(r<nums.length-1) {
//            int maxPosition=0;
//            for(int i=l; i<r; i++) {
//                maxPosition=Math.max(maxPosition, nums[i]+i);
//            }
//            l=r;
//            r=maxPosition+1;
//            count++;
//        }
//        return count;
//    }
    
    
//    -----------------------OPTIMAL -> O(N), O(1)-------------------------
    public int jump(int[] nums) {
        if(nums.length<=1) return 0;
        int currEnd=0;
        int currFarthestEnd=0;
        int count=0;
        for(int i=0; i<nums.length-1; i++) {
            currFarthestEnd=Math.max(currFarthestEnd, nums[i]+i);
            if(currEnd==i) {
                currEnd=currFarthestEnd;
                count++;
            }
            
        }
        return count;
    }
    
    public static void main(String[] args) {
        JumpGameII j=new JumpGameII();
        System.out.println(j.jump(new int[]{2,3,1,1,4}));
        System.out.println(j.jump(new int[]{2,3,0,1,4}));
    }
}
