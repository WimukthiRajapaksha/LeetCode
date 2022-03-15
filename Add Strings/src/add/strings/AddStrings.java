/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add.strings;

/**
 *
 * @author wimukthirajapaksha
 */
public class AddStrings {

    /**
     * @param args the command line arguments
     */
    
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int c=0;
        
        StringBuilder sb=new StringBuilder();
        while(i>=0 || j>=0 || c>0) {
            c+=(i>=0) ? num1.charAt(i--)-'0' : 0;
            c+=(j>=0) ? num2.charAt(j--)-'0' : 0;
            sb.append(c%10);
            c/=10;
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        AddStrings a=new AddStrings();
        System.out.println(a.addStrings("456", "77"));
        System.out.println(a.addStrings("0", "0"));
        System.out.println(a.addStrings("11", "123"));
    }
}
