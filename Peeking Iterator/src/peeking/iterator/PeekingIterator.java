/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peeking.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */

class PeekingIteratorr implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer peekElement;
    boolean hasPeek;
    public PeekingIteratorr(Iterator<Integer> iterator) {
        it=iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!hasPeek) {
            this.hasPeek = true;
            this.peekElement = it.next();
        }
        return this.peekElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(!this.hasPeek) {
            return this.it.next();
        }
        this.hasPeek=false;
        Integer pe=this.peekElement;
        this.peekElement=null;
        return pe;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext() || this.hasPeek;
    }
}

public class PeekingIterator {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        Iterator<Integer> it=list.iterator();
        PeekingIteratorr p=new PeekingIteratorr(it);
        System.out.println(p.hasNext());
        System.out.println(p.peek());
        System.out.println(p.peek());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.peek());
        System.out.println(p.peek());
        System.out.println(p.next());
        System.out.println(p.hasNext());
        System.out.println(p.peek());
        System.out.println(p.hasNext());
        System.out.println(p.next());
        System.out.println(p.hasNext());
    }
}

