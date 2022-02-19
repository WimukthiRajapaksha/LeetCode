/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concatenation.of.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class ConcatenationOfArray {

    /**
     * @param args the command line arguments
     */
    
    public int[] getConcatenation(int[] nums) {
        int[] ret=new int[2*nums.length];
        for (int i=0; i<nums.length; i++) {
            ret[i]=nums[i];
            ret[nums.length+i]=nums[i];
        }
        for (int i: ret) {
            System.out.print(i+" ");
        }
        return ret;
    }
    
    public static void main(String[] args) {
        ConcatenationOfArray c=new ConcatenationOfArray();
        c.getConcatenation(new int[]{1,3,2,1});
    }
    
}
