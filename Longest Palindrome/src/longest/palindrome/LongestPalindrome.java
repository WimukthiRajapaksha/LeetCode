/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.palindrome;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestPalindrome {

    /**
     * @param args the command line arguments
     */
    
    public int longestPalindrome(String s) {
        int[] list=new int[128];
        for(char c: s.toCharArray()) {
            list[c]++;
        }
        int ret=0;
        for(int i: list) {
            ret+=i/2*2;
        }
        return ret==s.length() ? ret : ret+1;
    }
    
    
//    --------------------ALTERNATE--------------------
//    public int longestPalindrome(String s) {
//        int[] list=new int[128];
//        for(char c: s.toCharArray()) {
//            list[c]++;
//        }
//        int ret=0;
//        for(int i: list) {
//            ret+=i/2*2;
//            if(ret%2==0 && i%2==1) ret++;
//        }
//        return ret;
//    }
    

//    --------------------ALTERNATE--------------------
//    public int longestPalindrome(String s) {
//        int[] list=new int[52];
//        for(char c: s.toCharArray()) {
//            if(c<='Z') {
//                list[c-'A']++;
//            } else {
//                list[c-'a'+26]++;
//            }
//        }
//        int ret=0;
//        for(int i: list) {
//            ret+=i/2*2;
//            if(ret%2==0 && i%2==1) ret++;
//        }
//        return ret;
//    }
    
    
//    --------------------ALTERNATE--------------------
//    public int longestPalindrome(String s) {
//        int[] list=new int[128];
//        for(char c: s.toCharArray()) {
//            list[c]++;
//        }
//        int ret=0;
//        for(int i: list) {
//            ret+=i/2*2;
//            if(ret%2==0 && i%2==1) ret++;
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        LongestPalindrome l=new LongestPalindrome();
        System.out.println(l.longestPalindrome("abccccdd"));
        System.out.println(l.longestPalindrome("a"));
        System.out.println(l.longestPalindrome("bb"));
        System.out.println(l.longestPalindrome("AAAAAA"));
        System.out.println(l.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
