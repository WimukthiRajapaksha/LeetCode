/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snapshot.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */

// ------------OPTIMAL -> O(N*LOG N), O(N)---------------
public class SnapshotArray {
    List<int[]>[] arr;
    int count;
    
    public SnapshotArray(int length) {
        arr=new ArrayList[length];
        for(int i=0; i<length; i++) {
            arr[i]=new ArrayList<>();
            arr[i].add(new int[]{0, 0});
        }
        count=0;
    }
    
    public void set(int index, int val) {
        if(arr[index].get(arr[index].size()-1)[0]==count) {
            arr[index].get(arr[index].size()-1)[1]=val;
        } else {
            arr[index].add(new int[]{count, val});
        }
    }
    
    public int snap() {
        return count++;
    }
    
    public int get(int index, int snap_id) {
        int l=0;
        int r=arr[index].size()-1;
        int val=0;
        if(arr[index].isEmpty()) return val;
        while(l<=r) {
            int m=l+(r-l+1)/2;
            if(arr[index].get(m)[0]==snap_id) return arr[index].get(m)[1];
            else if(arr[index].get(m)[0]>snap_id) {
                r=m-1;
            } else {
                val=arr[index].get(m)[1];
                l=m+1;
            }
        }
        return val;
    }
    
    public static void main(String[] args) {
        SnapshotArray s=new SnapshotArray(3);
        s.set(0, 5);
        System.out.println(s.snap());
        s.set(0, 6);
        System.out.println(s.get(0, 0));
        
        s=new SnapshotArray(1);
        s.set(0, 15);
        System.out.println(s.snap());
        System.out.println(s.snap());
        System.out.println(s.snap());
        s.set(0, 2);
        System.out.println(s.snap());
        System.out.println(s.snap());
        System.out.println(s.get(0, 0));
        
        s=new SnapshotArray(4);
        System.out.println(s.snap());
        System.out.println(s.snap());
        System.out.println(s.get(3, 1));
        s.set(2, 4);
        System.out.println(s.snap());
        s.set(1, 4);
        
        
    }
}
