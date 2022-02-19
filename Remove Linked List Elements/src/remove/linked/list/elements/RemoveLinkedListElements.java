/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remove.linked.list.elements;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemoveLinkedListElements {

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
    
//    public ListNode removeElements(ListNode head, int val) {
//        if(head==null) return null;
//        while(head!=null && head.val==val) {
//            head=head.next;
//        }
//        ListNode t=head;
//        while(t!=null && t.next!=null) {
//            if(t.next.val==val) {
//                t.next=t.next.next;
//            } else {
//                t=t.next;
//            }
//        }
//        return head;
//    }

    
    
//    public ListNode removeElements(ListNode head, int val) {
//        if(head==null) {
//            return null;
//        }
//        if (head.val==val) {
//            head=removeElements(head.next, val);
//        } else {
//            head.next=removeElements(head.next, val);
//        }
//        return head;
//    }
    
    
    
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) {
            return null;
        }
        head.next=removeElements(head.next, val);
        head = (head.val==val) ? removeElements(head.next, val) : head;
        return head;
    }
    
    public static void main(String[] args) {
        RemoveLinkedListElements r=new RemoveLinkedListElements();
        r.removeElements(new ListNode(10, new ListNode(4, new ListNode(8))), 4);
    }
    
}
