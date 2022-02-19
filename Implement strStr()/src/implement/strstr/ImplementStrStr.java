 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement.strstr;

/**
 *
 * @author wimukthirajapaksha
 */
public class ImplementStrStr {

    /**
     * @param args the command line arguments
     */
    
    public int strStr(String h, String needle) {
        if (h.length()==needle.length()) {
            return h.equals(needle) ? 0 : -1;
        } else if (needle.length()==0) {
            return 0;
        } else if (h.length()==0) {
            return -1;
        }
        int[] a = pat(needle);
        int j=0;
        for (int i=0; i<h.length();) {
            if(h.charAt(i)==needle.charAt(j)) {
                j++;
                i++;
            } else if (j==0) {
                i++;
            } else {
                j=a[--j];
            }
            if(j==needle.length()) {
                return i-j;
            }
        }
        return -1;
    }
    
    public int[] pat(String s) {
        int[] a=new int[s.length()];
        int i=0;
        int j=1;
        while(j<s.length()) {
            if(s.charAt(i)==s.charAt(j)) {
                a[j]=++i;
            } else if (i!=0) {
                while(i>0 && s.charAt(i)!=s.charAt(j)) {
                    i=a[--i];
                }
                if (s.charAt(i)==s.charAt(j)) {
                    a[j]=++i;
                }
            }
            j++;
        }
        return a;
    }
    
    
//    KMP ALGORITHM HAS BEEN USED HERE AS EXPECTED IN THE PROBLEM
//    public int strStr(String haystack, String needle) {
//        if (needle.equals("") || haystack.equals(needle)) {
//            return 0;
//        } else if (haystack.equals("") || haystack.length()<needle.length()) {
//            return -1;
//        }
//        int[] pattern = arrange(needle);
//        int pattInd=0;
//        int i=0;
//        while(i<haystack.length()) {
//            char hayI = haystack.charAt(i);
//            char needlePattInd = needle.charAt(pattInd);
//            if (needlePattInd==hayI) {
//                pattInd++;
//                i++;
//            } else if(pattInd==0) {
//                i++;
//            } else {
//                pattInd=pattern[--pattInd];
//            }
//            if (pattInd==needle.length()) {
//                return i-needle.length();
//            }
//        }
//        return -1;
//    }
//
//    
//    public int[] arrange(String pattern) {
//        int[] ret = new int[pattern.length()];
//        int temp = 0;
//        int i=1;
//        while(i<pattern.length()) {
//            char pattTemp = pattern.charAt(temp);
//            char pattI = pattern.charAt(i);
//            if (pattTemp==pattI) {
//                ret[i]=temp+1;
//                temp++;
//                i++;
//            } else if (temp==0) {
//                i++;
//            } else {
//                temp = ret[--temp];
//            }
//        }
//        for (int j: ret) {
//            System.out.print(j+" ,");
//        }
//        System.out.println();
//        return ret;
//    }
    
//    -----------------ALTERNATES-------------------------
//    public int strStr(String haystack, String needle) {
//        if (needle.equals("") || haystack.equals(needle)) {
//            return 0;
//        } else if (haystack.equals("")) {
//            return -1;
//        }
//        for (int i=0;;i++) {
//            for (int j=0;;j++) {
//                if (j==needle.length()) {
//                    return i;
//                }
//                if (i+j==haystack.length()) {
//                    return -1;
//                }
//                if (needle.charAt(j)!=haystack.charAt(i+j)) {
//                    break;
//                }
//            }
//        }
//    }
    
    
    
//    public int strStr(String haystack, String needle) {
//        if (needle.equals("") || haystack.equals(needle)) {
//            return 0;
//        }
//        int i=needle.length();
//        while(i<haystack.length()) {
//            if (haystack.substring(i-needle.length(), i).equals(needle)) {
//                return i-needle.length();
//            } else {
//                i++;
//            }
//        }
//        return -1;
//    }
    
    
    
//    public int strStr(String haystack, String needle) {
//        if (needle.equals("") || haystack.equals(needle)) {
//            return 0;
//        }
//        int i=0;
//        while(i+needle.length()<=haystack.length()) {
//            if (haystack.substring(i, i+needle.length()).equals(needle)) {
//                return i;
//            } else {
//                i++;
//            }
//        }
//        return -1;
//    }
    
    
//    public int strStr(String haystack, String needle) {
//        if (needle.equals("") || haystack.equals(needle)) {
//            return 0;
//        } else if (haystack.equals("") || haystack.length()<needle.length()) {
//            return -1;
//        }
//        int i=needle.length()-1;
//        int j=needle.length()-1;
//        while(i<haystack.length() && i>=0 && j<needle.length() && j>=0) {
//            if (haystack.charAt(i)==needle.charAt(j)) {
//                j--;
//                i--;
//            } else {
//                i=i+(needle.length()-j);
//                j=needle.length()-1;
//            }
//            if (j<0) {
//                return i+1;
//            }
//            System.out.println(i+" "+j);
//        }
//        if (j<0) {
//            return i+1;
//        }
//        return -1;
//    }
    
    
    
//    public int strStr(String haystack, String needle) {
//        if (needle.equals("") || haystack.equals(needle)) {
//            return 0;
//        }
//        int i=0;
//        int j=0;
//        while(i<haystack.length() && j<needle.length()) {
//            if (haystack.charAt(i)==needle.charAt(j)) {
//                j++;
//                i++;
//            } else {
//                i=i-j+1;
//                j=0;
//            }
//            if (needle.length()==j) {
//                return i-j;
//            }
//            System.out.println(i+" "+j);
//        }
//        if (j==needle.length()) {
//            return i-j;
//        }
//        return -1;
//    }
    
    public static void main(String[] args) {
        ImplementStrStr i = new ImplementStrStr();
        System.out.println(i.strStr("ababcaababcaabc", "ababcaabc"));
        System.out.println(i.strStr("hello", "ll"));
        System.out.println(i.strStr("mississippi", "issip"));
    }
    
}