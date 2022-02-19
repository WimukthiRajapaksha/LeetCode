/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package length.of.last.word;

/**
 *
 * @author wimukthirajapaksha
 */
public class LengthOfLastWord {

    /**
     * @param args the command line arguments
     */
    
    public int lengthOfLastWord(String s) {
        int i=s.length()-1;
        while(i>=0) {
            if (s.charAt(i)!=' ') {
                break;
            }
            i--;
        }
        int j=i;
        while(j>=0) {
            if (s.charAt(j)==' ') {
                break;
            }
            j--;
        }
        return i-j;
    }
    
//    public int lengthOfLastWord(String s) {
//        int length=0;
//        boolean last=false;
//        for (int i=s.length()-1; i>=0; i--) {
//            if (s.charAt(i)==' ') {
//                if(!last) {
//                    continue;
//                } 
//                return length;
//            } else {
//                last=true;
//                length++;
//            }
//        }
//        return length;
//    }
    
    
//    public int lengthOfLastWord(String s) {
//        if (s.charAt(s.length()-1)==" ".charAt(0)) {
//            return lengthOfLastWord(s.substring(0, s.length()-1));
//        } else {
//            for (int i=s.length()-1; i>=0; i--) {
//                if (s.charAt(i)==" ".charAt(0)) {
//                    return s.length()-1-i;
//                }
//            }
//            return s.length();
//        }
//    }
    
    
//    public int lengthOfLastWord(String s) {
//        String[] list = s.trim().split(" ");
//        System.out.println(list[list.length-1].length());
//        return list[list.length-1].length();
//    }
    
    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(l.lengthOfLastWord("Hello World"));
        System.out.println(l.lengthOfLastWord("a "));
    }
    
}
