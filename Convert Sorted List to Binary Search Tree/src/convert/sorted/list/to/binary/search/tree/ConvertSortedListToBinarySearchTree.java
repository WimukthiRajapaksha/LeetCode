/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert.sorted.list.to.binary.search.tree;

/**
 *
 * @author wimukthirajapaksha
 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * @param args the command line arguments
     */
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return mid(head, null);
    }
    
    private TreeNode mid(ListNode head, ListNode tail) {
        ListNode slow=head;
        ListNode fast=head;
        if(head==tail) return null;
        while(fast!=tail && fast.next!=tail) {
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=mid(head, slow);
        root.right=mid(slow.next, tail);
        return root;
    }
    
    
    
//    public TreeNode sortedListToBST(ListNode head) {
//        if(head==null) return null;
//        ListNode mid=mid(head);
//        TreeNode node = new TreeNode(mid.val);
//        if(mid==head) {
//            return node;
//        }
//        node.left=sortedListToBST(head);
//        node.right=sortedListToBST(mid.next);
//        return node;
//    }
//    
//    private ListNode mid(ListNode head) {
//        ListNode slow=head;
//        ListNode fast=head;
//        ListNode pre=head;
//        while(fast!=null && fast.next!=null) {
//            pre=slow;
//            fast=fast.next.next;
//            slow=slow.next;
//        }
//        if(pre!=null) {
//            pre.next=null;
//        }
//        return slow;
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
