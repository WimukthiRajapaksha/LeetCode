/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.number.of.arrows.to.burst.balloons;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    /**
     * @param args the command line arguments
     */
    
//    -------------OPTIMAL -> O(NLOG(N)), O(1)-------------
    public int findMinArrowShots(int[][] points) {
        int ret=1;
        Arrays.sort(points, (o1, o2)-> Integer.compare(o1[1], o2[1]));
        int temp=points[0][1];
        for(int[] i: points) {
            if(temp<i[0]) {
                ret++;
                temp=i[1];
            }
        }
        return ret;
    }
    
    
//    -------------OPTIMAL -> O(NLOG(N)), O(1)-------------
//    public int findMinArrowShots(int[][] points) {
//        int ret=0;
//        Arrays.sort(points, (o1, o2)-> Integer.compare(o1[0], o2[0]));
//        int i=0;
//        int temp=points[0][1];
//        while(i<points.length) {
//            while(i<points.length && points[i][0]<=temp) {
//                temp=Math.min(temp, points[i][1]);
//                i++;
//            }
//            ret++;
//            if(i==points.length) {
//                return ret;
//            }
//            temp=points[i][1];
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons m=new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(m.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(m.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        System.out.println(m.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
        System.out.println(m.findMinArrowShots(new int[][]{{1,2},{3,3}}));
        System.out.println(m.findMinArrowShots(new int[][]{{1,2}}));
        System.out.println(m.findMinArrowShots(new int[][]{{1,2},{4,5},{1,5}}));
        System.out.println(m.findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}}));
    }
}
