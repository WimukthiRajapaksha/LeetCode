/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotate.list;

/**
 *
 * @author wimukthirajapaksha
 */
public class RotateList {

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
    
//    --------------------OPTIMAL-----------------------
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        int length=1;
        ListNode t=head;
        while(t.next!=null) {
            t=t.next;
            length++;
        }
        k=k%length;
        if(k==0) {
            print(head);
            return head;
        }
        t.next=head;
        int v=length-k-1;
        while(v-->0) {
            head=head.next;
        }
        ListNode newHead=head.next;
        head.next=null;
        print(newHead);
        return newHead;
    }
    
    
    
//    --------------------ALTERNATE -> NOT OPTIMAL-----------------------
//    public ListNode rotateRight(ListNode head, int k) {
//        if(head==null || k==0) return head;
//        ListNode t=head;
//        ListNode u=head;
//        while(k>0) {
//            t=t.next;
//            k--;
//            if(t==null) t=head;
//        }
//        while(t.next!=null) {
//            t=t.next;
//            u=u.next;
//        }
//        t.next=head;
//        ListNode n=u.next;
//        u.next=null;
//        print(n);
//        return n;
//    }
    
    public void print(ListNode n) {
        while(n!=null) {
            System.out.print(n.val+" ");
            n=n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        RotateList r=new RotateList();
        r.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        r.rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4);
        r.rotateRight(new ListNode(1), 1);
    }
}
