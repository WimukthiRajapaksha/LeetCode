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
        int left=0;
        int right=matrix[0].length;
        int top=0;
        int bottom=matrix.length;
        
        while(left<right && top<bottom) {
            for(int i=left; i<right; i++) {
                ret.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<bottom; i++) {
                ret.add(matrix[i][right-1]);
            }
            right--;
            if(left>=right || top>=bottom) {
                return ret;
            }
            for(int i=right-1; i>=left; i--) {
                ret.add(matrix[bottom-1][i]);
            }
            bottom--;
            for(int i=bottom-1; i>=top; i--) {
                ret.add(matrix[i][left]);
            }
            left++;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        SpiralMatrix s=new SpiralMatrix();
        System.out.println(s.spiralOrder(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}}));
        System.out.println(s.spiralOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}));
    }
}
