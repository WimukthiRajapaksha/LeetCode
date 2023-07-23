/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unique.number.of.occurrences;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class UniqueNumberOfOccurrences {

    /**
     * @param args the command line arguments
     */
    
    
//    --------OPTIMAL -> O(N), O(1)-----------
    public boolean uniqueOccurrences(int[] arr) {
        int[] count=new int[2001];
        for(int i: arr) {
            count[i+1000]++;
        }
        Set<Integer> set=new HashSet<>();
        for(int i: count) {
            if(i!=0) {
                if(set.contains(i)) return false;
                set.add(i);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        UniqueNumberOfOccurrences u=new UniqueNumberOfOccurrences();
        System.out.println(u.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(u.uniqueOccurrences(new int[]{1,2}));
        System.out.println(u.uniqueOccurrences(new int[]{1,1,2}));
        System.out.println(u.uniqueOccurrences(new int[]{1,1,2,2}));
        System.out.println(u.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
