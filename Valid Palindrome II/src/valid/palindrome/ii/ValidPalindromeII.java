/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid.palindrome.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class ValidPalindromeII {

    /**
     * @param args the command line arguments
     */
    
//    ----------------------OPTIMAL---------------------
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) {
                return isValid(s, i+1, j) || isValid(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    
    
    private boolean isValid(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    
//    -------------------ALTERNATE -> NOT BEAUTIFUL-----------------
//    public boolean validPalindrome(String s) {
//        int i=0;
//        int j=s.length()-1;
//        int[] ret=isValid(s, i, j);
//        if(ret[0]==-1) return true;
//        int[] ext=isValid(s, ret[0], ret[1]-1);
//        int[] ext1=isValid(s, ret[0]+1, ret[1]);
//        return (ext[0]==-1 || ext1[0]==-1);
//    }
//    
//    
//    private int[] isValid(String s, int i, int j) {
//        while(i<j) {
//            if(s.charAt(i)!=s.charAt(j)) return new int[]{i, j};
//            i++;
//            j--;
//        }
//        return new int[]{-1, -1};
//    }
    
    
    public static void main(String[] args) {
        ValidPalindromeII v=new ValidPalindromeII();
        System.out.println(v.validPalindrome("aba"));
        System.out.println(v.validPalindrome("abc"));
        System.out.println(v.validPalindrome("abca"));
        System.out.println(v.validPalindrome("aabaaa"));
        System.out.println(v.validPalindrome("aaaalaaaalallalalalalallalallaallalaututututututu"));
        System.out.println(v.validPalindrome("aaaalaaaalallalalalalallalallaallalautututututuu"));
        System.out.println(v.validPalindrome("eeccccbebaeeabebccceea"));
        System.out.println(v.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}



//aguokepatgbnvfqmgmlc
//upuufxoohdfpgjdmysgv
//hmvffcnqxjjxqncffvmh
//vgsymdjgpfdhooxfuupu
//culmgmqfvnbgtapekoug
//a
        
        
//qxjjxq u