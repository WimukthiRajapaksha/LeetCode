/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort.colors;

/**
 *
 * @author wimukthirajapaksha
 */
public class SortColors {

    /**
     * @param args the command line arguments
     */
    
    public void sortColors(int[] nums) {
        if(nums.length==0 || nums.length==1) return;
        int i=0;
        while(i<nums.length && nums[i]==0) i++;
        int j=nums.length-1;
        while(j>=0 && nums[j]==2) j--;
        
        if(i>=j) return;
        
        int k=i;
        
        while(k<=j) {
            if(nums[k]==0) {
                nums[k]=nums[i];
                nums[i]=0;
                i++;
                k++;
            } else if(nums[k]==2) {
                nums[k]=nums[j];
                nums[j]=2;
                j--;
            } else {
                k++;
            }
        }
        
        for(int a: nums) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
    
    
    
//    public void sortColors(int[] nums) {
//        int[] count = new int[3];
//        for(int i: nums) {
//            count[i]++;
//        }
//        int j=0;
//        int i=0;
//        while(i<nums.length) {
//            if(count[j]==0) {
//                j++;
//                continue;
//            }
//            nums[i++]=j;
//            count[j]--;
//        }
//        for(int k: nums) {
//            System.out.print(k+" ");
//        }
//    }
    
    
    
    
//    public void sortColors(int[] nums) {
//        int zero=0;
//        int twos=0;
//        for(int i=0; i<nums.length; i++) {
//            if(nums[i]==0) zero++;
//            else if(nums[i]==2) twos++;
//            nums[i]=1;
//        }
//        int i=0;
//        while(zero>0) {
//            nums[i++]=0;
//            zero--;
//        }
//        i=nums.length-1;
//        while(twos>0) {
//            nums[i--]=2;
//            twos--;
//        }
//        for(int j: nums) {
//            System.out.print(j+" ");
//        }
//    }
    
    public static void main(String[] args) {
        SortColors s=new SortColors();
        s.sortColors(new int[]{2,0,2,1,1,0,0});
        s.sortColors(new int[]{1,2,0});
    }
}
