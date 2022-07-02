/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compare.version.numbers;

import java.util.regex.Pattern;

/**
 *
 * @author wimukthirajapaksha
 */
public class CompareVersionNumbers {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------------------ALTERNATE -> OPTIMAL -> BEAUTIFUL---------------------
    public int compareVersion(String version1, String version2) {
        int i=0;
        int j=0;
        while(i<version1.length() || j<version2.length()) {
            int p=0;
            int q=0;
            while(i<version1.length() && version1.charAt(i)!='.') {
                p=(p*10)+(version1.charAt(i)-'0');
                i++;
            }
            i++;
            while(j<version2.length() && version2.charAt(j)!='.') {
                q=(q*10)+(version2.charAt(j)-'0');
                j++;
            }
            j++;
            if(p<q) return -1;
            else if(p>q) return 1;
        }
        return 0;
    }
    
    
    
//    ---------------------ALTERNATE -> OPTIMAL---------------------
//    public int compareVersion(String version1, String version2) {
//        int i=0;
//        int j=0;
//        while(i<version1.length() || j<version2.length()) {
//            StringBuffer s1=new StringBuffer();
//            StringBuffer s2=new StringBuffer();
//            s1.append("0");
//            s2.append("0");
//            while(i<version1.length() && version1.charAt(i)!='.') {
//                s1.append(version1.charAt(i));
//                i++;
//            }
//            i++;
//            while(j<version2.length() && version2.charAt(j)!='.') {
//                s2.append(version2.charAt(j));
//                j++;
//            }
//            j++;
//            if(Integer.valueOf(s1.toString())<Integer.valueOf(s2.toString())) return -1;
//            else if(Integer.valueOf(s1.toString())>Integer.valueOf(s2.toString())) return 1;
//        }
//        return 0;
//    }
    
    
    
//    ---------------------ALTERNATE -> OPTIMAL---------------------
//    public int compareVersion(String version1, String version2) {
//        String[] arr1=version1.split("\\.");
//        String[] arr2=version2.split("\\.");
//        for(int i=0; i<3; i++) {
//            Integer i1= (arr1.length>i) ? Integer.valueOf(arr1[i]) : 0;
//            Integer i2= (arr2.length>i) ? Integer.valueOf(arr2[i]) : 0;
//            if(i1.compareTo(i2)!=0) {
//                return i1.compareTo(i2);
//            }
//        }
//        return 0;
//    }
    
    public static void main(String[] args) {
        CompareVersionNumbers c=new CompareVersionNumbers();
        System.out.println(c.compareVersion("1.01", "1.001"));
        System.out.println(c.compareVersion("1.0", "1.0.0"));
        System.out.println(c.compareVersion("0.1", "1.1"));
        System.out.println(c.compareVersion("1.0.1", "1"));
    }
}
