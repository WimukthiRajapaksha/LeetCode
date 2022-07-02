/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lru.cache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class LRUCache {

    /**
     * @param args the command line arguments
     */
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
    }
    
    public void addNode(Node newNode) {
        newNode.next=this.head.next;
        this.head.next=newNode;
        newNode.prev=head;
        newNode.next.prev=newNode;
    }
    
    public Node removeNode(Node node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
        return node;
    }
    
    public void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
    
    public Node popTail() {
        return removeNode(this.tail.prev);
    }
    
    public int get(int key) {
        Node node=map.get(key);
        if(node!=null) {
            this.moveToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node=map.get(key);
        if(node!=null) {
            node.value=value;
            this.moveToHead(node);
        } else {
            if(map.size()==this.capacity) {
                this.map.remove(this.popTail().key);
            }
            Node newNode=new Node();
            newNode.key=key;
            newNode.value=value;
            addNode(newNode);
            map.put(key, newNode);
        }
    }
    
    
    
    
//    ---------------------ALTERNATE -> OPTIMAL-----------------------
//    class Node {
//        int key;
//        int value;
//        Node prev;
//        Node next;
//    }
//    
//    Map<Integer, Node> map;
//    int capacity;
//    Node head;
//    Node tail;
//    
//    public LRUCache(int capacity) {
//        this.capacity=capacity;
//        map=new HashMap<>(capacity);
//        head=new Node();
//        tail=new Node();
//        head.next=tail;
//        tail.prev=head;
//    }
//    
//    public void addNode(Node newNode) {
//        newNode.next=this.head.next;
//        this.head.next=newNode;
//        newNode.prev=head;
//        newNode.next.prev=newNode;
//    }
//    
//    public void removeNode(Node node) {
//        node.prev.next=node.next;
//        node.next.prev=node.prev;
//    }
//    
//    public int get(int key) {
//        Node node=map.get(key);
//        if(node!=null) {
//            removeNode(node);
//            addNode(node);
//            return node.value;
//        }
//        return -1;
//    }
//    
//    public void put(int key, int value) {
//        Node node=map.get(key);
//        if(node!=null) {
//            removeNode(node);
//            node.value=value;
//            addNode(node);
//        } else {
//            if(map.size()==this.capacity) {
//                map.remove(this.tail.prev.key);
//                removeNode(this.tail.prev);
//            }
//            Node newNode=new Node();
//            newNode.key=key;
//            newNode.value=value;
//            addNode(newNode);
//            map.put(key, newNode);
//        }
//    }
    
    
    
    
    
//    ---------------------ALTERNATE -> OPTIMAL-----------------------
//    class Node {
//        int key;
//        int value;
//        Node prev;
//        Node next;
//    }
//    
//    Map<Integer, Node> map;
//    int capacity;
//    Node head;
//    Node tail;
//    
//    public LRUCache(int capacity) {
//        this.capacity=capacity;
//        map=new HashMap<>(capacity);
//        head=new Node();
//        tail=new Node();
//        head.next=tail;
//        tail.prev=head;
//    }
//    
//    public void addNode(Node newNode) {
//        Node next=this.head.next;
//        this.head.next=newNode;
//        newNode.prev=this.head;
//        newNode.next=next;
//        next.prev=newNode;
//    }
//    
//    public void removeNode(Node node) {
//        Node prev=node.prev;
//        Node next=node.next;
//        prev.next=next;
//        next.prev=prev;
//    }
//    
//    public int get(int key) {
//        Node node=map.get(key);
//        if(node!=null) {
//            removeNode(node);
//            addNode(node);
//            return node.value;
//        }
//        return -1;
//    }
//    
//    public void put(int key, int value) {
//        Node node=map.get(key);
//        if(node!=null) {
//            removeNode(node);
//            node.value=value;
//            addNode(node);
//        } else {
//            if(map.size()==this.capacity) {
//                map.remove(this.tail.prev.key);
//                removeNode(this.tail.prev);
//            }
//            Node newNode=new Node();
//            newNode.key=key;
//            newNode.value=value;
//            addNode(newNode);
//            map.put(key, newNode);
//        }
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
