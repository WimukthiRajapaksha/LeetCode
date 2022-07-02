/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partition.list;

/**
 *
 * @author wimukthirajapaksha
 */
public class PartitionList {

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
    
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        ListNode rightHead=new ListNode();
        ListNode leftHead=new ListNode();
        ListNode left=leftHead;
        ListNode right=rightHead;
        while(head!=null) {
            if(head.val<x) {
                left.next=head;
                left=left.next;
            } else {
                right.next=head;
                right=right.next;
            }
            head=head.next;
        }
        right.next=null;
        left.next=rightHead.next;
        return leftHead.next;
    }
    
    
//    public ListNode partition(ListNode head, int x) {
//        if(head==null || head.next==null) return head;
//        ListNode left=null;
//        ListNode right=null;
//        ListNode rightHead=null;
//        ListNode leftHead=null;
//        while(head!=null) {
//            if(head.val<x) {
//                if(left==null) {
//                    left=head;
//                    leftHead=left;
//                } else {
//                    left.next=head;
//                    left=left.next;
//                }
//            } else {
//                if(right==null) {
//                    right=head;
//                    rightHead=right;
//                } else {
//                    right.next=head;
//                    right=right.next;
//                }
//            }
//            head=head.next;
//        }
//        if(right!=null) right.next=null;
//        if(leftHead!=null) left.next=rightHead;
//        return (leftHead!=null) ? leftHead : rightHead;
//    }
    
    private void print(ListNode n) {
        if(n==null) return;
        System.out.print(n.val+" ");
        print(n.next);
    }
    
    public static void main(String[] args) {
        PartitionList p=new PartitionList();
        ListNode n=p.partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3);
        p.print(n);
        System.out.println();
        n=p.partition(new ListNode(2, new ListNode(1)), 2);
        p.print(n);
    }
}
