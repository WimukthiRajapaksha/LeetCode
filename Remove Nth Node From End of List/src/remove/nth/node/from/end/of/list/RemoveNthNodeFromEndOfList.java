/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remove.nth.node.from.end.of.list;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemoveNthNodeFromEndOfList {

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
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        while(n-->0) {
            temp=temp.next;
        }
        if(temp==null) return head.next;
        ListNode t=head;
        while(temp.next!=null) {
            t=t.next;
            temp=temp.next;
        }
        t.next = t.next.next;
        return head;
    }
    
    public void print(ListNode n) {
        while(n!=null) {
            System.out.print(n.val+" ");
            n=n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList r=new RemoveNthNodeFromEndOfList();
        ListNode n=r.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        r.print(n);
        n=r.removeNthFromEnd(new ListNode(1), 1);
        r.print(n);
        n=r.removeNthFromEnd(new ListNode(1, new ListNode(2)), 1);
        r.print(n);
    }
    
}
