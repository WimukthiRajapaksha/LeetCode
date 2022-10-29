/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.the.celebrity;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindTheCelebrity {

    /**
     * @param args the command line arguments
     */
    
    private boolean knows(int a, int b){
        return a%2==0;
    }
    
    public int findCelebrity(int n) {
        int celeb=0;
        for(int i=1; i<n; i++) {
            if(knows(celeb, i)) {
                celeb=i;
            }
        }
        for(int i=0; i<n; i++) {
            if(i==celeb) continue;
            if(knows(celeb, i) || !knows(i, celeb)) return -1;
        }
        return celeb;
    }
    
    public static void main(String[] args) {
    }
}
