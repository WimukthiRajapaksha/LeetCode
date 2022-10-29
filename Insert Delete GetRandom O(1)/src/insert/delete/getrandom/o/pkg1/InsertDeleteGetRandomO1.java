/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insert.delete.getrandom.o.pkg1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;
    
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int indexCurr=map.get(val);
        int last=list.get(list.size()-1);
        
        list.set(indexCurr, last);
        map.put(last, indexCurr);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

public class InsertDeleteGetRandomO1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RandomizedSet r=new RandomizedSet();
        r.insert(0);
        System.out.println(r.map+" "+r.list);
        r.remove(0);
        System.out.println(r.map+" "+r.list);
        r.insert(-1);
        System.out.println(r.map+" "+r.list);
        r.remove(0);
        System.out.println(r.map+" "+r.list);
//        r.remove(1);
//        System.out.println(r.map+" "+r.list);
    }
}
