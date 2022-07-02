/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked.list.cycle.ii;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class LinkedListCycleII {

    /**
     * @param args the command line arguments
     */
    
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode detectCycle(ListNode head) {
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null) {
            s=s.next;
            f=f.next.next;
            if(s==f) {
                break;
            }
        }
        if(f==null || f.next==null) return null;
        s=head;
        while(s!=f) {
            s=s.next;
            f=f.next;
        }
        return s;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
