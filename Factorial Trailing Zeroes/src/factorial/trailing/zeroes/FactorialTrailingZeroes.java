/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial.trailing.zeroes;

/**
 *
 * @author wimukthirajapaksha
 */
public class FactorialTrailingZeroes {

    /**
     * @param args the command line arguments
     */
    
//    ------------------ALTERNATE -> OPTIMAL-----------------
    public int trailingZeroes(int n) {
        return (n==0) ? 0 : n/5+trailingZeroes(n/5);
    }
    
    
//    ------------------ALTERNATE -> OPTIMAL-----------------
//    public int trailingZeroes(int n) {
//        int ret=0;
//        while(n>=5) {
//            ret+=n/5;
//            n/=5;
//        }
//        return ret;
//    }
    
    
//    ------------------ALTERNATE -> OPTIMAL-----------------
//    public int trailingZeroes(int n) {
//        int ret=0;
//        int p=5;
//        while(n/p!=0) {
//            ret+=(n/p);
//            p=p*5;
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        FactorialTrailingZeroes f=new FactorialTrailingZeroes();
        System.out.println(f.trailingZeroes(1000000000));
    }
}
