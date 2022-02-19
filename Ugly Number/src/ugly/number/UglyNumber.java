/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugly.number;

/**
 *
 * @author wimukthirajapaksha
 */
public class UglyNumber {

    /**
     * @param args the command line arguments
     */
    
//    public boolean isUgly(int n) {
//        if(n==0) return false;
//        if(n==1) return true;
//        if(n%2==0) return isUgly(n/2);
//        else if(n%3==0) return isUgly(n/3);
//        else if (n%5==0) return isUgly(n/5);
//        return false;
//    }
    
    
    public boolean isUgly(int n) {
        if(n==0) return false;
        while(n%2==0 || n%3==0 || n%5==0) {
            if(n%2==0) {
                n=n/2;
            } else if (n%3==0) {
                n=n/3;
            } else if (n%5==0) {
                n=n/5;
            }
        }
        return n==1;
    }
    
    public static void main(String[] args) {
        UglyNumber u=new UglyNumber();
        System.out.println(u.isUgly(1));
    }
}
