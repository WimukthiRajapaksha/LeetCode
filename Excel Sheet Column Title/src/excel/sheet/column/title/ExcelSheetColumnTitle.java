/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel.sheet.column.title;

/**
 *
 * @author wimukthirajapaksha
 */
public class ExcelSheetColumnTitle {

    /**
     * @param args the command line arguments
     */
    
//    ---------------------------------ALTERNATE----------------------------------
//    public String convertToTitle(int n) {
//        String s="";
//        while(n>0) {
//            n--;
//            s=(char)((n%26)+'A')+s;
//            n=n/26;
//        }
//        return s;
//    }
    
    
//    ---------------------ALTERNATE -> RECURSIVE -> NOT OPTIMAL-----------------------------
//    public String convertToTitle(int columnNumber) {
//        if (columnNumber==0) {
//            return "";
//        }
//        columnNumber--;
//        return convertToTitle(columnNumber/26)+ (char)('A' + (columnNumber % 26));
//    }
    
//    ---------------------ITERATIVE-----------------------------
    public String convertToTitle(int columnNumber) {
        StringBuffer s=new StringBuffer();
        while(columnNumber>0) {
            columnNumber--;
            s.insert(0, (char)(columnNumber%26+'A'));
            columnNumber=(columnNumber)/26;
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
        ExcelSheetColumnTitle e=new ExcelSheetColumnTitle();
        System.out.println(e.convertToTitle(1));
        System.out.println(e.convertToTitle(701));
        System.out.println(e.convertToTitle(27));
        System.out.println(701+" "+(701/26)+" "+(701%26));
//        System.out.println(52/26);
//        System.out.println(52%26);
    }
}
