/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangle.area;

/**
 *
 * @author wimukthirajapaksha
 */
public class RectangleArea {

    /**
     * @param args the command line arguments
     */
    
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if(ax1<=bx1) {
            if(ay2<=by1 || ax2<=bx1 || ay1>=by2) {
                return Math.abs((ax2-ax1)*(ay2-ay1))+Math.abs((bx2-bx1)*(by2-by1));
            } else {
                int a=Math.max(ax1, bx1);
                int b=Math.min(ay2, by2);
                int c=Math.min(ax2, bx2);
                int d=Math.max(ay1, by1);
                return ((ax2-ax1)*(ay2-ay1))+((bx2-bx1)*(by2-by1))-Math.abs((c-a)*(b-d));
            }
        } else {
            return computeArea(bx1, by1, bx2, by2, ax1, ay1, ax2, ay2);
        }
    }
    
    public static void main(String[] args) {
        RectangleArea r=new RectangleArea();
        System.out.println(r.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(r.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        System.out.println(r.computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
        System.out.println(r.computeArea(-2, -2, 2, 2, 1, -3, 3, 3));
        System.out.println(r.computeArea(-2, -2, 2, 2, -3, -3, -1, 3));
        System.out.println(r.computeArea(-2, -2, 2, 2, -1, -1, 1, 1));
        System.out.println(r.computeArea(-5, -2, -4, 1, -3, -3, 3, 3));
    }
}
