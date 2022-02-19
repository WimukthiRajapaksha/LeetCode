/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome.linked.list;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class PalindromeLinkedList {

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
    
//    --------------OPTIMAL -> NOT UPDATING THE LIST--------------------
//    ListNode ref=null;
//    public boolean isPalindrome(ListNode head) {
//        ref=head;
//        return isPalindro(head);
//    }
//    
//    public boolean isPalindro(ListNode head) {
//        if(head==null) return true;
//        boolean ispal=isPalindro(head.next);
//        if (!ispal) return false;
//        boolean bo=(ref.val==head.val);
//        ref=ref.next;
//        return bo;
//    }
    
    
    
//    --------------OPTIMAL -> NOT UPDATING THE LIST--------------------
//    public boolean isPalindrome(ListNode head) {
//        ListNode pre=new ListNode(-1, head);
//        return isPalindrome(pre, head);
//    }
//    
//    public boolean isPalindrome(ListNode beg, ListNode end) {
//        if(end==null) return true;
//        boolean isPali = isPalindrome(beg, end.next);
//        if (!isPali) {
//            return false;
//        }
//        boolean comp = (beg.next.val==end.val);
//        beg.next=beg.next.next;
//        return comp;
//    }
    
    
            
//    -------------------OPTIMAL -> UPDATING THE LIST---------------------
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=reverse(slow);
        while(slow!=null) {
            if(head.val!=slow.val) return false;
            head=head.next;
            slow=slow.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev=null;
        while(head!=null) {
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
    
    
    
//     ---------------------ALTERNATE -> NOT OPTIMAL----------------------
//    public boolean isPalindrome(ListNode head) {
//        Stack<ListNode> stack=new Stack<>();
//        ListNode t=head;
//        while(t!=null) {
//            stack.push(t);
//            t=t.next;
//        }
//        while(!stack.isEmpty()) {
//            if(stack.pop().val!=head.val) {
//                return false;
//            }
//            head=head.next;
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        PalindromeLinkedList p=new PalindromeLinkedList();
        System.out.println(p.isPalindrome(new ListNode(12, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(2, new ListNode(1)))))))));
    }
}
