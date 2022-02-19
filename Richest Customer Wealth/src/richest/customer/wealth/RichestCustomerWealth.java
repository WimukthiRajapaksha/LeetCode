/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richest.customer.wealth;

/**
 *
 * @author wimukthirajapaksha
 */
public class RichestCustomerWealth {

    /**
     * @param args the command line arguments
     */
    
    public int maximumWealth(int[][] accounts) {
        int max=0;
        for (int[] i: accounts) {
            int co=i[0];
            for (int j=1; j<i.length; j++) {
                co+=i[j];
            }
            if (max<co) {
                max=co;
            }
        }
        System.out.println(max);
        return max;
    }
    
    public static void main(String[] args) {
        RichestCustomerWealth r=new RichestCustomerWealth();
        r.maximumWealth(new int[][]{{2,8,7},{7,1,3},{1,9,5}});
    }    
}
