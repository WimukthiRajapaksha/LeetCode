/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candy;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class Candy {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------------ALTERNATE -> TIME O(n), SPACE O(1)----------------------
    private int count(int n) {
        return (n*(n+1))/2;
    }
    
    public int candy(int[] ratings) {
        if(ratings.length==1) {
            return ratings.length;
        }
        int up=0;
        int down=0;
        int oldSlope=0;
        int candies=1;
        for(int i=1; i<ratings.length; i++) {
            int newSlope=0;
            
            if(ratings[i]<ratings[i-1]) {
                newSlope = -1;
            } else if(ratings[i]>ratings[i-1]) {
                newSlope = 1;
            }
            if((oldSlope>0 && newSlope==0) || (oldSlope<0 && newSlope>=0)) {
                candies+=count(up)+count(down)+Math.max(up, down);
                up=0;
                down=0;
            }
            if(newSlope>0) {
                up++;
            } else if(newSlope<0) {
                down++;
            } else {
                candies++;
            }
            oldSlope=newSlope;
        }
        candies+=count(up)+count(down)+Math.max(up, down);
        return candies;
    }
    
    
//    ------------------ALTERNATE -> OPTIMAL -> TIME O(n), SPACE O(N)----------------------
//    public int candy(int[] ratings) {
//        int[] arr=new int[ratings.length];
//        Arrays.fill(arr, 1);
//        for(int i=1; i<ratings.length; i++) {
//            if(ratings[i-1]<ratings[i]) {
//                arr[i]=arr[i-1]+1;
//            }
//        }
//        for(int i=0; i<arr.length; i++) {
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//        int v=arr[arr.length-1];
//        for(int i=ratings.length-2; i>=0; i--) {
//            if(ratings[i]>ratings[i+1]) {
//                arr[i]=Math.max(arr[i+1]+1, arr[i]);
//            }
//            v+=arr[i];
//        }
//        for(int i=0; i<arr.length; i++) {
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//        return v;
//    }
    
    
//    ------------------ALTERNATE -> ONLY ONE ARRAY USED, CAN REFACTOR USING Arrays.fill(_, 1)---------------
//    public int candy(int[] ratings) {
//        int[] arr=new int[ratings.length];
//        arr[0]=100000;
//        for(int i=1; i<ratings.length; i++) {
//            if(ratings[i-1]>=ratings[i]) {
//                arr[i]=100000;
//            } else {
//                arr[i]=arr[i-1]+100000;
//            }
//        }
//        arr[arr.length-1]+=1;
//        for(int i=ratings.length-2; i>=0; i--) {
//            if(ratings[i]>ratings[i+1]) {
//                arr[i]+=(arr[i+1]%100000)+1;
//            } else {
//                arr[i]+=1;
//            }
//        }
//        int v=0;
//        for(int i=0; i<arr.length; i++) {
//            v+=Math.max(arr[i]/100000, arr[i]%100000);
//        }
//        return v;
//    }
    
   
//    ------------------ALTERNATE -> TWO ARRAYS USED, CAN REFACTOR USING Arrays.fill(_, 1)---------------
//    public int candy(int[] ratings) {
//        int[] arr=new int[ratings.length];
//        arr[0]=1;
//        for(int i=1; i<ratings.length; i++) {
//            if(ratings[i-1]>=ratings[i]) {
//                arr[i]=1;
//            } else {
//                arr[i]=arr[i-1]+1;
//            }
//        }
//        int[] arr2=new int[ratings.length];
//        arr2[arr2.length-1]=1;
//        for(int i=ratings.length-2; i>=0; i--) {
//            if(ratings[i]>ratings[i+1]) {
//                arr2[i]=arr2[i+1]+1;
//            } else {
//                arr2[i]=1;
//            }
//        }
//        int v=0;
//        for(int i=0; i<arr.length; i++) {
//            System.out.print(arr[i]+" ");
//            v+=Math.max(arr[i], arr2[i]);
//        }
//        System.out.println();
//        for(int i=0; i<arr.length; i++) {
//            System.out.print(arr2[i]+" ");
//        }
//        System.out.println();
//        return v;
//    }
    
    public static void main(String[] args) {
        Candy c=new Candy();
        System.out.println(c.candy(new int[]{1,0,2}));
        System.out.println(c.candy(new int[]{1,2,2}));
        System.out.println(c.candy(new int[]{1,3,2,2,1}));
        System.out.println(c.candy(new int[]{1,2,3,4,5,3,2,1,2,6,5,4,3,3,2,1,1,3,3,3,4,2}));
    }
}
