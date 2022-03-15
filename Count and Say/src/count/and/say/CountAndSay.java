/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.and.say;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountAndSay {

    /**
     * @param args the command line arguments
     */
    
    public String countAndSay(int n) {
        if(n==1) return "1";
        String s=countAndSay(n-1);
        StringBuilder r=new StringBuilder();
        int c=1;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i-1)!=s.charAt(i)) {
                r.append(c).append(s.charAt(i-1));
                c=1;
            } else {
                c++;
            }
        }
        r.append(c).append(s.charAt(s.length()-1));
        return r.toString();
    }
    
    public static void main(String[] args) {
        CountAndSay c=new CountAndSay();
        System.out.println(c.countAndSay(7));
    }
}
