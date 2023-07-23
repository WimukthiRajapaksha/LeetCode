/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked.list.random.node;

import java.util.Random;

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
}


class Solution {
    ListNode head;
    Random rand;

    public Solution(ListNode head) { // ---------O(1), O(1)---------------
        this.head=head;
        this.rand=new Random();
    }
    
    public int getRandom() { // ---------O(N), O(1)---------------
        ListNode curr=head;
        int count=0;
        int choosen=0;
        while(curr!=null) {
            int ran=rand.nextInt(count+1);
            if(ran==count) {
                choosen=curr.val;
            }
            count++;
            curr=curr.next;
        }
        return choosen;
    }
}


//class Solution {
//    ListNode head;
//
//    public Solution(ListNode head) { // ---------O(1), O(1)---------------
//        this.head=head;
//    }
//    
//    public int getRandom() { // ---------O(N), O(1)---------------
//        ListNode curr=head;
//        int scope=1;
//        int choosen=0;
//        while(curr!=null) {
//            if(Math.random()<(1.0/scope)) {
//                choosen=curr.val;
//            }
//            scope++;
//            curr=curr.next;
//        }
//        return choosen;
//    }
//}


//class Solution {
//    Random random;
//    ListNode head;
//    int size;
//
//    public Solution(ListNode head) { // ---------O(N), O(1)---------------
//        random=new Random();
//        this.head=head;
//        ListNode temp=head;
//        while(temp!=null) {
//            temp=temp.next;
//            this.size++;
//        }
//    }
//    
//    public int getRandom() { // ---------O(N), O(1)---------------
//        int val=this.random.nextInt(size);
//        ListNode temp=head;
//        while(val!=0) {
//            temp=temp.next;
//            val--;
//        }
//        return temp.val;
//    }
//}

public class LinkedListRandomNode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solution s=new Solution(new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
    }
}
