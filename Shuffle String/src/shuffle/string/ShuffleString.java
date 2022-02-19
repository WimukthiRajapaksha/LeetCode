/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shuffle.string;

/**
 *
 * @author wimukthirajapaksha
 */
public class ShuffleString {

    /**
     * @param args the command line arguments
     */

    public String restoreString(String s, int[] indices) {
        char[] c=new char[s.length()];
        for (int i: indices) {
            c[indices[i]]=s.charAt(i);
        }
        System.out.println(String.valueOf(c));
        return String.valueOf(c);
    }
    
    public static void main(String[] args) {
        ShuffleString s=new ShuffleString();
        s.restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3});
    }
}
