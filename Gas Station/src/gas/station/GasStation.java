/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gas.station;

/**
 *
 * @author wimukthirajapaksha
 */
public class GasStation {

    /**
     * @param args the command line arguments
     */
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int s=0;
        for(int i=0; i<gas.length; i++) {
            s+=gas[i]-cost[i];
        }
        if(s<0) {
            return -1;
        }
        int i=0;
        int t=0;
        int j=0;
        while(j<gas.length) {
            t+=gas[j]-cost[j];
            if(t<0) {
                j++;
                t=0;
                i=j;
                continue;
            }
            j++;
        }
        return i;
    }
    
//    --------------------------ALTERNATE -> OPTIMAL---------------------
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int i=0;
//        int s=0;
//        int t=0;
//        int j=0;
//        while(j<gas.length) {
//            s+=gas[j]-cost[j];
//            t+=gas[j]-cost[j];
//            if(t<0) {
//                j++;
//                t=0;
//                i=j;
//                continue;
//            }
//            j++;
//        }
//        return s<0 ? -1 : i;
//    }
    
    public static void main(String[] args) {
        GasStation g=new GasStation();
        System.out.println(g.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(g.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
        System.out.println(g.canCompleteCircuit(new int[]{5,5,1,3,4}, new int[]{8,1,7,1,1}));
    }
}
