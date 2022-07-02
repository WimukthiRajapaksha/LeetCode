/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largest.number;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class LargestNumber {

    /**
     * @param args the command line arguments
     */
    
    public String largestNumber(int[] nums) {
        if(nums.length==0) return "";
        String[] arr=new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        if(arr[0].equals("0")) return "0";
        StringBuffer sb=new StringBuffer();
        for(String s: arr) {
            sb.append(s);
        }
        return sb.toString();
    }
    
    
//    ------------------ALTERNATE -> OPTIMAL-----------------    
//    public String largestNumber(int[] nums) {
//        if(nums.length==0) return "";
//        String[] arr=new String[nums.length];
//        for(int i=0; i<nums.length; i++) {
//            arr[i]=String.valueOf(nums[i]);
//        }
//        Arrays.sort(arr, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o2+o1).compareTo((o1+o2));
//            }
//        });
//        if(arr[0].equals("0")) return "0";
//        StringBuffer sb=new StringBuffer();
//        for(String s: arr) {
//            sb.append(s);
//        }
//        return sb.toString();
//    }
    

//    ------------------ALTERNATE -> OPTIMAL-----------------
//    public String largestNumber(int[] nums) {
//        if(nums.length==0) return "";
//        String[] arr=new String[nums.length];
//        for(int i=0; i<nums.length; i++) {
//            arr[i]=Integer.toString(nums[i]);
//        }
//        Arrays.sort(arr, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o2+o1).compareTo((o1+o2));
//            }
//        });
//        if(arr[0]=="0") return "0";
//        StringBuffer sb=new StringBuffer();
//        for(String s: arr) {
//            sb.append(s);
//        }
//        return sb.toString();
//    }
    
    public static void main(String[] args) {
        LargestNumber l=new LargestNumber();
        System.out.println(l.largestNumber(new int[]{3,30,34,5,9}));
    }
}
