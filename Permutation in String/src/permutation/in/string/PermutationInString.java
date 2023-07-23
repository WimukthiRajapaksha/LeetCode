/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutation.in.string;

/**
 *
 * @author wimukthirajapaksha
 */
public class PermutationInString {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------------OPTIMAL -> O(l1+(26*(l2-l1)), O(1)--------------------
//    public boolean checkInclusion(String s1, String s2) {
//        if(s1.length()>s2.length()) return false;
//        int[] hm=new int[26];
//        int[] arr=new int[26];
//        for(int i=0; i<s1.length(); i++) {
//            hm[s1.charAt(i)-'a']++;
//            arr[s2.charAt(i)-'a']++;
//        }
//        for(int i=0; i<s2.length()-s1.length(); i++) {
//            if(matching(hm, arr)) return true;
//            arr[s2.charAt(i+s1.length())-'a']++;
//            arr[s2.charAt(i)-'a']--;
//        }
//        return matching(hm, arr);
//    }
//
//    private boolean matching(int[] i, int[] j) {
//        for(int k=0; k<26; k++) {
//            if(i[k]!=j[k]) return false;
//        }
//        return true;
//    }
    
    
    
//    ------------------OPTIMAL -> O(l1+(l2-l1), O(1)--------------------
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] hm=new int[26];
        int[] arr=new int[26];
        for(int i=0; i<s1.length(); i++) {
            hm[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']++;
        }
        int count=0;
        for(int i=0; i<26; i++) {
            if(hm[i]==arr[i]) count++;
        }
        for(int i=0; i<s2.length()-s1.length(); i++) {
            int r=s2.charAt(i+s1.length())-'a';
            int l=s2.charAt(i)-'a';
            if(count==26) return true;
            arr[r]++;
            if(hm[r]==arr[r]) count++;
            else if(hm[r]+1==arr[r]) count--;
            arr[l]--;
            if(hm[l]==arr[l]) count++;
            else if(hm[l]-1==arr[l]) count--;
        }
        return count==26;
    }
    
    
    public static void main(String[] args) {
        PermutationInString p=new PermutationInString();
        System.out.println(p.checkInclusion("ab", "eidbaooo"));
        System.out.println(p.checkInclusion("ab", "eidboaoo"));
    }
}
