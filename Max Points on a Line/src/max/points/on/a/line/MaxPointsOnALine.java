/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.points.on.a.line;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaxPointsOnALine {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------OPTIMAL -> MORE INTUITIVE -> O(N^2), O(N)------------------
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        Arrays.sort(points, (int[] i, int[] j) -> Integer.compare(i[0], j[0]));
        int result = 0;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int dup=0;
            int currMax=0;
            for (int j = i+1; j < points.length; j++) {
                sb.setLength(0);
                int dy=points[i][1]-points[j][1];
                int dx=points[i][0]-points[j][0];
                
                if(points[i][0]==points[j][0] && points[i][1]==points[j][1]) {
                    dup++;
                } else {
                    int div = gcd(dy, dx);
                    dy/=div;
                    dx/=div;
                    sb.append(dy).append(",").append(dx);
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
                    currMax=Math.max(currMax, map.get(sb.toString()));
                }
                result=Math.max(result, currMax+dup);
            }
        }
        return result+1;
    }
    
    private int gcd(int i, int j) {
        if(j==0) return i;
        return gcd(j, i%j);
    }
    
    
//    -------------------OPTIMAL -> COMPLEX TO UNDERSTAND -> O(N^2), O(N)-----------
//    public int maxPoints(int[][] points) {
//        if (points.length <= 2) {
//            return points.length;
//        }
//        int result = 0;
//        for (int i=0; i<points.length; i++) {
//            Map<Double, Integer> map = new HashMap<>();
//            for (int j=0; j<points.length; j++) {
//                if(i==j) continue;
//                double slope=slope(points[i], points[j]);
//                map.put(slope, map.getOrDefault(slope, 0)+1);
//                result=Math.max(result, map.get(slope));
//            }
//        }
//        return result+1;
//    }
//    
//    private double slope(int[] f, int[] s) {
//        if(f[0]==s[0]) return Double.POSITIVE_INFINITY;
//        return (f[1]-s[1])/(double)(f[0]-s[0]);
//    }
    
    public static void main(String[] args) {
        MaxPointsOnALine m=new MaxPointsOnALine();
        System.out.println(m.maxPoints(new int[][]{{1,1},{2,2},{3,3}}));
        System.out.println(m.maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
        System.out.println(m.maxPoints(new int[][]{{2,3},{3,3},{-5,3}}));
    }
}
