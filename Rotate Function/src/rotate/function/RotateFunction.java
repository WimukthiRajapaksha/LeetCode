/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotate.function;

/**
 *
 * @author wimukthirajapaksha
 */
public class RotateFunction {

    /**
     * @param args the command line arguments
     */
    
//    --------------OPTIMAL -> O(N), O(1)-------------------
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int prev=0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            prev+=(i*nums[i]);
        }
        int ptr=nums.length-1;
        int max=prev;
        while(ptr>=0) {
            prev=prev+sum-(nums.length*nums[ptr]);
            if(prev>max) {
                max=prev;
            }
            ptr--;
        }
        return max;
    }
    
    public static void main(String[] args) {
        RotateFunction r=new RotateFunction();
        System.out.println(r.maxRotateFunction(new int[]{4,3,2,6}));
        System.out.println(r.maxRotateFunction(new int[]{100}));
    }
}
