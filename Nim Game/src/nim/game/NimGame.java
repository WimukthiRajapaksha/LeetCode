/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nim.game;

/**
 *
 * @author wimukthirajapaksha
 */
public class NimGame {

    /**
     * @param args the command line arguments
     */
    
    public boolean canWinNim(int n) {
        return n%4!=0;
    }
    
    public static void main(String[] args) {
        NimGame n=new NimGame();
    }
}
