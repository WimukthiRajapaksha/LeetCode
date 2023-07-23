/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delete.columns.to.make.sorted;

/**
 *
 * @author wimukthirajapaksha
 */
public class DeleteColumnsToMakeSorted {

    /**
     * @param args the command line arguments
     */
    
//    -----------------------OPTIMAL -> O(NK), O(1)--------------
    public int minDeletionSize(String[] strs) {
        int c=0;
        for(int i=0; i<strs[0].length(); i++) {
            for(int j=1; j<strs.length; j++) {
                if(strs[j-1].charAt(i)>strs[j].charAt(i)) {
                    c++;
                    break;
                }
            }
        }
        return c;
    }
    
    public static void main(String[] args) {
        DeleteColumnsToMakeSorted d=new DeleteColumnsToMakeSorted();
        System.out.println(d.minDeletionSize(new String[]{"cba","daf","ghi"}));
        System.out.println(d.minDeletionSize(new String[]{"a","b"}));
        System.out.println(d.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
    }
}
