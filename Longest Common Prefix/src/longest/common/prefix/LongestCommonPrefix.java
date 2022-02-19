/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.common.prefix;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestCommonPrefix {

    /**
     * @param args the command line arguments
     */
    
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        int i=0;
        int max = strs[0].length();
        while(i<max) {
            char temp = strs[0].charAt(i);
            for (int j=1; j<strs.length; j++) {
                if (i>=strs[j].length() || strs[j].charAt(i)!=temp) {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
        return strs[0].substring(0, i);
    }
    
    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
