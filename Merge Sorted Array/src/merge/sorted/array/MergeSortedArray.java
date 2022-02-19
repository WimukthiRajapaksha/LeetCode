/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merge.sorted.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class MergeSortedArray {

    /**
     * @param args the command line arguments
     */
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        while(i>=0 || j>=0) {
            if(i>=0 && j>=0) {
                nums1[i+j+1]= (nums1[i]<nums2[j]) ? nums2[j--] : nums1[i--];
            } else if (j>=0) {
                nums1[j]=nums2[j--];
            } else {
                break;
            }
        }
        for (int k: nums1) {
            System.out.print(k+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();
        m.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        m.merge(new int[]{1}, 1, new int[]{}, 0);
        m.merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
