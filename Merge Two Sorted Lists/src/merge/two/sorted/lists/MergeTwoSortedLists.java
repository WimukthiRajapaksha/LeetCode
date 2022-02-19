/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merge.two.sorted.lists;

/**
 *
 * @author wimukthirajapaksha
 */
public class MergeTwoSortedLists {

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
    
//        ----------------------- ITERATIVE -----------------------
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ret;
        if(list1==null) {
            return list2;
        } else if (list2==null) {
            return list1;
        } else if (list1.val<=list2.val) {
            ret = list1;
            list1=list1.next;
        } else {
            ret = list2;
            list2=list2.next;
        }
        
        ListNode temp = ret;
        while(list1 != null && list2 != null) {
            if (list1.val<list2.val) {
                ret.next=list1;
                list1=list1.next;
            } else {
                ret.next=list2;
                list2=list2.next;
            }
            ret = ret.next;
        }
        if (list1!=null) {
            ret.next = list1;
        } else {
            ret.next = list2;
        }
        return temp;
        
        
//        ----------------------- ALTERNATES -> RECURSIVE -----------------------
//        if (list1==null) {
//            return list2;
//        } else if (list2==null) {
//            return list1;
//        } else {
//            if (list1.val<=list2.val) {
//                list1.next = mergeTwoLists(list1.next, list2);
//                return list1;
//            } else {
//                list2.next = mergeTwoLists(list1, list2.next);
//                return list2;
//            }
//        }
    }
    
    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        
//        m.mergeTwoLists(list1, list2);
    }
}
