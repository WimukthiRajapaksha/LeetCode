/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single.number;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class SingleNumber {

    /**
     * @param args the command line arguments
     */
    
    public int singleNumber(int[] nums) {
        int sum=0;
        for (int i: nums) {
            sum^=i;
        }
        return sum;
    }
    
    
//    -----------ALTERNATE -> WITHOUT REMOVING ELEMENTS ALTERDY IN SET----------
//    public int singleNumber(int[] nums) {
//        int val=0;
//        Set<Integer> set = new HashSet<>();
//        for (int i: nums) {
//            if (set.contains(i)) {
//                val-=i;
//            } else {
//                val+=i;
//                set.add(i);
//            }
//        }
//        return val;
//    }
    
    
//    ---------------------ALTERNATE -> OLD SCHOOL AND NOT OPTIMAL---------------
//    public int singleNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i: nums) {
//            if (set.contains(i)) {
//                set.remove(i);
//            } else {
//                set.add(i);
//            }
//        }
//        return set.iterator().next();
//    }
    
    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        System.out.println(s.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(s.singleNumber(new int[]{2,2,1}));
    }
}
