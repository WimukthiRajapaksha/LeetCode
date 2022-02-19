/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid.palindrome;

/**
 *
 * @author wimukthirajapaksha
 */
public class ValidPalindrome {

    /**
     * @param args the command line arguments
     */
    
//    --------------------ALTERNATE -> NOT OPTIMAL AT ALL-----------------------
//    public boolean isPalindrome(String s) {
//        s = s.toLowerCase().replaceAll("[^a-z0-9]", "").toLowerCase();
//        String first = s.substring(0, s.length()/2);
//        String second = s.substring(s.length()/2, s.length());
//        int i=0;
//        int j=s.length()-1;
//        while(i<s.length()/2) {
//            if (s.charAt(i)!=s.charAt(j)) {
//                return false;
//            } else {
//                i++;
//                j--;
//            }
//        }
//        return true;
//    }

//    ------------------------ALTERNATE -> NOT OPTIMAL--------------------------
//    public boolean isPalindrome(String s) {
//        int i=0;
//        int j=s.length()-1;
//        while(i<j) {
//            int b1 = vali(s.charAt(i));
//            int b2 = vali(s.charAt(j));
////            System.out.println(s.charAt(i)+" "+s.charAt(j)+" "+b1+" "+b2);
//            if (b1>=0 && b2>=0) {
////                System.out.println(s.charAt(i)+" "+s.charAt(j)+" "+b1+" "+b2);
//                if (b1==b2) {
//                    i++;
//                    j--;
//                    continue;
//                } else {
//                    return false;
//                }
//            } else if (b1>=0) {
//                j--;
//                continue;
//            } else if (b2>=0) {
//                i++;
//                continue;
//            } else {
//                i++;
//                j--;
//                continue;
//            }
//        }
//        return true;
//    }
    
    
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j) {
            int b1 = vali(s.charAt(i));
            int b2 = vali(s.charAt(j));
            if (b1<0) {
                while(i<j && b1<0) {
                    i++;
                    b1=vali(s.charAt(i));
                }
            }
            if (b2<0) {
                while(i<j && b2<0) {
                    j--;
                    b2=vali(s.charAt(j));
                }
            }
            if (b1!=b2) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    
    public int vali(char c) {
        if (c>='A'&& c<='Z') {
            return c-'A';
        } else if (c>='a' && c<='z') {
            return c-'a';
        } else if (c>='0' && c<='9') {
            return c;
        } else {
            return -1;
        }
    }
    
    
//    -------------------ALTERNATE -> USING INBUILT FUNCTIONS, NOT OPTIMAL--------------------
//    public boolean isPalindrome(String s) {
//        int i=0;
//        int j=s.length()-1;
//        while(i<=j) {
//            boolean b1 = Character.isLetterOrDigit(s.charAt(i));
//            boolean b2 = Character.isLetterOrDigit(s.charAt(j));
//            if (!b1) {
//                while(i<j && !b1) {
//                    i++;
//                    b1=Character.isLetterOrDigit(s.charAt(i));
//                }
//            }
//            if (!b2) {
//                while(i<j && !b2) {
//                    j--;
//                    b2=Character.isLetterOrDigit(s.charAt(j));
//                }
//            }
//            if (Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) {
//                return false;
//            } else {
//                i++;
//                j--;
//            }
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(v.isPalindrome("race a car"));
        System.out.println(v.isPalindrome(" "));
    }
}
