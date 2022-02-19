/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first.bad.version;

/**
 *
 * @author wimukthirajapaksha
 */
public class FirstBadVersion {

    /**
     * @param args the command line arguments
     */
    
    private boolean isBadVersion(int i) {
        return false;
    }
    
    
//    ------------------------RECURSIVE-----------------------------
//    public int firstBadVersion(int n) {
//        return bst(1, n);
//    }
//    
//    public int bst(int i, int j) {
//        int m=i+(j-i)/2;
//        if(i>j) return i;
//        if(isBadVersion(m)) return bst(i, m-1);
//        else return bst(m+1, j);
//    }
    
    
//    -------------------------ITERATIVE----------------------------
    public int firstBadVersion(int n) {
        int i=1;
        int j=n;
        int m;
        while(i<j) {
            m=i+(j-i)/2;
            if(isBadVersion(m)) j=m-1;
            else i=m+1;
        }
        return i;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
