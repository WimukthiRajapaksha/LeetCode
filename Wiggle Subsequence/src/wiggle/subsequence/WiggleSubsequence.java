/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiggle.subsequence;

/**
 *
 * @author wimukthirajapaksha
 */
public class WiggleSubsequence {

    /**
     * @param args the command line arguments
     */
    
//    -----------------OPTIMAL -> TIME O(n), SPACE O(1)-----------------------
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2) return nums.length;
        int prevDiff=nums[1]-nums[0];
        int count = (prevDiff == 0) ? 1 : 2;
        for(int i=2; i<nums.length; i++) {
            int diff=nums[i]-nums[i-1];
            if((diff>0 && prevDiff<=0) || (diff<0 && prevDiff>=0)) {
                count++;
                prevDiff=diff;
            }
        }
        return count;
    }
    
    
//    -----------------OPTIMAL -> TIME O(n), SPACE O(1)-----------------------
//    public int wiggleMaxLength(int[] nums) {
//        if(nums.length<2) return nums.length;
//        int up=1;
//        int down=1;
//        for(int i=1; i<nums.length; i++) {
//            if(nums[i-1]<nums[i]) {
//                up=down+1;
//            } else if(nums[i-1]>nums[i]) {
//                down=up+1;
//            }
//        }
//        return Math.max(up, down);
//    }
    
    
//    -----------------OPTIMAL -> TIME O(n), SPACE O(n)-----------------------
//    public int wiggleMaxLength(int[] nums) {
//        if(nums.length<2) return nums.length;
//        int[] up=new int[nums.length];
//        int[] down=new int[nums.length];
//        up[0]=down[0]=1;
//        for(int i=1; i<nums.length; i++) {
//            if(nums[i-1]<nums[i]) {
//                up[i]=down[i-1]+1;
//                down[i]=down[i-1];
//            } else if(nums[i-1]>nums[i]) {
//                down[i]=up[i-1]+1;
//                up[i]=up[i-1];
//            } else {
//                up[i]=up[i-1];
//                down[i]=down[i-1];
//            }
//        }
//        return Math.max(up[up.length-1], down[down.length-1]);
//    }
    
    
    
    
//    ----------------NOT BEAUTIFUL----------------
//    public int wiggleMaxLength(int[] nums) {
//        int i=0;
//        int c=0;
//        while(i+1<nums.length) {
//            if(nums[i]==nums[i+1]) {
//                c++;
//                i++;
//            } else if(nums[i]<nums[i+1]) {
//                int t=i+1;
//                while(t<nums.length && nums[t-1]<=nums[t]) {
//                    t++;
//                    c++;
//                }
//                c-=1;
//                i=t-1;
//            } else {
//                int t=i+1;
//                while(t<nums.length && nums[t-1]>=nums[t]) {
//                    t++;
//                    c++;
//                }
//                c-=1;
//                i=t-1;
//            }
//        }
//        return nums.length-c;
//    }
    
    public static void main(String[] args) {
        WiggleSubsequence w=new WiggleSubsequence();
        System.out.println(w.wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(w.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(w.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}
