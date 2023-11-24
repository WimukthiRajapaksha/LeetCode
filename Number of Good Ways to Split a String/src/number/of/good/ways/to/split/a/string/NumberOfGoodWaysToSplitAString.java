/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.good.ways.to.split.a.string;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOfGoodWaysToSplitAString {

    /**
     * @param args the command line arguments
     */
    
//    ----------------OPTIMAL -> O(N), O(1)-------------
    public int numSplits(String s) {
        int[] countRight=new int[26];
        boolean[] countLeft=new boolean[26];
        int left=0;
        int right=0;
        for(char c: s.toCharArray()) {
            if(countRight[c-'a']==0) right++;
            countRight[c-'a']++;
        }
        int count=0;
        for(int i=0; i<s.length(); i++) {
            if(countRight[s.charAt(i)-'a']==1) {
                right--;
            }
            if(!countLeft[s.charAt(i)-'a']) {
                left++;
            }
            countRight[s.charAt(i)-'a']--;
            countLeft[s.charAt(i)-'a']=true;
            if(left==right) count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        NumberOfGoodWaysToSplitAString n=new NumberOfGoodWaysToSplitAString();
        System.out.println(n.numSplits("aacaba"));
        System.out.println(n.numSplits("abcd"));
    }
}
