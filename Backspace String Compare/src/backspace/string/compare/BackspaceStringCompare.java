/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backspace.string.compare;

/**
 *
 * @author wimukthirajapaksha
 */
public class BackspaceStringCompare {

    /**
     * @param args the command line arguments
     */
    
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1;
        int j=t.length()-1;
        while(i>=0 || j>=0) {
            int skipS=0;
            int skipT=0;
            while(i>=0) {
                if(s.charAt(i)=='#') {
                    skipS++;
                    i--;
                } else if(skipS>0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            
            while(j>=0) {
                if(t.charAt(j)=='#') {
                    skipT++;
                    j--;
                } else if(skipT>0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if((i>=0 && j>=0 && s.charAt(i)!=t.charAt(j))) return false;
            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }
    
//    ------------------------ALTERNATE -> O(M+N)-------------------------
//    public boolean backspaceCompare(String s, String t) {
//        StringBuilder sb1=new StringBuilder();
//        StringBuilder sb2=new StringBuilder();
//        for(char c: s.toCharArray()) {
//            if(c=='#') {
//                if (sb1.length()>0) sb1.setLength(sb1.length()-1);
//            } else {
//                sb1.append(c);
//            }
//        }
//        for(char c: t.toCharArray()) {
//            if(c=='#') {
//                if (sb2.length()>0) sb2.setLength(sb2.length()-1);
//            } else {
//                sb2.append(c);
//            }
//        }
//        return sb1.toString().equals(sb2.toString());
//    }
    
    
//    ------------------ALTERNATE -> SPACE O(M+N)----------------
//    public boolean backspaceCompare(String s, String t) {
//        char[] arr1=new char[s.length()];
//        char[] arr2=new char[t.length()];
//        int i=0;
//        int j=0;
//        for(char c: s.toCharArray()) {
//            if(c=='#') {
//                i--;
//                if (i<0) i=0;
//            } else {
//                arr1[i++]=c;
//            }
//        }
//        for(char c: t.toCharArray()) {
//            if(c=='#') {
//                j--;
//                if (j<0) j=0;
//            } else {
//                arr2[j++]=c;
//            }
//        }
//        return (new String(arr1, 0, i)).equals((new String(arr2, 0, j)));
//    }
    
    public static void main(String[] args) {
        BackspaceStringCompare b=new BackspaceStringCompare();
        System.out.println(b.backspaceCompare("ab#c", "ad#c"));
        System.out.println(b.backspaceCompare("ab##", "c#d#"));
        System.out.println(b.backspaceCompare("a#c", "b"));
        System.out.println(b.backspaceCompare("a##c", "#a#c"));
        System.out.println(b.backspaceCompare("bxj##tw", "bxj###tw"));
    }
}
