/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess.number.higher.or.lower;

/**
 *
 * @author wimukthirajapaksha
 */
public class GuessNumberHigherOrLower {

    /**
     * @param args the command line arguments
     */
    
    private int guess(int num) {
        return 0;
    }
    
    public int guessNumber(int n) {
        int i=1;
        int j=n;
        int m=i+(j-i)/2;
        while(i<=j) {
            switch (this.guess(m)) {
                case 1:
                    j=m-1;
                    break;
                case -1:
                    i=m+1;
                    break;
                default:
                    return m;
                    
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
