/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiral.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class SpiralMatrix {

    /**
     * @param args the command line arguments
     */
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret=new ArrayList<>();
        int[] i= new int[]{0,0};
        int[] j= new int[]{0, matrix[0].length-1};
        int[] k= new int[]{matrix.length-1, matrix[matrix.length-1].length-1};
        int[] l= new int[]{matrix.length-1, 0};
        
        while(true) {
            if(i[0]>l[0] || i[1]>j[1]) {
                break;
            }
            for(int a=i[1]; a<j[1]; a++) {
                ret.add(matrix[i[0]][a]);
            }
            for(int a=j[0]; a<k[0]; a++) {
                ret.add(matrix[a][j[1]]);
            }
            for(int a=k[1]; a>l[1]; a--) {
                ret.add(matrix[k[0]][a]);
            }
            for(int a=l[0]; a>i[0]; a--) {
                ret.add(matrix[a][i[1]]);
            }
            i[0]++;
            i[1]++;
            j[0]++;
            j[1]--;
            k[0]--;
            k[1]--;
            l[0]--;
            l[1]++;
            System.out.println(i[0]+" "+i[1]+" - "+j[0]+" "+j[1]+" - "+k[0]+" "+k[1]+" - "+l[0]+" "+l[1]);
            System.out.println(ret);
        }
        System.out.println(ret);
        return ret;
    }
    
    public static void main(String[] args) {
        SpiralMatrix s=new SpiralMatrix();
//        s.spiralOrder(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}});
        s.spiralOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
    }
}
