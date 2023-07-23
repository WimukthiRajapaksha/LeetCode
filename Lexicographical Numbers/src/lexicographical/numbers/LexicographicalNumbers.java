/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicographical.numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class LexicographicalNumbers {

    /**
     * @param args the command line arguments
     */
    
//    ---------------OPTIMAL -> O(N), O(N)---------------
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret=new ArrayList<>();
        int current=1;
        for(int i=1; i<=n; i++) {
            ret.add(current);
            if(current*10<=n) {
                current*=10;
            } else {
                if(current>=n) {
                    current/=10;
                }
                current++;
                while(current%10==0) {
                    current/=10;
                }
            }
        }
        return ret;
    }
    
//    ---------------OPTIMAL -> O(N), O(N)---------------
//    public List<Integer> lexicalOrder(int n) {
//        List<Integer> ret=new ArrayList<>();
//        for(int i=1; i<10; i++) {
//            dfs(i, n, ret);
//        }
//        return ret;
//    }
//    
//    private void dfs(int i, int n, List<Integer> ret) {
//        if(i>n) return;
//        ret.add(i);
//        int num=(i*10);
//        for(int j=0; j<=9; j++) {
//            if(num+j<n) dfs(num+j, n, ret);
//        }
//    }
    
    public static void main(String[] args) {
        LexicographicalNumbers lex=new LexicographicalNumbers();
        System.out.println(lex.lexicalOrder(130));
        System.out.println(lex.lexicalOrder(2));
    }
}
