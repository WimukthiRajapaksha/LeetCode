/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add.digits;

/**
 *
 * @author wimukthirajapaksha
 */
public class AddDigits {

    /**
     * @param args the command line arguments
     */
    
    public int addDigits(int num) {
        if(num==0) return 0;
        int v=num%9;
        return (v==0) ? 9 : v;
    }
    
    public static void main(String[] args) {
        AddDigits a=new AddDigits();
        System.out.println(a.addDigits(38));
    }
}
