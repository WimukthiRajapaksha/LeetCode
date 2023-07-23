/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiply.strings;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MultiplyStrings {

    /**
     * @param args the command line arguments
     */
    
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        int[] arr=new int[m+n];
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p=i+j;
                int q=i+j+1;
                int sum=mul+arr[q];
                arr[p]+=sum/10;
                arr[q]=sum%10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i: arr) {
            if(sb.length()!=0 || i!=0) {
                sb.append(i);
            }
        }
        return sb.length()==0 ? "0" : sb.toString();
    }
    
    public static void main(String[] args) {
        MultiplyStrings m=new MultiplyStrings();
        System.out.println(m.multiply("123", "456"));
    }
}
