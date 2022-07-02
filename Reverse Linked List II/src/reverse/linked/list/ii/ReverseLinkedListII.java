/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse.linked.list.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class ReverseLinkedListII {

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
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null) return head;
        ListNode p=new ListNode(0, head);
        ListNode prev=p;
        while(left>1) {
            prev=head;
            head=head.next;
            right--;
            left--;
        }
        
        ListNode HH=head;
        ListNode headNext=prev;
        prev=null;
        
        while(right>0) {
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
            right--;
        }
        HH.next=head;
        headNext.next=prev;
        return p.next;
    }
    
    private void print(ListNode n) {
        if(n==null) return;
        System.out.print(n.val+" ");
        print(n.next);
    }
    
    private ListNode nod(int[] a) {
        ListNode n=null;
        ListNode head=null;
        for(int i=0; i<a.length; i++) {
            if(n==null) {
                n=new ListNode(a[i]);
                head=n;
            } else {
                n.next=new ListNode(a[i]);
                n=n.next;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        ReverseLinkedListII r=new ReverseLinkedListII();
        ListNode n=r.nod(new int[]{1,2,3,4,5,6});
        r.print(r.reverseBetween(n, 2, 5));
        
        n=r.nod(new int[]{3,5});
        System.out.println();
        r.print(r.reverseBetween(n, 1, 1));
        
        n=r.nod(new int[]{3,5});
        System.out.println();
        r.print(r.reverseBetween(n, 1, 2));
    }
}
