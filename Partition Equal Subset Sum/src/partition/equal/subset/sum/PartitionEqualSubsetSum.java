/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partition.equal.subset.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class PartitionEqualSubsetSum {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------------GOOD SOLUTION -> O(2^N), O(N)------------------
//    public boolean canPartition(int[] nums) {
//        int sum=0;
//        for(int i: nums) {
//            sum+=i;
//        }
//        if(sum%2!=0) return false;
//        Set<Integer> set=new HashSet<>();
//        List<Integer> list=new ArrayList<>();
//        set.add(0);
//        list.add(0);
//        for(int i: nums) {
//            int size=list.size();
//            while(--size>=0) {
//                int j=list.get(size);
//                if(j+i==sum/2) return true;
//                if(i+j>sum/2) continue;
//                if(!set.contains(j+i)) {
//                    list.add(j+i);
//                    set.add(j+i);
//                }
//                System.out.println(j);
//            }
//        }
//        System.out.println(list);
//        System.out.println(set);
//        return false;
//    }
    
    
//    -------------------------GOOD SOLUTION -> O(2^N), O(N)------------------
//    public boolean canPartition(int[] nums) {
//        int sum=0;
//        for(int i: nums) {
//            sum+=i;
//        }
//        if(sum%2!=0) return false;
//        boolean[] set=new boolean[(sum/2)+1];
//        List<Integer> list=new ArrayList<>();
//        set[0]=true;
//        list.add(0);
//        for(int i: nums) {
//            int size=list.size();
//            while(--size>=0) {
//                int j=list.get(size);
//                if(j+i==sum/2) return true;
//                if(i+j>sum/2) continue;
//                if(set[j+i]==false) {
//                    list.add(j+i);
//                    set[j+i]=true;
//                }
//                System.out.println(j);
//            }
//        }
//        System.out.println(list);
//        System.out.println(Arrays.toString(set));
//        return false;
//    }
    
    
    
//    -------------------------OPTIMAL -> DP -> O(N*SUM(NUMS)), O(N*SUM(NUMS))------------------
//    public boolean canPartition(int[] nums) {
//        int sum=0;
//        for(int n: nums) {
//            sum+=n;
//        }
//        if(sum%2!=0) return false;
//        boolean[][] check=new boolean[nums.length+1][(sum/2)+1];
//        for(int i=0; i<check.length; i++) {
//            check[i][0]=true;
//        }
//        for(int i=1; i<check.length; i++) {
//            for(int j=1; j<check[i].length; j++) {
//                check[i][j]=check[i-1][j] || (j-nums[i-1] >=0 ?check[i-1][j-nums[i-1]] : false);
//            }
//        }
//        return check[check.length-1][check[0].length-1];
//    }
    
    
//    -------------------------OPTIMAL -> DP -> O(N*SUM(NUMS)), O(SUM(NUMS))------------------
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n: nums) {
            sum+=n;
        }
        if(sum%2!=0) return false;
        boolean[] check=new boolean[(sum/2)+1];
        check[0]=true;
        for(int i=1; i<=nums.length; i++) {
            for(int j=check.length-1; j>=nums[i-1]; j--) {
                check[j]=check[j] || (j-nums[i-1] >=0 ? check[j-nums[i-1]] : false);
            }
        }
        return check[check.length-1];
    }
    
    public static void main(String[] args) {
        PartitionEqualSubsetSum p=new PartitionEqualSubsetSum();
        System.out.println(p.canPartition(new int[]{1,5,11,5}));
        System.out.println(p.canPartition(new int[]{1,2,3,5}));
        System.out.println(p.canPartition(new int[]{3,3,3,4,5}));
    } 
}
