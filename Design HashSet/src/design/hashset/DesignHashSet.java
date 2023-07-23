/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.hashset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */


// ------------------------OPTIMAL -> O(N), O(N)--------------------
//class MyHashSet {
//    int[] arr;
//    
//    public MyHashSet() {
//        arr=new int[31251];
//    }
//    
//    public void add(int key) {
//        arr[getKey(key)]|=getValue(key);
//    }
//    
//    public void remove(int key) {
//        arr[getKey(key)]&=(~getValue(key));
//    }
//    
//    public boolean contains(int key) {
//        return (arr[getKey(key)]&getValue(key))!=0;
//    }
//    
//    private int getKey(int key) {
//        return (int)(key/32);
//    }
//    
//    private int getValue(int value) {
//        return 1<<(value%32);
//    }
//}



// -------------OPTIMAL -> O(N), O(N)---------
class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class MyHashSet {
    Node[] arr;
    int size;
    
    public MyHashSet() {
        size=997;
        arr=new Node[size];
    }
    
    public void add(int key) {
        if(this.contains(key)) return;
        Node hashed=arr[hashKey(key)];
        if(hashed==null) {
            arr[hashKey(key)]=new Node(key, null);
            return;
        }
        this.arr[hashKey(key)]=new Node(key, hashed);
    }
    
    public void remove(int key) {
        if(this.arr[hashKey(key)]==null) return;
        Node temp=this.arr[hashKey(key)];
        if(temp.val==key) {
            this.arr[hashKey(key)]=temp.next;
            return;
        }
        while(temp.next!=null && temp.next.val!=key) {
            temp=temp.next;
        }
        if(temp.next!=null) temp.next=temp.next.next;
    }
    
    public boolean contains(int key) {
        if(this.arr[hashKey(key)]==null) return false;
        Node temp=this.arr[hashKey(key)];
        while(temp!=null && temp.val!=key) {
            temp=temp.next;
        }
        return temp!=null;
    }
    
    private int hashKey(int key) {
        return (int)(key%size);
    }
}




public class DesignHashSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyHashSet m=new MyHashSet();
        m.add(1);
        m.add(2);
        System.out.println(m.contains(1));
        System.out.println(m.contains(3));
        m.add(2);
        System.out.println(m.contains(2));
        m.remove(2);
        System.out.println(m.contains(2));
    }
}
