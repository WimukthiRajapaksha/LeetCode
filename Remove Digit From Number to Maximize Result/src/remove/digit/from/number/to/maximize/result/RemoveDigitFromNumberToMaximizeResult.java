/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remove.digit.from.number.to.maximize.result;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemoveDigitFromNumberToMaximizeResult {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------------OPTIMAL -> O(N), O(1)----------------------
    public String removeDigit(String number, char digit) {
        return remove(" "+number+" ", digit, 0).substring(1, number.length());
    }
    
    private String remove(String s, char c, int index) {
        for(int i=index; i<s.length(); i++) {
            if(s.charAt(i)==c) {
                String temp=s.substring(0, i)+s.substring(i+1, s.length());
                String next=remove(s, c, i+1);
                if(temp.compareTo(next)<=0 && next.length()==s.length()-1) {
                    return next;
                }
                return temp;
            }
        }
        return s;
    }
    
    
    
//    ------------------OPTIMAL -> O(N), O(1)----------------------
//    public String removeDigit(String number, char digit) {
//        for(int i=0; i<number.length()-1; i++) {
//            if(number.charAt(i)==digit && number.charAt(i+1)>digit) {
//                return number.substring(0, i)+number.substring(i+1, number.length());
//            }
//        }
//        for(int i=number.length()-1; i>=0; i--) {
//            if(number.charAt(i)==digit) {
//                return number.substring(0, i)+number.substring(i+1, number.length());
//            }
//        }
//        return "";
//    }
    
    
    public static void main(String[] args) {
        RemoveDigitFromNumberToMaximizeResult r=new RemoveDigitFromNumberToMaximizeResult();
        System.out.println(r.removeDigit("123", '3'));
        System.out.println(r.removeDigit("1231", '1'));
        System.out.println(r.removeDigit("551", '5'));
        System.out.println(r.removeDigit("9876810", '8'));
        System.out.println(r.removeDigit("12345489", '4'));
        System.out.println(r.removeDigit("133235", '3'));
    }
}
