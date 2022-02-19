/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse.linked.list;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class ReverseLinkedList {

    /**
     * @param args the command line arguments
     */
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
//    ------------------------------RECURSIVE------------------------------------
//    public ListNode reverseList(ListNode head) {
//        if(head==null || head.next==null) {
//            return head;
//        }
//        ListNode node = reverseList(head.next);
//        head.next.next=head;
//        head.next=null;
//        return node;
//    }
    
    
//    ----------------ALTERNATE -> ITERATIVE -> NOT OPTIMAL---------------------
//    public ListNode reverseList(ListNode head) {
//        if(head==null) return null;
//        Stack<ListNode> stack=new Stack<>();
//        ListNode next=head.next;
//        while(next!=null) {
//            head.next=null;
//            stack.push(head);
//            head=next;
//            next=next.next;
//        }
//        ListNode n=head;
//        ListNode t=n;
//        while(!stack.isEmpty()) {
//            t.next=stack.pop();
//            t=t.next;
//        }
//        return n;
//    }
    
//    -----------------------ITERATIVE -> OPTIMAL--------------------------------
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode current=head;
        ListNode pre=null;
        ListNode next=head.next;
        while(current!=null) {
            next=current.next;
            current.next=pre;
            pre=current;
            current=next;
        }
        return pre;
    }
    
    
    public void print(ListNode n) {
        while(n!=null) {
            System.out.print(n.val+" ");
            n=n.next;
        }
    }
    
    public static void main(String[] args) {
        ReverseLinkedList r=new ReverseLinkedList();
        ListNode n =r.reverseList(new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8)))));
        r.print(n);
    }
}
