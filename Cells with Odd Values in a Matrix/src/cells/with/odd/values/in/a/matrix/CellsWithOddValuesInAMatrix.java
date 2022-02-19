/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cells.with.odd.values.in.a.matrix;

import java.util.BitSet;

/**
 *
 * @author wimukthirajapaksha
 */
public class CellsWithOddValuesInAMatrix {

    /**
     * @param args the command line arguments
     */
    
//    ---------------ALTERNATE -> BITSET USED -> OPTIMAL--------------------
    public int oddCells(int m, int n, int[][] indices) {
        BitSet c=new BitSet(m);
        BitSet r=new BitSet(n);
        int cc=0;
        int rc=0;
        for (int[] i: indices) {
            c.flip(i[0]);
            r.flip(i[1]);
            cc+=(c.get(i[0])) ? 1:-1;
            rc+=(r.get(i[1])) ? 1:-1;
        }
        System.out.println((cc*(n-rc))+((m-cc)*rc));
        return (cc*(n-rc))+((m-cc)*rc);
    }
    
    
//    ---------------ALTERNATE -> BITSET USED -> OPTIMAL--------------------
//    public int oddCells(int m, int n, int[][] indices) {
//        BitSet c=new BitSet(m);
//        BitSet r=new BitSet(n);
//        int cc=0;
//        int rc=0;
//        for (int[] i: indices) {
//            c.flip(i[0]);
//            r.flip(i[1]);
//        }
//        cc=c.cardinality();
//        rc=r.cardinality();
//        System.out.println((cc*(n-rc))+((m-cc)*rc));
//        return (cc*(n-rc))+((m-cc)*rc);
//    }
    
    
//    ---------------ALTERNATE -> BITSET USED -> OPTIMAL--------------------
//    public int oddCells(int m, int n, int[][] indices) {
//        BitSet oddRows = new BitSet(n), oddCols = new BitSet(m);
//        System.out.println(oddRows);
//        System.out.println(oddCols);
//        int cntRow = 0, cntCol = 0;
//        for (int[] idx : indices) {
//            oddCols.flip(idx[0]);
//            oddRows.flip(idx[1]);
//            cntCol += oddCols.get(idx[0]) ? 1 : -1;
//            cntRow += oddRows.get(idx[1]) ? 1 : -1;
//            System.out.println(oddRows);
//            System.out.println(oddCols);
//        }
////        System.out.println(oddRows);
////        System.out.println(oddCols);
//        return (m - cntCol) * cntRow + (n - cntRow) * cntCol;
//    }
    
    
//    ---------------ALTERNATE -> BITWISE OPERATION, BOOLEAN XOR USED -> OPTIMAL--------------------
//    public int oddCells(int m, int n, int[][] indices) {
//        boolean[] c=new boolean[m];
//        boolean[] r=new boolean[n];
//        int oddC=0;
//        int oddR=0;
//        for (int[] i: indices) {
//            c[i[0]]^=true;
//            r[i[1]]^=true;
//            oddC+= c[i[0]] ? 1 : -1;
//            oddR+= r[i[1]] ? 1 : -1;
//        }
//        System.out.println((oddC*(n-oddR))+((m-oddC)*oddR));
//        return (oddC*(n-oddR))+((m-oddC)*oddR);
//    }
    

//    ---------------ALTERNATE -> BITWISE OPERATION, BOOLEAN XOR USED -> OPTIMAL--------------------
//    public int oddCells(int m, int n, int[][] indices) {
//        boolean[] c=new boolean[m];
//        boolean[] r=new boolean[n];
//        for (int[] i: indices) {
//            c[i[0]]^=true;
//            r[i[1]]^=true;
//        }
//        int oddC=0;
//        int oddR=0;
//        for (boolean i: c) {
//            if(i) oddC++;
//        }
//        for (boolean i: r) {
//            if(i) oddR++;
//        }
//        System.out.println((oddC*(n-oddR))+((m-oddC)*oddR));
//        return (oddC*(n-oddR))+((m-oddC)*oddR);
//    }
    
//    ---------------ALTERNATE -> BITWISE OPERATION, BOOLEAN XOR USED -> OPTIMAL--------------------
//    public int oddCells(int m, int n, int[][] indices) {
//        boolean[] c=new boolean[m];
//        boolean[] r=new boolean[n];
//        for (int[] i: indices) {
//            c[i[0]]^=true;
//            r[i[1]]^=true;
//        }
//        int co=0;
//        for(boolean i: c) {
//            for (boolean j: r) {
//                co+= (i^j) ? 1 : 0;
//            }
//        }
//        System.out.println(co);
//        return co;
//    }
    
    
//    ---------------ALTERNATE -> BITWISE OPERATION -> OPTIMAL--------------------
//    public int oddCells(int m, int n, int[][] indices) {
//        int[] c=new int[m];
//        int[] r=new int[n];
//        for (int[] i: indices) {
//            c[i[0]]^=1;
//            r[i[1]]^=1;
//        }
//        int co=0;
//        for(int i: c) {
//            for (int j: r) {
//                co+= ((i^j)==1) ? 1 : 0;
//            }
//        }
//        return co;
//    }
    
//    ---------------ALTERNATE -> BRUTE FORCE -> NOT OPTIMAL--------------------
//    public int oddCells(int m, int n, int[][] indices) {
//        int[][] a=new int[m][n];
//        for (int[] i: indices) {
//            int[] aa=a[i[0]];
//            for (int j=0; j<aa.length; j++) {
//                aa[j]^=1;
//            }
//            int ab=i[1];
//            for (int[] j: a) {
//                j[ab]^=1;
//            }
//        }
//        int o=0;
//        for (int[] i: a) {
//            for (int j: i) {
//                if (j%2==1) o++;
//            }
//        }
//        System.out.println(o);
//        return o;
//    }
    
    public static void main(String[] args) {
        CellsWithOddValuesInAMatrix c=new CellsWithOddValuesInAMatrix();
//        c.oddCells(2, 3, new int[][]{{0,1}, {0,1}, {0,1}, {0,1}});
        c.oddCells(2, 3, new int[][]{{0,1}, {1,1}});
    }
}
