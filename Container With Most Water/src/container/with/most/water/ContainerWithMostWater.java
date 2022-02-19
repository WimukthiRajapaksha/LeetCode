/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container.with.most.water;

/**
 *
 * @author wimukthirajapaksha
 */
public class ContainerWithMostWater {

    /**
     * @param args the command line arguments
     */
    
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=0;
        while(i<j) {
            max=Math.max(Math.min(height[i], height[j])*(j-i), max);
            if(height[i]<height[j]) {
                int t=i+1;
                while(t<height.length && height[t]<=height[i]) {
                    t++;
                }
                i=t;
            } else {
                int t=j-1;
                while(t>=0 && height[t]<=height[j]) {
                    t--;
                }
                j=t;
            }
        }
        System.out.println(max);
        return 0;
    }
    
    public static void main(String[] args) {
        ContainerWithMostWater c=new ContainerWithMostWater();
        c.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}
