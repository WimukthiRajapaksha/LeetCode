/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copy.list.with.random.pointer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class CopyListWithRandomPointer {

    /**
     * @param args the command line arguments
     */
    
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public Node copyRandomList(Node head) {
        Node temp=head;
        while(temp!=null) {
            Node t=new Node(temp.val);
            t.next=temp.next;
            temp.next=t;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null) {
            if(temp.random!=null) {
                temp.next.random=temp.random.next;
            }
            temp=temp.next.next;
        }
        temp=head;
        Node t=new Node(0);
        Node ret=t;
        while(temp!=null) {
            Node next=temp.next.next;
            t.next=temp.next;
            t=t.next;
            temp.next=next;
            temp=temp.next;
        }
        return ret.next;
    }
    
    
    
//    ----------------------OPTIMAL---------------------
//    public Node copyRandomList(Node head) {
//        Node n=new Node(0);
//        Node t=n;
//        Map<Node, Node> map=new HashMap<>();
//        copy(head, n, map);
//        while(head!=null) {
//            n.next.random=map.get(head.random);
//            head=head.next;
//            n=n.next;
//        }
//        return t.next;
//    }
//    
//    private void copy(Node head, Node temp, Map<Node, Node> map) {
//        if(head==null) return;
//        temp.next=new Node(head.val);
//        map.put(head, temp.next);
//        copy(head.next, temp.next, map);
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
