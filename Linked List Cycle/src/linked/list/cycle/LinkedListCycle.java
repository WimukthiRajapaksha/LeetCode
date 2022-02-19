/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked.list.cycle;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class LinkedListCycle {

    /**
     * @param args the command line arguments
     */
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public boolean hasCycle(ListNode head) {
        if (head==null) {
            return false;
        }
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null) {
            if (fast==head) {
                return true;
            }
            fast=fast.next.next;
            head=head.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        LinkedListCycle l = new LinkedListCycle();
        ListNode l1 = new ListNode(3);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(0);
        l1.next.next.next=new ListNode(-4);
        l1.next.next.next.next=l1.next;
        System.out.println(l.hasCycle(l1));
    }
}
