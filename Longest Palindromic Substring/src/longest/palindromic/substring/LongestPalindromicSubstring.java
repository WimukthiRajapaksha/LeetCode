/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.palindromic.substring;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestPalindromicSubstring {

    /**
     * @param args the command line arguments
     */
    
//    ----------------OPTIMAL -> Manacher algorithm -> NOT WORKING YET -> LEARN LATER--------------
//    public String longestPalindrome(String s) {
//        char[] arr=new char[s.length()*2+1];
//        int ind=0;
//        for(char c: s.toCharArray()) {
//            arr[ind++]='$';
//            arr[ind++]=c;
//        }
//        arr[ind]='$';
//        for(char c: arr) {
//            System.out.print(c+" ");
//        }
//        System.out.println();
//        
//        
//        int[] co=new int[arr.length];
//        int start=0;
//        int end=0;
//        for(int i=0; i<arr.length;) {
//            while(start>0 && end<arr.length-1 && arr[start-1]==arr[end+1]) {
//                start--;
//                end++;
//            }
//            co[i]=end-start+1;
//            if(end==arr.length-1) {
//                break;
//            }
//            int newCen=end+(i%2==0 ? 1:0);
//            for(int j=i+1; j<=end; j++) {
//                co[j]=Math.min(co[i-(j-i)], 2*(end-j)+1);
//                if(j+co[i-(j-i)]/2==end) {
//                    newCen=j;
//                    break;
//                }
//            }
//            i=newCen;
//            end=i+co[i]/2;
//            start=i-co[i]/2;
//        }
//        int max=0;
//        int posi=0;
//        for(int i=0; i<co.length; i++) {
//            System.out.print(co[i]+" ");
//            if(max<co[i]) {
//                max=co[i];
//                posi=i;
//            }
//        }
//        System.out.println();
//        return s.substring(posi-max/2, posi+1+max/2).replace("$", "");
//    }
    
    
    public String longestPalindrome(String s) {
        int b=0;
        int e=0;
        for(int i=0; i<s.length(); i++) {
            int p=che(s, i, i);
            int q=che(s, i, i+1);
            int t=Math.max(p, q);
            if(e-b+1<t) {
                e=i+(t/2);
                b=i-((t-1)/2);
            }
        }
        return s.substring(b, e+1);
    }
    
    public int che(String s, int b, int e) {
        while(b>=0 && e<s.length() && s.charAt(b)==s.charAt(e)) {
            b--;
            e++;
        }
        return e-b-1;
    }
    
    
    
//    public String longestPalindrome(String s) {
//        int st=0;
//        int en=0;
//        for(int i=0; i<s.length(); i++) {
//            int p = che(s, i, i+1);
//            int q = che(s, i, i);
//            if(Math.max(p, q)>en-st) {
//                int l=Math.max(p, q);
//                st=i-((l-1)/2);
//                en=i+(l/2);
//            }
//        }
//        return s.substring(st, en+1);
//    }
//    
//    private int che(String s, int l, int r) {
//        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
//            l--;
//            r++;
//        }
//        return r-l-1;
//    }
    
    public static void main(String[] args) {
        LongestPalindromicSubstring l=new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("babab"));
        System.out.println(l.longestPalindrome("cbbd"));
        System.out.println(l.longestPalindrome("aa"));
    }
}
