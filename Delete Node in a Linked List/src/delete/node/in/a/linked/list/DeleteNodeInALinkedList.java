/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delete.node.in.a.linked.list;

/**
 *
 * @author wimukthirajapaksha
 */
public class DeleteNodeInALinkedList {

    /**
     * @param args the command line arguments
     */
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
    
    
    public static void main(String[] args) {
        DeleteNodeInALinkedList d=new DeleteNodeInALinkedList();
        ListNode ll=new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));
        ListNode l=new ListNode(1, ll);
        d.deleteNode(ll);
    }
}
