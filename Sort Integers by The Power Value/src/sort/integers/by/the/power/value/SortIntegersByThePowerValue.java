/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort.integers.by.the.power.value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class SortIntegersByThePowerValue {

    /**
     * @param args the command line arguments
     */
    
    public int getKth(int lo, int hi, int k) {
        List<int[]> arr=new ArrayList<>();
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=lo; i<=hi; i++) {
            arr.add(new int[]{help(map, i), i});
        }
        for(int[] i: arr) {
            System.out.println(Arrays.toString(i));
        }
        Collections.sort(arr, (o1,o2)->Integer.compare(o1[0], o2[0]));
        return arr.get(k-1)[1];
    }
    
    private int help(Map<Integer, Integer> map, int i) {
        if(i==1) return 1;
        if(map.containsKey(i)) return map.get(i);
        if(i%2==0) {
            int val=help(map, i/2)+1;
            map.put(i, val);
            return val;
        } else {
            int val=help(map, 3*i+1)+1;
            map.put(i, val);
            return val;
        }
    }
    
    public static void main(String[] args) {
        SortIntegersByThePowerValue s=new SortIntegersByThePowerValue();
        System.out.println(s.getKth(12, 15, 2));
        System.out.println(s.getKth(7, 11, 4));
    }
}
