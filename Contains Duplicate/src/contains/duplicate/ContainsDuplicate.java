/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contains.duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class ContainsDuplicate {

    /**
     * @param args the command line arguments
     */
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i: nums) {
            if(set.add(i)) {
            } else {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        ContainsDuplicate c=new ContainsDuplicate();
        System.out.println(c.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
        System.out.println(c.containsDuplicate(new int[]{1,2,3,4}));
    }
}
