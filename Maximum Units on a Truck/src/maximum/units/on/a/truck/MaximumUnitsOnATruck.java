/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.units.on.a.truck;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumUnitsOnATruck {

    /**
     * @param args the command line arguments
     */
    
//    ------------------OPTIMAL -> TIME -> O(NlogN), SPACE -> O(N)--------------
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] unitCount=new int[1001];
        for(int[] i: boxTypes) {
            unitCount[i[1]]+=i[0];
        }
        int s=0;
        for(int i=1000; i>=0; i--) {
            if(unitCount[i]>0) {
                if(truckSize>=unitCount[i]) {
                    s+=unitCount[i]*i;
                } else {
                    s+=truckSize*i;
                    return s;
                }
                truckSize-=unitCount[i];
            }
        }
        return s;
    }
    
    
//    -----------------ALTERNATES -> TIME -> O(NlogN), SPACE -> O(N)------------
//    public int maximumUnits(int[][] boxTypes, int truckSize) {
//        Arrays.sort(boxTypes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return Integer.compare(o2[1], o1[1]);
//            }
//        });
//        int s=0;
//        int p=0;
//        while(truckSize>0) {
//            s+=boxTypes[p][1];
//            truckSize--;
//            if(boxTypes[p][0]==1) {
//                p++;
//            } else {
//                boxTypes[p][0]--;
//            }
//        }
//        return s;
//    }
    
    
//    public int maximumUnits(int[][] boxTypes, int truckSize) {
//        Arrays.sort(boxTypes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return Integer.compare(o2[1], o1[1]);
//            }
//        });
//        int s=0;
//        for(int i=0; i<boxTypes.length && truckSize>0; i++) {
//            s+=(truckSize>=boxTypes[i][0]) ? boxTypes[i][0]*boxTypes[i][1] : truckSize*boxTypes[i][1];
//            truckSize-=boxTypes[i][0];
//        }
//        return s;
//    }
    
    
//    public int maximumUnits(int[][] boxTypes, int truckSize) {
//        Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o2[1], o1[1]));
//        int s=0;
//        for(int i=0; i<boxTypes.length && truckSize>0; i++) {
//            s+=(truckSize>=boxTypes[i][0]) ? boxTypes[i][0]*boxTypes[i][1] : truckSize*boxTypes[i][1];
//            truckSize-=boxTypes[i][0];
//        }
//        return s;
//    }
    
    public static void main(String[] args) {
        MaximumUnitsOnATruck m=new MaximumUnitsOnATruck();
        System.out.println(m.maximumUnits(new int[][]{{1,3}, {2,2}, {3,1}}, 4));
        System.out.println(m.maximumUnits(new int[][]{{5,10}, {2,5}, {4,7}, {3,9}}, 10));
    }
}
