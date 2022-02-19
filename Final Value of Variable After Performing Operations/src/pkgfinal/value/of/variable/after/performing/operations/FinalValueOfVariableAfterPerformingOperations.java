/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.value.of.variable.after.performing.operations;

/**
 *
 * @author wimukthirajapaksha
 */
public class FinalValueOfVariableAfterPerformingOperations {

    /**
     * @param args the command line arguments
     */
    
    public int finalValueAfterOperations(String[] operations) {
        int i=0;
        for (String s: operations) {
            if(s.charAt(1)=='-') {
                i--;
            } else {
                i++;
            }
        }
        System.out.println(i);
        return i;
    }
    
    public static void main(String[] args) {
        FinalValueOfVariableAfterPerformingOperations f=new FinalValueOfVariableAfterPerformingOperations();
        f.finalValueAfterOperations(new String[]{"X++","++X","++X","X--"});
    }
}
