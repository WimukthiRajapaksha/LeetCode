/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.peak.element;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindPeakElement {

    /**
     * @param args the command line arguments
     */
    
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int l=0;
        int r=nums.length-1;
        while(l<r) {
            int m=l+(r-l)/2;
            if(nums[m]<nums[m+1]) l=m+1;
            else r=m;
        }
        return l;
    }
    
    
//    ---------------ALTERNATE -> OPTIMAL-------------------
//    public int findPeakElement(int[] nums) {
//        if(nums.length==1) return 0;
//        return search(nums, 0, nums.length-1);
//    }
//    
//    private int search(int[] nums, int l, int r) {
//        if(l==r) return l;
//        int m=l+(r-l)/2;
//        if(nums[m]<nums[m+1]) return search(nums, m+1, r);
//        return search(nums, l, m);
//    }
    
    
    
//    --------------------------ALTERNATE -> NOT OPTIMAL-----------
//    public int findPeakElement(int[] nums) {
//        if(nums.length==1) return 0;
//        return search(nums, 0, nums.length-1);
//    }
//    
//    private int search(int[] nums, int l, int r) {
//        if(l>r) return -1;
//        int m=l+(r-l)/2;
//        int ret=0;
//        System.out.println(l+" "+r+" "+m);
//        if(((m>0 && nums[m-1]<nums[m]) || (m==0)) && ((m<nums.length-1 && nums[m]>nums[m+1]) || m==nums.length-1)) return m;
//        else {
//            ret=search(nums, l, m-1);
//            if(ret!=-1) return ret;
//            return search(nums, m+1, r);
//        }
//    }
    
    public static void main(String[] args) {
        FindPeakElement f=new FindPeakElement();
//        System.out.println(f.findPeakElement(new int[]{1,1,1,3,5,6,4}));
        System.out.println(f.findPeakElement(new int[]{1,2}));
    }
}
