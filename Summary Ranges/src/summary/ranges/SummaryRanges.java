/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summary.ranges;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class SummaryRanges {

    /**
     * @param args the command line arguments
     */
    
    public List<String> summaryRanges(int[] nums) {
        List<String> l=new ArrayList<>();
        if(nums.length==0) return l;
        int i=0;
        StringBuffer s=new StringBuffer();
        while(i<nums.length) {
            int j=i+1;
            s.append(nums[i]);
            while(j<nums.length && nums[j-1]+1==nums[j]) {
                j++;
            }
            if(j!=i+1) {
                s.append("->").append(nums[j-1]);
            }
            l.add(s.toString());
            s=new StringBuffer();
            i=j;
        }
        return l;
    }
    
    
//    ------------------------ALTERNATE---------------------------
//    public List<String> summaryRanges(int[] nums) {
//        List<String> l=new ArrayList<>();
//        if(nums.length==0) {
//            return l;
//        }
//        int p=0;
//        String s;
//        for(int i=1; i<nums.length+1; i++) {
//            if(i>=nums.length || nums[i-1]+1!=nums[i]) {
//                s=(p+1==i) ? String.valueOf(nums[p]) : nums[p]+"->"+nums[i-1];
//                l.add(s);
//                p=i;                
//            }
//        }
//        return l;
//    }
    
    public static void main(String[] args) {
        SummaryRanges s=new SummaryRanges();
        System.out.println(s.summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}
