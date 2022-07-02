/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package license.key.formatting;

/**
 *
 * @author wimukthirajapaksha
 */
public class LicenseKeyFormatting {

    /**
     * @param args the command line arguments
     */
    
    public String licenseKeyFormatting(String s, int k) {
        int i=s.length()-1;
        int t=0;
        StringBuffer sb=new StringBuffer();
        while(i>=0) {
            char c=s.charAt(i);
            if(c=='-') {
                i--;
                while(i>=0 && s.charAt(i)=='-') {
                    i--;
                }
            } else {
                if(t!=0 && t%k==0) {
                    sb.append('-');
                }
                sb.append((c>='a') ? (char)(c-'a'+'A') : c);
                t++;
                i--;
            }
        }
        return sb.reverse().toString();
    }
    
    
//    ---------------------ALTERNATE -> OPTIMAL--------------
//    public String licenseKeyFormatting(String s, int k) {
//        StringBuffer sb=new StringBuffer();
//        for(int i=s.length()-1; i>=0; i--) {
//            char c=s.charAt(i);
//            if(c!='-') {
//                sb.append((sb.length()%(k+1) == k) ? '-' : "").append((c>='a') ? (char)(c-'a'+'A') : c);
//            }
//        }
//        return sb.reverse().toString();
//    }
    
    public static void main(String[] args) {
        LicenseKeyFormatting l=new LicenseKeyFormatting();
        System.out.println(l.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(l.licenseKeyFormatting("2-5g-3-J", 1));
        System.out.println(l.licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(l.licenseKeyFormatting("--a-a-a-a--", 2));
        System.out.println(l.licenseKeyFormatting("-------", 2));
    }
}
