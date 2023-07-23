/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trapping.rain.water;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class TrappingRainWater {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------------OPTIMAL -> O(N), O(1)--------------
//    public int trap(int[] height) {
//        int maxL=0;
//        int l=0;
//        int maxR=0;
//        int r=height.length-1;
//        int count=0;
//        while(l<=r) {
//            if(maxL<=maxR) {
//                if(height[l]>=maxL) {
//                    maxL = height[l];
//                } else {
//                    count+=maxL-height[l];
//                }
//                l++;
//            } else {
//                if(height[r]>maxR) {
//                    maxR=height[r];
//                } else {
//                    count+=maxR-height[r];
//                }
//                r--;
//            }
//        }
//        return count;
//    }
    
    
//    -----------------------OPTIMAL -> SHORT CODE -> O(N), O(1)--------------
    public int trap(int[] height) {
        int maxL=0;
        int l=0;
        int maxR=0;
        int r=height.length-1;
        int count=0;
        while(l<=r) {
            if(maxL<=maxR) {
                maxL=Math.max(maxL, height[l]);
                count+=maxL-height[l++];
            } else {
                maxR=Math.max(maxR, height[r]);
                count+=maxR-height[r--];
            }
        }
        return count;
    }
    
    
//    -----------------------OPTIMAL -> O(N), O(N)--------------
//    public int trap(int[] height) {
//        if(height.length<=2) return 0;
//        int[] forward=new int[height.length];
//        int[] backward=new int[height.length];
//        for(int i=1; i<height.length; i++) {
//            forward[i]=Math.max(forward[i-1], height[i-1]);
//        }
//        for(int i=height.length-2; i>=0; i--) {
//            backward[i]=Math.max(backward[i+1], height[i+1]);
//        }
//        int count=0;
//        for(int i=1; i<height.length-1; i++) {
//            if(height[i]<Math.min(forward[i], backward[i])) {
//                count+=Math.min(forward[i], backward[i])-height[i];
//            }
//        }
//        System.out.println(Arrays.toString(forward));
//        System.out.println(Arrays.toString(backward));
//        return count;
//    }
    
    public static void main(String[] args) {
        TrappingRainWater t=new TrappingRainWater();
        System.out.println(t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(t.trap(new int[]{4,2,0,3,2,5}));
    }
}
