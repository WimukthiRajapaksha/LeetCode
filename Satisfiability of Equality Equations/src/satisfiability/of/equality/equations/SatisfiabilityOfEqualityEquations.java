/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satisfiability.of.equality.equations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class SatisfiabilityOfEqualityEquations {

    /**
     * @param args the command line arguments
     */
    
//    -----------OPTIMAL -> UNION FIND -> O(E* LOG V) -> O(V)----------------
    public boolean equationsPossible(String[] equations) {
        int[] parent=new int[26];
        for(int i=0; i<parent.length; i++) {
            parent[i]=i;
        }
        for(String e: equations) {
            if(e.charAt(1)=='=') {
                union(e.charAt(0)-'a', e.charAt(3)-'a', parent);
            }
        }
        for(String e: equations) {
            if(e.charAt(1)=='!') {
                if(isSame(e.charAt(0)-'a', e.charAt(3)-'a', parent)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isSame(int i, int j, int[] parent) {
        int parentI=parent(i, parent);
        int parentJ=parent(j, parent);
        return (parentI==parentJ);
    }
    
    private void union(int i, int j, int[] parent) {
        int parentI=parent(i, parent);
        int parentJ=parent(j, parent);
        if(parentI!=parentJ) {
            parent[parentJ]=parentI;
        }
    }
    
    private int parent(int i, int[] parent) {
        if(i==parent[i]) return i;
        parent[i]=parent(parent[i], parent);
        return parent[i];
    }
    
    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations s=new SatisfiabilityOfEqualityEquations();
        System.out.println(s.equationsPossible(new String[]{"a==b","b!=a"}));
        System.out.println(s.equationsPossible(new String[]{"b==a","a==b"}));
        System.out.println(s.equationsPossible(new String[]{"a==b","b!=c","c==a"}));
    }
}
