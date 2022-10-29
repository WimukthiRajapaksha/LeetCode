/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odd.even.linked.list;

/**
 *
 * @author wimukthirajapaksha
 */
public class OddEvenLinkedList {

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
    
    
//    --------------------ALTERNATE -> BEAUTIFUL-----------------
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=even;
        while(even!=null && even.next!=null) {
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
    
    
//    ------------------------OPTIMAL -> ALTERNATE---------------------------
//    public ListNode oddEvenList(ListNode head) {
//        if(head==null || head.next==null || head.next.next==null) return head;
//        ListNode odd=new ListNode();
//        ListNode even=new ListNode();
//        ListNode tOdd=odd;
//        ListNode tEven=even;
//        boolean oddP=true;
//        while(head!=null) {
//            if(oddP) {
//                tOdd.next=head;
//                tOdd=tOdd.next;
//            } else {
//                tEven.next=head;
//                tEven=tEven.next;
//            }
//            head=head.next;
//            oddP=!oddP;
//        }
//        tOdd.next=even.next;
//        tEven.next=null;
//        return odd.next;
//    }
    
    private void print(ListNode n) {
        if(n==null) {
            System.out.println();
            return;
        }
        System.out.print(n.val+" ");
        print(n.next);
    }
    
    public static void main(String[] args) {
        OddEvenLinkedList o=new OddEvenLinkedList();
        o.print(o.oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
        o.print(o.oddEvenList(new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))))));
    }
}
