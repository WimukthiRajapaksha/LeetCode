/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert.a.number.to.hexadecimal;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class ConvertANumberToHexadecimal {

    /**
     * @param args the command line arguments
     */
    
    public String toHex(int num) {
        if(num==0) return "0";
        return this.posi(num);
    }
    
    private String posi(int num) {
        StringBuffer sb=new StringBuffer();
        while(num!=0) {
            int v=(num&15);
            sb.append((v>9) ? (char)((v-10)+'a') : (char)(v+'0'));
            num=num>>>4;
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        ConvertANumberToHexadecimal c=new ConvertANumberToHexadecimal();
        System.out.println(c.toHex(26));
        System.out.println(c.toHex(-1));
        System.out.println(c.toHex(-2147483648));
    }
}
