/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ransom.note;

/**
 *
 * @author wimukthirajapaksha
 */
public class RansomNote {

    /**
     * @param args the command line arguments
     */
    
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        int[] l=new int[26];
        for(int i=0; i<ransomNote.length(); i++) {
            int prev=l[ransomNote.charAt(i)-'a'];
            int inde=magazine.indexOf(ransomNote.charAt(i), prev);
            if(inde==-1) {
                return false;
            } else {
                l[ransomNote.charAt(i)-'a']=inde+1;
            }
        }
        return true;
    }
    
    
//    ----------------------ALTERNATE -> NOT OPTIMAL -> BUT FINE----------------------
//    public boolean canConstruct(String ransomNote, String magazine) {
//        if(ransomNote.length()>magazine.length()) return false;
//        int[] l=new int[26];
//        for(int i=0; i<magazine.length(); i++) {
//            l[magazine.charAt(i)-'a']++;
//        }
//        for(int i=0; i<ransomNote.length(); i++) {
//            if(--l[ransomNote.charAt(i)-'a']<0) {
//                return false;
//            }
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        RansomNote r=new RansomNote();
        System.out.println(r.canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }
}
