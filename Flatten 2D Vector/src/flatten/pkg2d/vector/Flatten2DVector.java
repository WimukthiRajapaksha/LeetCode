/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flatten.pkg2d.vector;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */

class Vector2D implements Iterator<Integer> {
    int currListIndex;
    int currItemIndex;
    List<List<Integer>> list;
    
    public Vector2D(List<List<Integer>> vec2d) {
        currListIndex=0;
        currItemIndex=0;
        list=vec2d;
    }

    @Override
    public Integer next() {
        if(!hasNext()) return null;
        return list.get(currListIndex).get(currItemIndex++);
    }

    @Override
    public boolean hasNext() {
        while(currListIndex<list.size() && currItemIndex==list.get(currListIndex).size()) {
            currListIndex++;
            currItemIndex=0;
        }
        return currListIndex<list.size();
    }

    @Override
    public void remove() {}
}

public class Flatten2DVector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        List<Integer> l1=Arrays.asList();
        List<Integer> l2=Arrays.asList(4,5,6);
        List<Integer> l3=Arrays.asList();
        List<List<Integer>> list=Arrays.asList(l2,l2,l3);
        Vector2D v=new Vector2D(list);
        while(v.hasNext()) {
            System.out.print(v.next()+" ");
        }
        
        
    }
}
