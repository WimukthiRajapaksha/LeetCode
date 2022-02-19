/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intersection.of.two.linked.lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * @param args the command line arguments
     */
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        int c1=0;
        int c2=0;
        ListNode n1=headA;
        ListNode n2=headB;
        while(headA!=null) {
            headA=headA.next;
            c1++;
        }
        while(headB!=null) {
            headB=headB.next;
            c2++;
        }
        if (c1>c2) {
            while(c1!=c2) {
                n1=n1.next;
            }
        }
        if (c1<c2) {
            while(c1!=c2) {
                n2=n2.next;
            }
        }
        while(n1!=n2) {
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }
    
    
//    ----------------------------ALTERNATE-------------------------------------
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA==null || headB==null) return null;
//        ListNode l1=headA;
//        ListNode l2=headB;
//        while(headA!=headB) {
//            headA = (headA==null) ? l2 : headA.next;
//            headB = (headB==null) ? l1 : headB.next;
//        }
//        return headA;
//    }
    
    
//    -------------------------ALTERNATE -> NOT OPTIMAL--------------------------
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Map<ListNode, Integer> map=new HashMap<>();
//        while(headA!=null) {
//            map.put(headA, 0);
//            headA=headA.next;
//        }
//        while(headB!=null) {
//            if(map.containsKey(headB)) {
//                return headB;
//            }
//            headB=headB.next;
//        }
//        return null;
//    }
    
    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists i=new IntersectionOfTwoLinkedLists();
        i.getIntersectionNode(new ListNode(2), new ListNode(5));
    }
}
