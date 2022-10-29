/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missing.ranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class MissingRanges {

    /**
     * @param args the command line arguments
     */
    
//    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
//        List<String> list=new ArrayList<>();
//        StringBuffer sb=new StringBuffer();
//        if(nums.length==0) {
//            if(lower==upper) {
//                sb.append(lower);
//                list.add(sb.toString());
//            } else {
//                sb.append(lower).append("->").append(upper);
//                list.add(sb.toString());
//            }
//            return list;
//        }
//        int i=1;
//        sb.setLength(0);
//        if(lower==nums[0]) {
//            
//        } else if(lower<nums[0]-1) {
//            sb.append(lower).append("->").append(nums[0]-1);
//            list.add(sb.toString());
//        } else if(lower==nums[0]-1) {
//            sb.append(lower);
//            list.add(sb.toString());
//        }
//        while(i<nums.length) {
//            if(nums[i-1]==nums[i] || nums[i]-nums[i-1]==1) {
//                i++;
//                continue;
//            }
//            sb.setLength(0);
//            if(nums[i]-nums[i-1]==2) {
//                sb.append(nums[i-1]+1);
//            } else {
//                sb.append(nums[i-1]+1).append("->").append(nums[i]-1);
//            }
//            list.add(sb.toString());
//            i++;
//        }
//        sb.setLength(0);
//        if(nums[nums.length-1]==upper) {
//        } else if(nums[nums.length-1]+1<upper) {
//            sb.append(nums[nums.length-1]+1).append("->").append(upper);
//            list.add(sb.toString());
//        } else if(nums[nums.length-1]+1==upper) {
//            sb.append(upper);
//            list.add(sb.toString());
//        }
//        return list;
//    }
    
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list=new ArrayList<>();
        
        if(nums.length==0) {
            if(lower==upper) {
                list.add(String.valueOf(lower));
            } else {
                StringBuffer sb=new StringBuffer();
                sb.append(lower).append("->").append(upper);
                list.add(sb.toString());
            }
            return list;
        }
        int i=1;
        diffBeg(lower, nums[0], list);
        while(i<nums.length) {
            diff(nums[i-1], nums[i], list);
            i++;
        }
        diffEnd(nums[nums.length-1], upper, list);
        return list;
    }
    
    private void diffBeg(int i, int j, List<String> list) {
        if(i==j) return;
        StringBuffer sb=new StringBuffer();
        if(j-i==1) {
            sb.append(i);
            list.add(sb.toString());
        } else {
            sb.append(i).append("->").append(j-1);
            list.add(sb.toString());
        }
    }
    
    private void diffEnd(int i, int j, List<String> list) {
        if(i==j) return;
        StringBuffer sb=new StringBuffer();
        if(j-i==1) {
            sb.append(j-1);
            list.add(sb.toString());
        } else {
            sb.append(i+1).append("->").append(j);
            list.add(sb.toString());
        }
    }
    
    private void diff(int i, int j, List<String> list) {
        if(i==j) return;
        if(j-i==1) return;
        StringBuffer sb=new StringBuffer();
        if(j-i==2) {
            sb.append(j-1);
            list.add(sb.toString());
        } else {
            sb.append(i+1).append("->").append(j-1);
            list.add(sb.toString());
        }
    }
    
    public static void main(String[] args) {
        MissingRanges m=new MissingRanges();
        System.out.println(m.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
        System.out.println(m.findMissingRanges(new int[]{0, 1, 2, 3, 7}, 0, 7));
        System.out.println(m.findMissingRanges(new int[]{}, 1, 1));
        System.out.println(m.findMissingRanges(new int[]{2147483647}, 0, 2147483647));
        System.out.println(m.findMissingRanges(new int[]{-2147483648,-2147483648,0,2147483647,2147483647}, -2147483648, 2147483647));
    }
}
