/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middle.of.the.linked.list;

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
}

public class MiddleOfTheLinkedList {

    /**
     * @param args the command line arguments
     */
    
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
