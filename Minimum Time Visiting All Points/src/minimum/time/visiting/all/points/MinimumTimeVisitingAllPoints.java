/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.time.visiting.all.points;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumTimeVisitingAllPoints {

    /**
     * @param args the command line arguments
     */
    
    public int minTimeToVisitAllPoints(int[][] points) {
        int d=0;
        for (int i=1; i<points.length; i++) {
            d+=dis(points[i-1], points[i]);
        }
        System.out.println(d);
        return d;
    }
    
    public int dis(int[] f, int[] t) {
        int i=Math.min(Math.abs(f[0]-t[0]), Math.abs(f[1]-t[1]));
        int j=Math.max(Math.abs(f[0]-t[0]), Math.abs(f[1]-t[1]));
        return i+(j-i);
    }
    
    public static void main(String[] args) {
        MinimumTimeVisitingAllPoints m=new MinimumTimeVisitingAllPoints();
        m.minTimeToVisitAllPoints(new int[][]{{1,1}, {3,4}, {-1,0}});
    }
}
