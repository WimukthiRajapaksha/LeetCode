/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.cookies;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class AssignCookies {

    /**
     * @param args the command line arguments
     */
    
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        if(g[0]>s[s.length-1]) return 0;
        int t=0;
        for(int i=0; i<s.length && t<g.length; i++) {
            if(g[t]<=s[i]) {
                t++;
            }
        }
        return t;
    }
    
    public static void main(String[] args) {
        AssignCookies a=new AssignCookies();
        a.findContentChildren(new int[]{1,2,3}, new int[]{1,1});
        a.findContentChildren(new int[]{1,2}, new int[]{1,2,3});
    }
}
