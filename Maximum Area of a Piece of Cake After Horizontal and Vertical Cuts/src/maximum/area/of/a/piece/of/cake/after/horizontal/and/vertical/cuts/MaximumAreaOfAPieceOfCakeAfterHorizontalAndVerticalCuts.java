/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.area.of.a.piece.of.cake.after.horizontal.and.vertical.cuts;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    /**
     * @param args the command line arguments
     */
    
//    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
//        int mh=0;
//        int mv=0;
//        int[] arrH=new int[h+1];
//        arrH[0]=0;
//        for(int i=0; i<horizontalCuts.length; i++) {
//            arrH[horizontalCuts[i]]=-1;
//        }
//        arrH[arrH.length-1]=-1;
//        for(int i=1; i<arrH.length; i++) {
//            if(arrH[i]==-1) {
//                if(mh<arrH[i-1]+1) {
//                    mh=arrH[i-1]+1;
//                }
//                arrH[i]=0;
//            } else {
//                arrH[i]=arrH[i-1]+1;
//            }
//        }
//        
//        int[] arrV=new int[w+1];
//        arrV[0]=0;
//        for(int i=0; i<verticalCuts.length; i++) {
//            arrV[verticalCuts[i]]=-1;
//        }
//        arrV[arrV.length-1]=-1;
//        for(int i=1; i<arrV.length; i++) {
//            if(arrV[i]==-1) {
//                if(mv<arrV[i-1]+1) {
//                    mv=arrV[i-1]+1;
//                }
//                arrV[i]=0;
//            } else {
//                arrV[i]=arrV[i-1]+1;
//            }
//        }
//        System.out.println(mh+" "+mv);
//        return (mh%((int)Math.pow(10, 9)+7))*(mv%((int)Math.pow(10, 9)+7));
//    }
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int mh=Math.max(horizontalCuts[0], h-horizontalCuts[horizontalCuts.length-1]);
        int mv=Math.max(verticalCuts[0], w-verticalCuts[verticalCuts.length-1]);
        
        for(int i=1; i<horizontalCuts.length; i++) {
            if(mh<horizontalCuts[i]-horizontalCuts[i-1]) {
                mh=horizontalCuts[i]-horizontalCuts[i-1];
            }
        }
        
        for(int i=1; i<verticalCuts.length; i++) {
            if(mv<verticalCuts[i]-verticalCuts[i-1]) {
                mv=verticalCuts[i]-verticalCuts[i-1];
            }
        }
        return (int)(((long)mh%1000000007*mv%1000000007));
    }
    
    public static void main(String[] args) {
        MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts m=new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();
        System.out.println(m.maxArea(5, 4, new int[]{1,2,4}, new int[]{1,3}));
        System.out.println(m.maxArea(5, 4, new int[]{3,1}, new int[]{1}));
        System.out.println(m.maxArea(5, 4, new int[]{3}, new int[]{3}));
        System.out.println(m.maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2}));
    }
}
