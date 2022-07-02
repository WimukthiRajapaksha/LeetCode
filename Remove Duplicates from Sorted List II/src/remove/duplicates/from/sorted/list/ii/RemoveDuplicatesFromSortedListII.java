/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remove.duplicates.from.sorted.list.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemoveDuplicatesFromSortedListII {

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

//    ---------------------OPTIMAL -> RECURSIVE--------------------
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        if(head.val==head.next.val) {
            while(head.next!=null && head.val==head.next.val) {
                head=head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next=deleteDuplicates(head.next);
            return head;
        }
    }
    
    
//    ---------------------OPTIMAL -> ITERATIVE--------------------
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head==null) return head;
//        ListNode t=new ListNode(0, head);
//        ListNode prev=t;
//        while(head!=null && head.next!=null) {
//            if(head.val==head.next.val) {
//                while(head.next!=null && head.val==head.next.val) {
//                    head.next=head.next.next;
//                }
//                prev.next=head.next;
//            } else {
//                prev=prev.next;
//            }
//            head=head.next;
//        }
//        return t.next;
//    }
    
    private void print(ListNode n) {
        if(n==null) return;
        System.out.print(n.val+" ");
        print(n.next);
    }
    
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII r=new RemoveDuplicatesFromSortedListII();
        ListNode t=r.deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))))));
        r.print(t);
        System.out.println();
        t=r.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))))));
        r.print(t);
    }
}
