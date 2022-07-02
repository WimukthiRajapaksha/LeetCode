/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restore.ip.addresses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class RestoreIPAddresses {

    /**
     * @param args the command line arguments
     */
    
    
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<>();
        if(s.length()<4 || s.length()>12) return list;
        int[] arr=new int[4];
        backtrack(list, arr, s, 0, 0);
        System.out.println(list);
        return list;
    }
    
    private void backtrack(List<String> list, int[] path, String s, int builderIndex, int segment) {
        if(segment==4 && builderIndex==s.length()) {
            StringBuilder sb=new StringBuilder();
            list.add(sb.append(path[0]).append(".").append(path[1]).append(".").append(path[2]).append(".").append(path[3]).toString());
            return;
        } else if(segment==4 && builderIndex!=s.length()) {
            return;
        }
        for(int i=1; i<=3 && builderIndex+i<=s.length(); i++) {
            int v=Integer.valueOf(s.substring(builderIndex, builderIndex+i));
            if(v>255 || (i>1 && s.charAt(builderIndex)=='0')) {
                break;
            }
            path[segment]=v;
            backtrack(list, path, s, builderIndex+i, segment+1);
        }
    }
    
    
    
//    --------------------------ALTERNATE---------------------------
//    public List<String> restoreIpAddresses(String s) {
//        List<String> list=new ArrayList<>();
//        backtrack(list, new StringBuilder(), s, 0, 0);
//        System.out.println(list);
//        return list;
//    }
//    
//    private void backtrack(List<String> list, StringBuilder sb, String s, int i, int dotCount) {
//        if(i==s.length()) {
//            if(dotCount!=4) return;
//            list.add(sb.toString().substring(0, sb.length()-1));
//            return;
//        }
//        int length=sb.length();
//        for(int j=i+1; j<=s.length(); j++) {
//            int v=Integer.valueOf(s.substring(i, j));            
//            if(v>255 || (j-i>1 && s.charAt(i)=='0')) break;
//            sb.append(v).append(".");
//            backtrack(list, sb, s, j, dotCount+1);
//            sb.setLength(length);
//        }
//    }
    
    
//    --------------------------ALTERNATE---------------------------
//    public List<String> restoreIpAddresses(String s) {
//        List<String> res = new ArrayList<String>();
//        int len = s.length();
//        for(int i = 1; i<4 && i<len-2; i++){
//            for(int j = i+1; j<i+4 && j<len-1; j++){
//                for(int k = j+1; k<j+4 && k<len; k++){
//                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
//                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
//                        res.add(s1+"."+s2+"."+s3+"."+s4);
//                    }
//                }
//            }
//        }
//        return res;
//    }
//    
//    public boolean isValid(String s){
//        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
//            return false;
//        return true;
//    }
    
   
//    --------------------------ALTERNATE---------------------------
//    public List<String> restoreIpAddresses(String s) {
//        List<String> ret = new ArrayList<>();
//
//        StringBuffer ip = new StringBuffer();
//        for(int a = 1 ; a < 4 ; ++ a)
//        for(int b = 1 ; b < 4 ; ++ b)
//        for(int c = 1 ; c < 4 ; ++ c)
//        for(int d = 1 ; d < 4 ; ++ d) {
//            if(a + b + c + d == s.length()) {
//                int n1 = Integer.parseInt(s.substring(0, a));
//                int n2 = Integer.parseInt(s.substring(a, a+b));
//                int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
//                int n4 = Integer.parseInt(s.substring(a+b+c));
//                if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
//                    ip.append(n1).append('.').append(n2).append('.').append(n3).append('.').append(n4);
//                    if(ip.length() == s.length() + 3) ret.add(ip.toString());
//                    ip.delete(0, ip.length());
//                }
//            }
//        }
//        System.out.println(ret);
//        return ret;
//    }
    
    public static void main(String[] args) {
        RestoreIPAddresses r=new RestoreIPAddresses();
        r.restoreIpAddresses("101023");
        r.restoreIpAddresses("25525511135");
        r.restoreIpAddresses("255255255255");
        r.restoreIpAddresses("19216811");
        r.restoreIpAddresses("1231231231234");
        r.restoreIpAddresses("253578103984");
    }
}
