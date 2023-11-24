/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimal.division;

/**
 *
 * @author wimukthirajapaksha
 */
public class OptimalDivision {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------OPTIMAL -> O(N), O(N)------------
    public String optimalDivision(int[] nums) {
        if(nums.length==1) return nums[0]+"";
        if(nums.length==2) return nums[0]+"/"+nums[1];
        StringBuffer sb=new StringBuffer();
        sb.append(nums[0]).append("/(").append(nums[1]);
        for(int i=2; i<nums.length; i++) {
            sb.append("/").append(nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        OptimalDivision o=new OptimalDivision();
        System.out.println(o.optimalDivision(new int[]{1000,100,10,2}));
    }
}
