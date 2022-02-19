/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum.of.all.odd.length.subarrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class SumOfAllOddLengthSubarrays {

    /**
     * @param args the command line arguments
     */
    
    public int sumOddLengthSubarrays(int[] arr) {
        int sum=0;
        for (int i=0; i<arr.length; i++) {
            sum+=(((i+1)*(arr.length-i)+1)/2)*arr[i];
        }
        System.out.println(sum);
        return sum;
    }
    
//    public int sumOddLengthSubarrays(int[] arr) {
//        for (int i=1; i<arr.length; i++) {
//            arr[i]+=arr[i-1];
//        }
//        for (int i: arr) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        int count=0;
//        for (int i=1; i<=arr.length; i+=2) {
//            System.out.println(i+"---");
//            for (int j=i-1; j<arr.length; j++) {
//                if (j==i-1) {
//                    count+=arr[j];
//                    System.out.println(count);
//                    continue;
//                }
//                count+=arr[j]-arr[j-i];
//                System.out.println(count);
//            }
//        }
//        System.out.println("\n"+count);
//        return count;
//    }
    
    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays s=new SumOfAllOddLengthSubarrays();
        s.sumOddLengthSubarrays(new int[]{1,4,2,5,3});
    }
}
