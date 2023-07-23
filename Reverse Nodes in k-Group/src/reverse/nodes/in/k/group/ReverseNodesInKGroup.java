/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse.nodes.in.k.group;

/**
 *
 * @author wimukthirajapaksha
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return val+" ->"+next;
    }
}

public class ReverseNodesInKGroup {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------------OPTIMAL, ITERATIVE -> O(N), O(1)-----------------------
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1) return head;
        ListNode dummy=new ListNode(0, head);
        ListNode prev=dummy;
        ListNode tempHead=head;
        while(true) {
            ListNode temp=tempHead;
            for(int i=0; i<k; i++) {
                if(tempHead==null) {
                    prev.next=temp;
                    return dummy.next;
                }
                tempHead=tempHead.next;
            }
            ListNode revHead=reverse(temp, k);
            prev.next=revHead;
            prev=temp;
        }
    }
    
    private ListNode reverse(ListNode node, int k) {
        ListNode prev=null;
        ListNode next;
        while(k-->0) {
            next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }
    
    
    
//    -----------------------OPTIMAL, RECURSIVE -> O(N), O(N/K)-----------------------
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if(head==null || head.next==null || k==1) return head;
//        int c=k;
//        ListNode curr=head;
//        while(c>0) {
//            if(curr==null) return head;
//            curr=curr.next;
//            c--;
//        }
//        curr=head;
//        ListNode pre=null;
//        ListNode next=null;
//        c=k;
//        while(c>0) {
//            next=curr.next;
//            curr.next=pre;
//            pre=curr;
//            curr=next;
//            c--;
//        }
//        head.next=reverseKGroup(curr, k);
//        return pre;
//    }
    
    
    
//    -----------------------OPTIMAL, RECURSIVE -> O(N), O(N/K)-----------------------
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if(head==null || head.next==null || k==1) return head;
//        int c=1;
//        ListNode temp=head;
//        while(temp.next!=null) {
//            temp=temp.next;
//            c++;
//        }
//        if(c<k) return head;
//        temp=head;
//        ListNode pre=null;
//        int total=k;
//        while(total>0) {
//            pre=temp;
//            temp=temp.next;
//            total--;
//        }
//        if(pre!=null) pre.next=null;
//        reverse(head);
//        head.next=reverseKGroup(temp, k);
//        return pre;
//    }
//    
//    private void reverse(ListNode node) {
//        ListNode pre=null;
//        ListNode temp=node;
//        while(temp!=null) {
//            node=node.next;
//            temp.next=pre;
//            pre=temp;
//            temp=node;
//        }
//    }
    
    
    
    
//    -----------------------OPTIMAL, OWN SOLUTION, RECURSIVE -> O(N), O(N/K)-----------------------
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if(head==null || head.next==null || k==1) return head;
//        return rev(head, k-1, k-1);
//    }
//    
//    private ListNode rev(ListNode head, int k, int t) {
//        if(head==null) return null;
//        ListNode temp=head;
//        int u=t;
//        while(u>0) {
//            temp=temp.next;
//            if(temp==null) return head;
//            u--;
//        }
//        ListNode prev=head;
//        ListNode curr=prev.next;
//        ListNode next=null;
//        while(t>0) {
//            next=curr.next;
//            curr.next=prev;
//            prev=curr;
//            curr=next;
//            t--;
//        }
//        head.next=rev(curr, k, k);
//        return prev;
//    }
    
    public static void main(String[] args) {
        ReverseNodesInKGroup r=new ReverseNodesInKGroup();
        System.out.println(r.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 1));
        System.out.println(r.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(r.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3));
        System.out.println(r.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 4));
        System.out.println(r.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 5));
    }
}
