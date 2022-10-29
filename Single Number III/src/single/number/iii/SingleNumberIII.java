/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single.number.iii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class SingleNumberIII {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------------OPTIMAL -> O(N) -> O(1)------------------
    public int[] singleNumber(int[] nums) {
        int sum=0;
        for(int i: nums) {
            sum^=i;
        }
        int[] ret=new int[2];
        int setBit=sum&(-sum);
        
        int temp=0;
        for(int i: nums) {
            if((setBit&i)==0) {
                temp^=i;
            }
        }
        ret[0]=temp;
        ret[1]=sum^temp;
        System.out.println(ret[0]+" - "+ret[1]);
        return ret;
    }
    
    
//    --------------------OPTIMAL -> O(N) -> O(1)------------------
//    public int[] singleNumber(int[] nums) {
//        int sum=0;
//        for(int i: nums) {
//            sum^=i;
//        }
//        int first=0;
//        int second=0;
//        int place=0;
//        int placeOriginal=0;
//        for(int i=0; i<32; i++) {
//            if((sum&(1<<i))==(1<<i)) {
//                place=(1<<(i+1))-1;
//                placeOriginal=1<<i;
//                break;
//            }
//        }
//        
//        for(int i: nums) {
//            if((place&i)>=placeOriginal) {
//                first^=i;
//            } else {
//                second^=i;
//            }
//        }
//        System.out.println(first+" - "+second);
//        return new int[]{first, second};
//    }
    
    
    
//    ------------------NOT OPTIMAL-------------------
//    public int[] singleNumber(int[] nums) {
//        Set<Integer> set=new HashSet<>();
//        for(int i: nums) {
//            if(set.contains(i)) {
//                set.remove(i);
//            } else {
//                set.add(i);
//            }
//        }
//        List<Integer> list=new ArrayList<>();
//        for(int i: set) {
//            list.add(i);
//        }
//        int[] ret=new int[2];
//        ret[0]=list.get(0);
//        ret[1]=list.get(1);
//        System.out.println(list);
//        return ret;
//    }
    
    public static void main(String[] args) {
        SingleNumberIII s=new SingleNumberIII();
        s.singleNumber(new int[]{1,2,1,3,2,5});
        s.singleNumber(new int[]{-1,0});
        s.singleNumber(new int[]{0,1});
    }
}
