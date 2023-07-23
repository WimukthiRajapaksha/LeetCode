/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.twin.sum.of.a.linked.list;

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
        return " "+val;
    }
}

public class MaximumTwinSumOfALinkedList {

    /**
     * @param args the command line arguments
     */
    
//    --------------OPTIMAL -> O(N), O(1)-----------------
//    ListNode last=null;
//    public int pairSum(ListNode head) {
//        head=new ListNode(0, head);
//        ListNode temp=mid(head);
//        System.out.println(temp);
//        reverse(temp);
//        int max=0;
//        head=head.next;
//        System.out.println(head+" "+last);
//        while(last.next!=head) {
//            max=Math.max(last.val+head.val, max);
//            last=last.next;
//            head=head.next;
//        }
//        return Math.max(max, last.val+head.val);
//    }
//
//    private ListNode mid(ListNode slow) {
//        ListNode prev=null;
//        ListNode fast=slow;
//        while(fast!=null && fast.next!=null) {
//            prev=slow;
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        return prev;
//    }
//
//    private ListNode reverse(ListNode head) {
//        if(head==null || head.next==null) {
//            last=head;
//            return head;
//        }
//        ListNode temp=reverse(head.next);
//        temp.next=head;
//        return head;
//    }
    
    
    
//    --------------OPTIMAL -> O(N), O(1)-----------------
//    public int pairSum(ListNode head) {
//        head=new ListNode(0, head);
//        ListNode temp=mid(head);
//        System.out.println(temp);
//        ListNode last=reverse(temp);
//        int max=0;
//        head=head.next;
//        System.out.println(head+" "+last);
//        while(last.next!=head) {
//            max=Math.max(last.val+head.val, max);
//            last=last.next;
//            head=head.next;
//        }
//        return Math.max(max, last.val+head.val);
//    }
//
//    private ListNode mid(ListNode slow) {
//        ListNode prev=null;
//        ListNode fast=slow;
//        while(fast!=null && fast.next!=null) {
//            prev=slow;
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        return prev;
//    }
//
//    private ListNode reverse(ListNode head) {
//        if(head==null || head.next==null) {
//            return head;
//        }
//        ListNode temp=reverse(head.next);
//        head.next.next=head;
//        return temp;
//    }
    
//    --------------OPTIMAL -> O(N), O(1)-----------------
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        ListNode next=null;
        while(slow!=null) {
            next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }
        int max=0;
        while(prev!=null) {
            max=Math.max(max, head.val+prev.val);
            head=head.next;
            prev=prev.next;
        }
        return max;
    }
    
    public static void main(String[] args) {
        MaximumTwinSumOfALinkedList m=new MaximumTwinSumOfALinkedList();
//        System.out.println(m.pairSum(new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))))));
        System.out.println(m.pairSum(new ListNode(5, new ListNode(4))));
    }
}
