/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bulb.switcher;

/**
 *
 * @author wimukthirajapaksha
 */
public class BulbSwitcher {

    /**
     * @param args the command line arguments
     */
    
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
    
    
//    public int bulbSwitch(int n) {
//        int i=1;
//        int t=1;
//        int c=1;
//        while(t+(2*i)+1<n) {
//            c++;
//            t=t+(2*i)+1;
//            i++;
//        }
//        return c;
//    }
    
    public static void main(String[] args) {
        BulbSwitcher b=new BulbSwitcher();
        System.out.println(b.bulbSwitch(3));
        System.out.println(b.bulbSwitch(10));
        System.out.println(b.bulbSwitch(13));
        System.out.println(b.bulbSwitch(5));
        System.out.println(b.bulbSwitch(18));
    }
}
