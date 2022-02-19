/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package how.many.numbers.are.smaller.than.the.current.number;

/**
 *
 * @author wimukthirajapaksha
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    /**
     * @param args the command line arguments
     */
    
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cArr=new int[10];
        for (int i: nums) {
            cArr[i+1]++;
        }
        for (int i=2; i<cArr.length; i++) {
            cArr[i]=cArr[i]+cArr[i-1];
        }
        for (int i=0; i<nums.length; i++) {
            nums[i]=cArr[nums[i]];
        }
        for (int i: nums) {
            System.out.print(i+" ");
        }
        return nums;
    }
    
    public static void main(String[] args) {
        HowManyNumbersAreSmallerThanTheCurrentNumber h=new HowManyNumbersAreSmallerThanTheCurrentNumber();
        h.smallerNumbersThanCurrent(new int[]{8,1,2,2,3});
    }
}
