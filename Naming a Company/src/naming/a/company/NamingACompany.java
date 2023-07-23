/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naming.a.company;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class NamingACompany {

    /**
     * @param args the command line arguments
     */
    
    public long distinctNames(String[] ideas) {
        int[] arr=new int[ideas.length];
        int[] begin=new int[26];
        for(String idea: ideas) {
            begin[idea.charAt(0)-'a']++;
        }
        Map<String, Integer> map=new HashMap<>();
        for(String idea: ideas) {
            String sub=idea.substring(1, idea.length());
            int def=map.getOrDefault(sub, 0);
            int val=def|(1<<(idea.charAt(0)-'a'));
            map.put(sub, val);
            System.out.println(map);
        }
        long count=0;
        for(String s: map.keySet()) {
            for(int i=0; i<26; i++) {
                for(int j=0; j<26; j++) {
                    int first=0;
                    int second=0;
                    if((map.get(s)&(1<<i))!=0) {
                        first=begin[i];
                    }
                    if((map.get(s)&(1<<j))!=0) {
                        second=begin[j];
                    }
                    count+=(first*second);
                    if(first*second>0) {
                        System.out.println(s+" "+count+" "+first+" "+second);
                    }
                }
            }
        }
        System.out.println(count);
        return 0;
    }
    
    public static void main(String[] args) {
        NamingACompany n=new NamingACompany();
        System.out.println(n.distinctNames(new String[]{"coffee","donuts","time","toffee"}));
    }
}

//"offee" - c, t
//"onuts" - d
//"ime" - t

// c - 1
// d - 1
// t - 2

//4
//2
//4
