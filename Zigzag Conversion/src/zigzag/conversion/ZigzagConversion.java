/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zigzag.conversion;

/**
 *
 * @author wimukthirajapaksha
 */
public class ZigzagConversion {

    /**
     * @param args the command line arguments
     */
    
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder sb=new StringBuilder();
        int k=2*(numRows-1);
        for(int i=0; i<numRows; i++) {
           for(int j=i; j<s.length(); j+=k) {
               sb.append(s.charAt(j));
               if(i>0 && i<numRows-1 && j+k-(2*i)<s.length()) {
                   sb.append(s.charAt(j+k-(2*i)));
               }
           }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        ZigzagConversion z=new ZigzagConversion();
        System.out.println(z.convert("PAYPALISHIRING", 3));
        System.out.println("PAHNAPLSIIGYIR");
    }
    
}
