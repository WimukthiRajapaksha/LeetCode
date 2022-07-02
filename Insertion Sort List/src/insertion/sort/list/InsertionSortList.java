/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertion.sort.list;

/**
 *
 * @author wimukthirajapaksha
 */
public class InsertionSortList {

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
    
    
//    ------------------ALTERNATE -> OPTIMAL----------------------
//    public ListNode insertionSortList(ListNode head) {
//        if(head==null || head.next==null) return head;
//        ListNode dumm=new ListNode(-10000, head);
//        ListNode curr=head;
//        ListNode temp=null;
//        while(curr!=null && curr.next!=null) {
//            if(curr.val<=curr.next.val) curr=curr.next;
//            else {
//                ListNode next=curr.next;
////                if(temp==null || temp.next.val>curr.next.val) { // if we need, can uncomment and comment next line
////                    temp=dumm;
////                }
//                temp=dumm;
//                while(temp.next.val<=next.val) {
//                    temp=temp.next;
//                }
//                curr.next=next.next;
//                next.next=temp.next;
//                temp.next=next;
//            }
//        }
//        return dumm.next;
//    }
    
    
    
//    ------------------ALTERNATE -> OPTIMAL----------------------
//    public ListNode insertionSortList(ListNode head) {
//        if(head==null || head.next==null) return head;
//        ListNode dumm=new ListNode(-10000);
//        ListNode prev=dumm;
//        while(head!=null) {
//            ListNode next=head.next;
//            while(prev!=null && prev.next!=null && prev.next.val<head.val) {
//                prev=prev.next;
//            }
//            head.next=prev.next;
//            prev.next=head;
//            head=next;
//            prev=dumm;
//        }
//        return dumm.next;
//    }
    
    
//    ------------------ALTERNATE -> OPTIMAL, ENHANCEMENT TO ABOVE----------------------
//    public ListNode insertionSortList(ListNode head) {
//        if(head==null || head.next==null) return head;
//        ListNode dumm=new ListNode(-10000);
//        ListNode prev=dumm;
//        while(head!=null) {
//            ListNode next=head.next;
//            if(prev.val>head.val) {
//                prev=dumm;
//            }
//            while(prev!=null && prev.next!=null && prev.next.val<head.val) {
//                prev=prev.next;
//            }
//            head.next=prev.next;
//            prev.next=head;
//            head=next;
//        }
//        return dumm.next;
//    }
    
    
    
//    ------------------ALTERNATE -> NOT OPTIMAL----------------------
    public ListNode insertionSortList(ListNode head) {
        ListNode temp=new ListNode(-10000, head);
        return ins(temp).next;
    }
    
    private ListNode ins(ListNode head) {
        if(head.next==null) return head;
        head.next=ins(head.next);
        if(head.val<=head.next.val) {
            return head;
        }
        ListNode tempHead=head;
        while(tempHead!=null && tempHead.next!=null) {
            if(head.val>tempHead.next.val) {
                tempHead=tempHead.next;
            } else {
                ListNode t=head.next;
                head.next=tempHead.next;
                tempHead.next=head;
                return t;
            }
        }
        ListNode t=head.next;
        tempHead.next=head;
        head.next=null;
        return t;
    }
    
    private void print(ListNode n) {
        while(n!=null) {
            System.out.print(n.val+" ");
            n=n.next;
        }
    }
    
    public static void main(String[] args) {
        InsertionSortList i=new InsertionSortList();
        ListNode n=i.insertionSortList(new ListNode(6, new ListNode(5, new ListNode(3, new ListNode(1, new ListNode(8, new ListNode(7, new ListNode(2, new ListNode(4)))))))));
        i.print(n);
    }
}
