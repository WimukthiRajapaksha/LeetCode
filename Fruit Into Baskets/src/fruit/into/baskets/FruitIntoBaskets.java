/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.into.baskets;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class FruitIntoBaskets {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------------OPTIMAL -> O(N), O(1)--------------------
    public int totalFruit(int[] fruits) {
        int left=0;
        int right=0;
        int max=0;
        int count=0;
        Map<Integer, Integer> map=new HashMap<>();
        while(right<fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);
            count++;
            while(map.size()>2) {
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left])==0) map.remove(fruits[left]);
                left++;
                count--;
            }
            right++;
            max=Math.max(max, count);
//            System.out.println(map);
        }
//        max=Math.max(max, second-first-1);
        return max;
    }
    
    public static void main(String[] args) {
        FruitIntoBaskets f=new FruitIntoBaskets();
        System.out.println(f.totalFruit(new int[]{1,2,1}));
        System.out.println(f.totalFruit(new int[]{0,1,2,2}));
        System.out.println(f.totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(f.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
        System.out.println(f.totalFruit(new int[]{1,0,1,4,1,4,1,2,3}));
    }
}
