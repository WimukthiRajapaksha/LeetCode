/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package can.place.flowers;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class CanPlaceFlowers {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------------------------OPTIMAL -> O(N), O(1)--------------------------
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        for(int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i]==0 && (i-1<0 || flowerbed[i-1]==0) && (i+1>=flowerbed.length || flowerbed[i+1]==0)) {
                count++;
                flowerbed[i]=1;
            }
            if(count>=n) return true;
        }
        return false;
    }
    
    
//    ---------------------------ALTERNATE -> O(N), O(N)--------------------------
//    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int[] arr=new int[flowerbed.length+3];
//        for(int i=3; i<arr.length; i++) {
//            if(flowerbed[i-3]==1) {
//                arr[i]=Math.max(arr[i-2], arr[i-3]);
//            } else {
//                arr[i]=Math.max(arr[i-2], arr[i-3]);
//                if((i-4<0 || flowerbed[i-4]==0) && (i-2>=flowerbed.length || flowerbed[i-2]==0)) {
//                    arr[i]++;
//                }
//            }
//        }
//        return Math.max(arr[arr.length-1], arr[arr.length-2])>=n;
//    }
    
    public static void main(String[] args) {
        CanPlaceFlowers c=new CanPlaceFlowers();
        System.out.println(c.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println(c.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        System.out.println(c.canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2));
    }
}
