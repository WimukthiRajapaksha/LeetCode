/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.smallest.letter.greater.than.target;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindSmallestLetterGreaterThanTarget {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------------OPTIMAL -> O(N), O(1)-------------------------
//    public char nextGreatestLetter(char[] letters, char target) {
//        for(char c: letters) {
//            if(c>target) {
//                return c;
//            }
//        }
//        return letters[0];
//    }
    
    
//    --------------------OPTIMAL -> O(LOG N), O(1)-------------------------
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0;
        int r=letters.length-1;
        while(l<=r) {
            int m=l+(r-l)/2;
            if(letters[m]<=target) {
                l=m+1;
            } else {
                r=m-1;
            }
        }
        return l==letters.length ? letters[0] : letters[l];
    }
    
    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget f=new FindSmallestLetterGreaterThanTarget();
        System.out.println(f.nextGreatestLetter(new char[]{'c','f','j'}, 'a'));
        System.out.println(f.nextGreatestLetter(new char[]{'c','f','j'}, 'c'));
        System.out.println(f.nextGreatestLetter(new char[]{'x','x','y','y'}, 'z'));
    }
}
