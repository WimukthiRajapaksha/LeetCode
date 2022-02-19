/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remove.duplicates.from.sorted.list;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemoveDuplicatesFromSortedList {

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
    
//    -----------------USING ONLY ONE LOOP---------------------------
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node!=null && node.next!=null) {
            if (node.val==node.next.val) {
                node.next=node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
    
//    -----------------ALTERNATE - USING TWO LOOPS---------------------------
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode node = head;
//        while(node!=null) {
//            while (node.next!=null && node.val==node.next.val) {
//                node.next=node.next.next;
//            }
//            node=node.next;
//        }
//        return head;
//    }
    
//    -----------------USING TWO LOOPS---------------------------
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode node = head;
//        while(node!=null) {
//            if (node.next==null) {
//                return head;
//            } else if (node.val==node.next.val) {
//                ListNode temp = node.next.next;
//                while(temp!=null) {
//                    if (node.val!=temp.val) {
//                        node.next=temp;
//                        break;
//                    } else {
//                        temp=temp.next;
//                    }
//                }
//                if (temp==null) {
//                    node.next=temp;
//                }
//            }
//            node=node.next;
//        }
//        return head;
//    }
    
//    -----------------ALTERNATE - RECURSIVE---------------------------
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head==null || head.next==null) {
//            return head;
//        }
//        head.next = deleteDuplicates(head.next);
//        return (head.val==head.next.val) ? head.next : head;
//    }
    
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
        ListNode l = r.deleteDuplicates(new ListNode(2, new ListNode(2, new ListNode(2))));
        while(l!=null) {
            System.out.print(l.val+" ");
            l=l.next;
        }
    }
}
