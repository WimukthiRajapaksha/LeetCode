/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome.partitioning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class PalindromePartitioning {

    /**
     * @param args the command line arguments
     */
    
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<>();
        boolean[][] pal=new boolean[s.length()][s.length()];
        backtrack(list, new ArrayList<>(), pal, 0, s);
        System.out.println(list);
        return list;
    }
    
    private void backtrack(List<List<String>> list, List<String> l, boolean[][] isPal, int i, String s) {
        if(i>=s.length()) {
            list.add(new ArrayList<>(l));
            return;
        }
        for(int j=i; j<s.length(); j++) {
            if(s.charAt(i)==s.charAt(j) && ((j-i<=2) || isPal[i+1][j-1])) {
                isPal[i][j]=true;
                l.add(s.substring(i, j+1));
                backtrack(list, l, isPal, j+1, s);
                l.remove(l.size()-1);
            }
        }
    }
    
    
    
    
//    public List<List<String>> partition(String s) {
//        List<List<String>> list=new ArrayList<>();
//        backtrack(list, new ArrayList<String>(), 0, s);
//        return list;
//    }
//    
//    private void backtrack(List<List<String>> list, List<String> l, int i, String s) {
//        if(i==s.length()) {
//            list.add(new ArrayList<>(l));
//            return;
//        }
//        for(int j=i+1; j<=s.length(); j++) {
//            if(isPalindrome(s, i, j-1)) {
//                l.add(s.substring(i, j));
//                backtrack(list, l, j, s);
//                l.remove(l.size()-1);
//            }
//        }
//    }
//    
//    private boolean isPalindrome(String s, int i, int j) {
//        while(i<j) {
//            if(s.charAt(i)!=s.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
    
    
    
    
    
//    public List<List<String>> partition(String s) {
//        List<List<String>> list=new ArrayList<>();
//        backtrack(list, new ArrayList<String>(), 0, s, new HashSet<>());
//        System.out.println(list);
//        return list;
//    }
//    
//    private void backtrack(List<List<String>> list, List<String> l, int i, String s, Set<String> set) {
//        if(i>=s.length()) {
//            list.add(new ArrayList<>(l));
//            return;
//        }
//        for(int j=i+1; j<=s.length(); j++) {
//            System.out.println(s.substring(i, j));
//            if(set.contains(s.substring(i, j)) || isPalindrome(s, i, j-1)) {
//                l.add(s.substring(i, j));
//                set.add(s.substring(i, j));
//                backtrack(list, l, j, s, set);
//                l.remove(l.size()-1);
//            }
//        }
//    }
//    
//    private boolean isPalindrome(String s, int i, int j) {
//        while(i<j) {
//            if(s.charAt(i)!=s.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        PalindromePartitioning p=new PalindromePartitioning();
        p.partition("aab");
        p.partition("efe");
    }
}
