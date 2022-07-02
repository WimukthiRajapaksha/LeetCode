/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfect.number;

/**
 *
 * @author wimukthirajapaksha
 */
public class PerfectNumber {

    /**
     * @param args the command line arguments
     */
    
//    ----------------ALTERNATE -> BASED ON SOME THEORM--------------
//    public int pn(int p) {
//        return (1<<(p-1))*((1<<p)-1);
//    }
//    
//    public boolean checkPerfectNumber(int num) {
//        int[] pri=new int[]{2,3,5,7,13,17,19,31};
//        for(int i: pri) {
//            if(pn(i)==num) {
//                return true;
//            }
//        }
//        return false;
//    }
    
    
//    -----------------ALTERNATE -> OPTIMAL--------------------
    public boolean checkPerfectNumber(int num) {
        int s=0;
        for(int i=1; i*i<=num; i++) {
            if(num%i==0) {
                s+=i;
                if(i!=num/i) {
                    s+=(num/i);
                }
            }
        }
        return s-num==num;
    }
    
    
//    -----------------ALTERNATE -> NOT OPTIMAL--------------------
//    public boolean checkPerfectNumber(int num) {
//        int s=1;
//        int i=2;
//        int j=0;
//        while(i<=num/i) {
//            if(num%i!=0) {
//                while(num%i!=0) {
//                    i++;
//                }
//                continue;
//            }
//            j=num/i;
//            System.out.print(i+" "+j+" ->");
//            
//            if(i==j) {
//                s+=i;
//            } else {
//                s+=i+j;
//            }
//            i++;
//        }
//        System.out.println();
//        System.out.println(s);
//        return num==s;
//    }
    
    public static void main(String[] args) {
        PerfectNumber p=new PerfectNumber();
        System.out.println(p.checkPerfectNumber(28));
        System.out.println(p.checkPerfectNumber(7));
        System.out.println(p.checkPerfectNumber(1));
        System.out.println(p.checkPerfectNumber(2));
        System.out.println(p.checkPerfectNumber(130816));
    }
}
