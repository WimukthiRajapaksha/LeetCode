/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missing.number;

/**
 *
 * @author wimukthirajapaksha
 */
public class MissingNumber {

    /**
     * @param args the command line arguments
     */
    
//    public int missingNumber(int[] nums) {
//        int c=0;
//        for(int i: nums) c+=i;
//        return ((nums.length+1)*nums.length)/2-c;
//    }
    
    
    
    public int missingNumber(int[] nums) {
        int xor=nums.length;
        for(int i=0; i<nums.length; i++) xor=xor^i^nums[i];
        return xor;
    }
    
    
//    public int missingNumber(int[] nums) {
//        int res=nums.length;
//        for(int i=0; i<nums.length; i++) res+=i-nums[i];
//        return res;
//    }
    
    public static void main(String[] args) {
        MissingNumber m=new MissingNumber();
        System.out.println(m.missingNumber(new int[]{0,2,3}));
    }
}
