/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.the.highest.altitude;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindTheHighestAltitude {

    /**
     * @param args the command line arguments
     */
    
    public int largestAltitude(int[] gain) {
        int m=0;
        int t=0;
        for (int i: gain) {
            t+=i;
            if(m<t) m=t;
        }
        System.out.println(m);
        return m;
    }
    
    public static void main(String[] args) {
        FindTheHighestAltitude f=new FindTheHighestAltitude();
        f.largestAltitude(new int[]{-5,1,5,0,-7});
    }
}
