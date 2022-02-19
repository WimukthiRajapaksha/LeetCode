/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flipping.an.image;

/**
 *
 * @author wimukthirajapaksha
 */
public class FlippingAnImage {

    /**
     * @param args the command line arguments
     */
    
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] i: image) {
            for (int j=0; j<(image.length+1)/2; j++) {
                int temp=i[j];
                i[j]=i[image.length-1-j]==1 ? 0 : 1;
                i[image.length-1-j]=temp==0 ? 1 : 0;
            }
        }
        for (int[] i: image) {
            for (int j: i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
        return image;
    }
    
    public static void main(String[] args) {
        FlippingAnImage f=new FlippingAnImage();
        f.flipAndInvertImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}});
        f.flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
    }
    
}
