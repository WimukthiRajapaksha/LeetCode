/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delete.the.middle.node.of.a.linked.list;

/**
 *
 * @author wimukthirajapaksha
 */
public class DeleteTheMiddleNodeOfALinkedList {

    /**
     * @param args the command line arguments
     */
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return val+" "+next;
        }
    }
    
    public ListNode deleteMiddle(ListNode head) {
        head=new ListNode(0, head);
        ListNode root=head;
        ListNode temp=head.next;
        while(temp!=null && temp.next!=null) {
            temp=temp.next.next;
            head=head.next;
        }
        head.next=head.next.next;
        return root.next;
    }
    
    public static void main(String[] args) {
        DeleteTheMiddleNodeOfALinkedList d=new DeleteTheMiddleNodeOfALinkedList();
        System.out.println(d.deleteMiddle(new ListNode(0)));
    }
}
