/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfu.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.util.Pair;

/**
 *
 * @author wimukthirajapaksha
 */

public class LFUCache {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------OPTIMAL -> BEAUTIFUL -> BEST -> O(1), O(MIN(N, CAPACITY))----------------
    class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    
    class DLL {
        Node head;
        Node tail;
        int size;

        public DLL() {
            this.head=new Node(-1, -1);
            this.tail=new Node(-1, -1);
            this.head.next=this.tail;
            this.tail.prev=this.head;
        }
        
        private void addToHead(Node node) {
            node.next=this.head.next;
            node.next.prev=node;
            this.head.next=node;
            node.prev=this.head;
            size++;
        }
        
        private void removeNode(Node node) {
            node.next.prev=node.prev;
            node.prev.next=node.next;
            size--;
        }
        
        private Node removeLast() {
            Node temp=this.tail.prev;
            removeNode(temp);
            return temp;
        }
    }
    
    Map<Integer, Node> cache;
    Map<Integer, DLL> frequency;
    int minFreq;
    int capacity;
    
    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.cache=new HashMap<>();
        this.frequency=new HashMap<>();
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)) return -1;
        Node temp=this.cache.get(key);
        updateNode(temp);
        return temp.value;
    }
    
    public void put(int key, int value) {
        if(this.capacity<=0) return;
        if(this.cache.containsKey(key)) {
            Node temp=this.cache.get(key);
            temp.value=value;
            updateNode(temp);
        } else {
            if(this.capacity==this.cache.size()) {
                DLL temp=this.frequency.get(minFreq);
                Node last=temp.removeLast();
                this.cache.remove(last.key);
            }
            Node node=new Node(key, value);
            minFreq=1;
            DLL tempDLL=this.frequency.getOrDefault(1, new DLL());
            tempDLL.addToHead(node);
            this.frequency.put(1, tempDLL);
            this.cache.put(key, node);
        }
    }
    
    private void updateNode(Node node){
        int count=node.freq;
        DLL oldList=frequency.get(node.freq);
        oldList.removeNode(node);
        if(count==minFreq && oldList.size==0) {
            minFreq++;
        }
        count++;
        node.freq=count;
        DLL newList=frequency.getOrDefault(count, new DLL());
        newList.addToHead(node);
        frequency.put(count, newList);
    }
    
    
//    -------------------OPTIMAL -> BEAUTIFUL -> O(1), O(MIN(N, CAPACITY))----------------
//    Map<Integer, int[]> cache; // key, frequency, value
//    Map<Integer, LinkedHashSet<Integer>> frequencies; // frequency, key
//    int minFreq;
//    int capacity;
//    
//    public LFUCache(int capacity) {
//        this.capacity=capacity;
//        this.cache=new HashMap<>();
//        this.frequencies=new HashMap<>();
//        this.minFreq=0;
//    }
//    
//    public void insert(int key, int frequency, int value) {
//        this.cache.put(key, new int[]{frequency, value}); // change the cache with new frequency and value
//        this.frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
//        this.frequencies.get(frequency).add(key); // set new frequency
//    }
//    
//    public int get(int key) {
//        int[] freqAndVal=this.cache.get(key); // frequency, value
//        if(freqAndVal==null) return -1; // key is not there in cache
//        int frequency=freqAndVal[0];
//        int value=freqAndVal[1];
//        Set<Integer> frequencySet=this.frequencies.get(frequency); // frequency, key
//        frequencySet.remove(key); // removing that item to set new frequency to key
//        if(minFreq==frequency && frequencySet.isEmpty()) {
//            minFreq++;
//        }
//        this.insert(key, frequency+1, value); // set new frequency 
//        return value;
//    }
//    
//    public void put(int key, int value) {
//        if(this.capacity<=0) return;
//        int[] existing=this.cache.get(key);
//        if(existing!=null) { // already existing key
//            existing[1]=value; // change the value incase it's changed
//            get(key); // update the frequency indexes and min frequency index
//            return;
//        }
//        if(this.capacity==this.cache.size()) { // remove LRU item
//            Set<Integer> keys=this.frequencies.get(minFreq);
//            int keyToDelete = keys.iterator().next();
//            cache.remove(keyToDelete);
//            keys.remove(keyToDelete);
//        }
//        minFreq=1;
//        insert(key, 1, value);
//    }
    
    public static void main(String[] args) {
        LFUCache l=new LFUCache(2);
        l.put(1, 1);
        l.put(2, 2);
        System.out.println(l.get(1));
        l.put(3, 3);
        System.out.println(l.get(2));
        System.out.println(l.get(3));
        l.put(4, 4);
        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
    }
}
