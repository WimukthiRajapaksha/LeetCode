/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.items.matching.a.rule;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountItemsMatchingARule {

    /**
     * @param args the command line arguments
     */
    
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count=0;
        int ke=0;
        if (ruleKey.equals("color")) {
            ke=1;
        } else if (ruleKey.equals("name")) {
            ke=2;
        }
        for (List<String> item: items) {
            count += (item.get(ke).equals(ruleValue)) ? 1 : 0;
        }
        System.out.println(count);
        return count;
    }
    
    public static void main(String[] args) {
        CountItemsMatchingARule c=new CountItemsMatchingARule();
        List<List<String>> items=new ArrayList<>();
        List<String> l1=new ArrayList<>();
        l1.add("phone");
        l1.add("blue");
        l1.add("pixel");
        items.add(l1);
        List<String> l2=new ArrayList<>();
        l2.add("computer");
        l2.add("silver");
        l2.add("lenovo");
        items.add(l2);
        List<String> l3=new ArrayList<>();
        l3.add("phone");
        l3.add("gold");
        l3.add("iphone");
        items.add(l3);
        c.countMatches(items, "color", "silver");
    }
    
}
