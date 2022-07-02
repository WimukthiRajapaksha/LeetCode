/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraction.to.recurring.decimal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class FractionToRecurringDecimal {

    /**
     * @param args the command line arguments
     */
    
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        long n=Math.abs((long)numerator);
        long d=Math.abs((long)denominator);
        StringBuilder sb=new StringBuilder();
        if(numerator<0 ^ denominator<0) {
            sb.append('-');
        }
        sb.append(n/d);
        long rem=n%d;
        if(rem==0) {
            System.out.println(sb.toString());
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map=new HashMap<>();
        while(rem!=0) {
            if(map.containsKey(rem)) {
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());
            rem=rem*10;
            sb.append(rem/d);
            rem=rem%d;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    
    
//    -----------------ALTERNATE -> OPTIMAL------------------
//    public String fractionToDecimal(int numerator, int denominator) {
//        if(numerator==0) return "0";
//        long n=Math.abs((long)numerator);
//        long d=Math.abs((long)denominator);
//        StringBuilder sb=new StringBuilder();
//        if(numerator<0 ^ denominator<0) {
//            sb.append('-');
//        }
//        sb.append(n/d);
//        if(n%d==0) {
//            System.out.println(sb.toString());
//            return sb.toString();
//        }
//        
//        sb.append(".");
//        fra((Math.abs(n%d))*10, Math.abs((long)d), new HashMap<>(), sb);
//        System.out.println(sb.toString());
//        return sb.toString();
//    }
//    
//    private void fra(long n, long d, Map<Long, Integer> map, StringBuilder sb) {
//        if(n==0) return;
//        if(map.containsKey(n)) {
//            int i=map.get(n);
//            sb.insert(i, '(');
//            sb.append(')');
//            return;
//        }
//        sb.append((int)(n/d));
//        map.put(n, sb.length()-1);
//        fra((n%d)*10, d, map, sb);
//    }
    
    public static void main(String[] args) {
        FractionToRecurringDecimal f=new FractionToRecurringDecimal();
        f.fractionToDecimal(4, 333);
        f.fractionToDecimal(1, 2);
        f.fractionToDecimal(2, 1);
        f.fractionToDecimal(670, 333);
        f.fractionToDecimal(1, 333);
        f.fractionToDecimal(-50, 8);
        f.fractionToDecimal(7, -12);
        f.fractionToDecimal(0, -5);
        f.fractionToDecimal(-22, -2);
        f.fractionToDecimal(1, 214748364);
        f.fractionToDecimal(-1, -2147483648);
        f.fractionToDecimal(-2147483648, -1);
    }
}
