/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add.two.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class AddTwoNumbers {

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
    
    public void add(ListNode l1, ListNode l2, ListNode l3, int a) {
        a += (l1==null ? 0 : l1.val) + (l2==null ? 0 : l2.val);
        l3.val = a%10;
        a/=10;
        l1 = (l1==null) ? l1 : l1.next;
        l2 = (l2==null) ? l2 : l2.next;
        System.out.println(l3.val);
        if (l1!=null || l2!=null || a>0) {
            l3.next = new ListNode();
            add(l1, l2, l3.next, a);
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        add(l1, l2, node, 0);
        System.out.println(node.val);
        return node.next;
    }
    
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int val=0;
//        ListNode node = new ListNode();
//        ListNode temp = node.next;
//        while(l1!=null || l2!=null) {
//            if (l1!=null) {
//                val+=l1.val;
//                l1=l1.next;
//            }
//            if (l2!=null) {
//                val+=l2.val;
//                l2=l2.next;
//            }
//            node.next = new ListNode(val%10);
//            node = node.next;
//            val/=10;
//        }
//        if (val!=0) {
//            node.next = new ListNode(val);
//        }
//        return temp;
//    }
    
    
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int val=0;
//        ListNode node=new ListNode();
//        ListNode temp=node;
//        while(l1!=null || l2!=null || val!=0) {
//            val += (l1==null ? 0 : l1.val) + (l2==null ? 0 : l2.val);
//            l1 = l1==null ? l1 : l1.next;
//            l2 = l2==null ? l2 : l2.next;
//            node.next = new ListNode(val%10);
//            node = node.next;
//            val=val/10;
//        }
//        return temp.next;
//    }
    
    public static void main(String[] args) {
        AddTwoNumbers add = new AddTwoNumbers();
        ListNode lis1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode lis2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        add.addTwoNumbers(lis1, lis2);

//        ListNode lis1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode lis2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
//        add.addTwoNumbers(lis1, lis2);

//        ListNode lis1 = new ListNode(9);
//        ListNode lis2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
//        add.addTwoNumbers(lis1, lis2);
    }
}
