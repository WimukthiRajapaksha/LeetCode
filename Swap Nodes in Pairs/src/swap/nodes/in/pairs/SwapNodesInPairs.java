/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swap.nodes.in.pairs;

/**
 *
 * @author wimukthirajapaksha
 */
public class SwapNodesInPairs {

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
    
    
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode ret=head.next;
        ListNode pre=null;
        while(head!=null && head.next!=null) {
            ListNode t=head.next;
            if(pre!=null) pre.next=t;
            head.next=t.next;
            t.next=head;
            head=t.next.next;
            pre=t.next;
        }
        return ret;
    }
    
    public void print(ListNode n) {
        while(n!=null) {
            System.out.print(n.val+" ");
            n=n.next;
        }
    }
    
    
//    public ListNode swapPairs(ListNode head) {
//        if(head==null || head.next==null) {
//            return head;
//        }
//        ListNode t=head.next;
//        head.next=swapPairs(head.next.next);
//        t.next=head;
//        return t;
//    }
    
    public static void main(String[] args) {
        SwapNodesInPairs sw=new SwapNodesInPairs();
//        ListNode t=sw.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
//        ListNode t=sw.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        ListNode t=sw.swapPairs(null);
        sw.print(t);
    }
}
