/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reorder.list;

/**
 *
 * @author wimukthirajapaksha
 */
public class ReorderList {

    /**
     * @param args the command line arguments
     */
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode h2=reverse(slow.next);
        slow.next=null;
        ListNode h1=head;
        order(h1, h2);
    }
    
    private void order(ListNode h1, ListNode h2) {
        ListNode h1Next;
        ListNode h2Next;
        while(h1!=null && h2!=null) {
            h1Next=h1.next;
            h2Next=h2.next;
            h2.next=h1.next;
            h1.next=h2;
            h2=h2Next;
            h1=h1Next;
        }
    }
    
    private ListNode reverse(ListNode node) {
        ListNode next;
        ListNode prev=null;
        while(node!=null) {
            next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }
    
    
    
    
//    public void reorderList(ListNode head) {
//        if(head==null || head.next==null) return;
//        ListNode slow=head;
//        ListNode fast=head;
//        ListNode prev=null;
//        while(fast!=null && fast.next!=null) {
//            prev=slow;
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        prev.next=null;
//        ListNode h2=reverse(slow);
//        ListNode h1=head;
//        order(h1, h2);
//    }
//    
//    private void order(ListNode h1, ListNode h2) {
//        ListNode h1Next;
//        ListNode h2Next;
//        while(h2!=null) {
//            h1Next=(h1!=null) ? h1.next : null;
//            h2Next=h2.next;
//            h1.next=h2;
//            if(h1Next==null) return;
//            h2.next=h1Next;
//            h2=h2Next;
//            h1=h1Next;
//        }
//    }
//    
//    private ListNode reverse(ListNode node) {
//        ListNode next;
//        ListNode prev=null;
//        while(node!=null) {
//            next=node.next;
//            node.next=prev;
//            prev=node;
//            node=next;
//        }
//        return prev;
//    }
    
    
    
//    public void reorderList(ListNode head) {
//        if(head==null || head.next==null) return;
//        ListNode slow=head;
//        ListNode fast=head;
//        ListNode prev=null;
//        while(fast!=null && fast.next!=null) {
//            prev=slow;
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        prev.next=null;
//        ListNode next;
//        prev=null;
//        while(slow!=null) {
//            next=slow.next;
//            slow.next=prev;
//            prev=slow;
//            slow=next;
//        }
//        ListNode headNext;
//        ListNode tailNext;
//        while(prev!=null) {
//            headNext=(head!=null) ? head.next : null;
//            tailNext=prev.next;
//            head.next=prev;
//            if(headNext==null) return;
//            prev.next=headNext;
//            prev=tailNext;
//            head=headNext;
//        }
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
