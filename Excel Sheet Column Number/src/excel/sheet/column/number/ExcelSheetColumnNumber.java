/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel.sheet.column.number;

/**
 *
 * @author wimukthirajapaksha
 */
public class ExcelSheetColumnNumber {

    /**
     * @param args the command line arguments
     */
    
    public int titleToNumber(String columnTitle) {
        int v=0;
        for(int i=0; i<columnTitle.length(); i++) {
            v=(v*26)+(columnTitle.charAt(i)+1-'A');
        }
        System.out.println(v);
        return v;
    }
    
//    --------------------------FROM END TO START-----------------------------------
//    public int titleToNumber(String columnTitle) {
//        int v=0;
//        int l=columnTitle.length();
//        int t=1;
//        for (int i=l-1; i>=0; i--) {
//            v+=t*(columnTitle.charAt(i)-'A'+1);
//            t*=26;
//        }
//        System.out.println(v);
//        return v;
//    }
    
    public static void main(String[] args) {
        ExcelSheetColumnNumber e=new ExcelSheetColumnNumber();
//        e.titleToNumber("A");
//        e.titleToNumber("AB");
//        e.titleToNumber("ZY");
        e.titleToNumber("FXSHRXW");
        e.titleToNumber("AAA");
        System.out.println(2^3);
    }
}
