/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flatten.nested.list.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */

interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

class NeInt implements NestedInteger {
    List<NestedInteger> l;
    Integer val;

    public NeInt() {
    }

    @Override
    public boolean isInteger() {
        return l.isEmpty();
    }

    @Override
    public Integer getInteger() {
        return this.val;
    }

    @Override
    public List<NestedInteger> getList() {
        return this.l;
    }
    
}


//-----------------OPTIMAL -> BEAUTIFUL-----------------------
class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack=new Stack<>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        extract(nestedList);
    }
    
    private void extract(List<NestedInteger> list) {
        for(int i=list.size()-1; i>=0; i--) {
            stack.push(list.get(i));
        }
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            if(stack.peek().isInteger()) return true;
            extract(stack.pop().getList());
        }
        return !stack.isEmpty();
    }
}


//---------------------ALTERNATE -> NOT OPTIMAL AND BEAUTIFUL------------------
//class NestedIterator implements Iterator<Integer> {
//    Queue<Integer> queue;
//    int posi;
//    
//    public NestedIterator(List<NestedInteger> nestedList) {
//        this.queue = new LinkedList<>();
//        extract(nestedList, queue);
//        posi=0;
//    }
//    
//    private void extract(List<NestedInteger> l, Queue<Integer> re) {
//        for(NestedInteger n: l) {
//            if(n.isInteger()) {
//                re.offer(n.getInteger());
//            } else {
//                extract(n.getList(), re);
//            }
//        }
//    }
//
//    @Override
//    public Integer next() {
//        return queue.poll();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return !queue.isEmpty();
//    }
//}

public class FlattenNestedListIterator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
