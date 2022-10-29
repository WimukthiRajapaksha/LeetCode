/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bulls.and.cows;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class BullsAndCows {

    /**
     * @param args the command line arguments
     */
    
    public String getHint(String secret, String guess) {
        int bulls=0;
        int[] arr=new int[10];
        int cows=0;
        for(int i=0; i<secret.length(); i++) {
            char s=secret.charAt(i);
            char g=guess.charAt(i);
            if(s==g) {
                bulls++;
            } else {
                if(arr[s-'0']<0) {
                    cows++;
                }
                if(arr[g-'0']>0) {
                    cows++;
                }
                arr[s-'0']++;
                arr[g-'0']--;
            }
        }
        StringBuffer sb=new StringBuffer();
        sb.append(bulls).append("A").append(cows).append("B");
        return sb.toString();
    }
    
    
    
//    public String getHint(String secret, String guess) {
//        int match=0;
//        int[] arrF=new int[10];
//        int[] arrS=new int[10];
//        for(int i=0; i<secret.length(); i++) {
//            if(secret.charAt(i)==guess.charAt(i)) {
//                match++;
//            } else {
//                arrF[secret.charAt(i)-'0']++;
//                arrS[guess.charAt(i)-'0']++;
//            }
//        }
//        int places=0;
//        for(int i=0; i<arrF.length; i++) {
//            places+=Math.min(arrF[i], arrS[i]);
//        }
//        StringBuffer sb=new StringBuffer();
//        sb.append(match).append("A").append(places).append("B");
//        return sb.toString();
//    }
    
    public static void main(String[] args) {
        BullsAndCows b=new BullsAndCows();
        System.out.println(b.getHint("1807", "7810"));
        System.out.println(b.getHint("1123", "0111"));
        System.out.println(b.getHint("1111", "1111"));
    }
}
