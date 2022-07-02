/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse.words.in.a.string;

/**
 *
 * @author wimukthirajapaksha
 */
public class ReverseWordsInAString {

    /**
     * @param args the command line arguments
     */
    
//    -------------------ALTERNATE -> OPTIMAL -> SPACE O(N)---------------
//    public String reverseWords(String s) {
//        char[] arr=s.toCharArray();
//        reverse(arr, 0, arr.length-1);
//        reverseWords(arr, arr.length);
//        return cleanSpaces(arr, arr.length);
//    }
//    
//    private String cleanSpaces(char[] arr, int n) {
//        int i=0;
//        int j=0;
//        while(j<n && arr[j]==' ') j++;
//        while(j<n) {
//            while(j<n && arr[j]!=' ') arr[i++]=arr[j++];
//            while(j<n && arr[j]==' ') j++;
//            if(j<n) arr[i++]=' ';
//        }
//        return new String(arr, 0, i);
//    }
//    
//    private void reverseWords(char[] arr, int n) {
//        int i=0;
//        int j=0;
//        while(i<n) {
//            while(i<j || (i<n && arr[i]==' ')) i++;
//            while(j<i || (j<n && arr[j]!=' ')) j++;
//            reverse(arr, i, j-1);
//        }
//    }
//    
//    private void reverse(char[] arr, int i, int j) {
//        while(i<j) {
//            char t=arr[i];
//            arr[i++]=arr[j];
//            arr[j--]=t;
//        }
//    }
    
    
//    -------------------ALTERNATE -> OPTIMAL -> SPACE O(N)---------------
//    public String reverseWords(String s) {
//        char[] arr=s.toCharArray();
//        reverse(arr, 0, s.length()-1);
//        int i=0;
//        int place=0;
//        while(i<arr.length) {
//            if(arr[i]!=' ') {
//                if(place!=0) {
//                    arr[place++]=' ';
//                }
//                int j=i;
//                while(j<arr.length && arr[j]!=' ') {
//                    arr[place++]=arr[j++];
//                }
//                reverse(arr, place-(j-i), place-1);
//                i=j;
//            } else {
//                i++;
//            }
//        }
//        return new String(arr, 0, place);
//    }
//    
//    private void reverse(char[] arr, int i, int j) {
//        while(i<j) {
//            char t=arr[i];
//            arr[i++]=arr[j];
//            arr[j--]=t;
//        }
//    }
    
    
    
    
//    -------------------ALTERNATE -> OPTIMAL -> SPACE O(1)---------------
    public String reverseWords(String s) {
        int i=s.length()-1;
        while(s.charAt(i)==' ') {
            i--;
        }
        int k=0;
        while(s.charAt(k)==' ') {
            k++;
        }
        
        int j=i+1;
        StringBuffer sb=new StringBuffer();
        while(i>=k) {
            if(i==k) {
                sb.append(s.substring(i, j));
                j=i;
                i--;
            } else if(s.charAt(i)==' ') {
                sb.append(s.substring(i+1, j)).append(" ");
                while(i>=0 && s.charAt(i)==' ') {
                    i--;
                }
                j=i+1;
            } else {
                i--;
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        ReverseWordsInAString r=new ReverseWordsInAString();
        System.out.println(r.reverseWords("  hello world  "));
        System.out.println(r.reverseWords("the sky is blue"));
        System.out.println(r.reverseWords("a good   example"));
        System.out.println(r.reverseWords(" a "));
    }
}
