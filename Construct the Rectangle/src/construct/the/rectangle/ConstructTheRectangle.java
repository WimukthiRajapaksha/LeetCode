/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construct.the.rectangle;

/**
 *
 * @author wimukthirajapaksha
 */
public class ConstructTheRectangle {

    /**
     * @param args the command line arguments
     */
    
    public int[] constructRectangle(int area) {
        int m=(int)Math.sqrt(area);
        while(area%m!=0) {
            m--;
        }
        System.out.println((area/m)+" "+m);
        return new int[]{area/m, m};
    }
    
    public static void main(String[] args) {
        ConstructTheRectangle c=new ConstructTheRectangle();
        c.constructRectangle(1);
        c.constructRectangle(4);
        c.constructRectangle(36);
        c.constructRectangle(37);
        c.constructRectangle(122122);
    }
}
