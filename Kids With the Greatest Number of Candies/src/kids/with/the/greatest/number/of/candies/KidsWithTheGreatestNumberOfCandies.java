/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.with.the.greatest.number.of.candies;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class KidsWithTheGreatestNumberOfCandies {

    /**
     * @param args the command line arguments
     */
    
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list=new ArrayList<>();
        int max=0;
        for (int i: candies) {
            if (max<i) {
                max=i;
            }
        }
        for (int i: candies) {
            list.add(extraCandies+i>=max);
        }
        System.out.println(list);
        return list;
    }
    
    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies k=new KidsWithTheGreatestNumberOfCandies();
        k.kidsWithCandies(new int[]{2,3,5,1,3}, 3);
    }
    
}
