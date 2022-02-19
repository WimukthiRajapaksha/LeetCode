/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.rectangles.that.can.form.the.largest.square;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOfRectanglesThatCanFormTheLargestSquare {

    /**
     * @param args the command line arguments
     */
    
    public int countGoodRectangles(int[][] rectangles) {
        int m=0;
        int c=0;
        int t=0;
        for (int[] i: rectangles) {
            t=Math.min(i[0], i[1]);
            if (t>m) {
                m=t;
                c=1;
            } else if (t==m) {
                c++;
            }
        }
        return c;
    }
    
    public static void main(String[] args) {
        NumberOfRectanglesThatCanFormTheLargestSquare n=new NumberOfRectanglesThatCanFormTheLargestSquare();
        n.countGoodRectangles(new int[][]{{5,8}, {3,9}, {5,12}, {16,5}});
    }
}
