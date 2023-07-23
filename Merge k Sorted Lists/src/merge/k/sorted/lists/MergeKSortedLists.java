/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merge.k.sorted.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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

public class MergeKSortedLists {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------------OPTIMAL -> O(N* log k)/ O(nk*log k, O(1)-----------
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        return mergeKLists(lists, 0, lists.length-1);
    }
    
    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if(start==end) {
            return lists[start];
        }
        int mid=start+(end-start)/2;
        ListNode left=mergeKLists(lists, start, mid);
        ListNode right=mergeKLists(lists, mid+1, end);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode ret=head;
        while(l1!=null && l2!=null) {
            if(l1.val<=l2.val) {
                head.next=l1;
                l1=l1.next;
            } else {
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        if(l1!=null) {
            head.next=l1;
        } else {
            head.next=l2;
        }
        return ret.next;
    }
    
    
    
//    ----------------OPTIMAL -> O(N* log k)/ O(nk*log k, O(k)-----------
//    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<ListNode> pq=new PriorityQueue<>((o1, o2)-> Integer.compare(o1.val, o2.val));
//        ListNode head=new ListNode();
//        for(ListNode n: lists) {
//            if(n!=null) pq.offer(n);
//        }
//        ListNode temp=head;
//        while(!pq.isEmpty()) {
//            ListNode ele = pq.poll();
//            temp.next=ele;
//            temp=temp.next;
//            if(ele.next!=null) pq.offer(ele.next);
//        }
//        return head.next;
//    }
    
    
    
//    ----------------NOT OPTIMAL -> O(N* log N), O(N)-----------
//    public ListNode mergeKLists(ListNode[] lists) {
//        List<ListNode> list=new ArrayList<>();
//        for(ListNode l: lists) {
//            while(l!=null) {
//                list.add(l);
//                l=l.next;
//            }
//        }
//        list.sort((l1, l2)-> Integer.compare(l1.val, l2.val));
//        ListNode head=new ListNode();
//        ListNode ret=head;
//        for(ListNode n: list) {
//            head.next=n;
//            head=head.next;
//        }
//        return ret.next;
//    }
    
    
    
//    ----------------NOT OPTIMAL -> O(nk*log nk), O(1)-----------
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length==0) return null;
//        if(lists.length==1) return lists[0];
//        ListNode head=new ListNode(-100000);
//        ListNode ret=head;
//        head.next=lists[0];
//        for(int i=1; i<lists.length; i++) {
//            ListNode temp=lists[i];
//            while(temp!=null) {
//                ListNode next=temp.next;
//                addNode(head, null, temp);
//                head=temp;
//                temp=next;
//            }
//            head=ret;
//        }
//        return ret.next;
//    }
//    
//    private void addNode(ListNode head, ListNode tail, ListNode temp) {
//        if(head==tail || head.next==tail) {
//            ListNode next=head.next;
//            head.next=temp;
//            temp.next=next;
//            return;
//        }
//        ListNode slow=head;
//        ListNode fast=head;
//        while(fast!=tail && fast.next!=tail) {
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        if(slow.val<temp.val) {
//            addNode(slow, tail, temp);
//        } else {
//            addNode(head, slow, temp);
//        }
//    }
    
    
//    ----------------NOT OPTIMAL -> O(nk), O(1)-----------
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length==0) return null;
//        if(lists.length==1) return lists[0];
//        ListNode head=new ListNode(-100000);
//        ListNode temp=head;
//        while(true) {
//            boolean allEmpty=true;
//            int minIndex=-1;
//            for(int i=0; i<lists.length; i++) {
//                if(lists[i]!=null) {
//                    allEmpty=false;
//                    if(minIndex==-1) {
//                        minIndex=i;
//                    } else if(lists[minIndex].val>lists[i].val) {
//                        minIndex=i;
//                    }
//                }
//                
//            }
//            if(allEmpty) return head.next;
//            ListNode next=lists[minIndex].next;
//            temp.next=lists[minIndex];
//            temp=temp.next;
//            lists[minIndex]=next;
//        }
//    }
    
    private void print(ListNode n) {
        if(n==null) return;
        System.out.print(n.val+" ");
        print(n.next);
    }
    
    public static void main(String[] args) {
        MergeKSortedLists m=new MergeKSortedLists();
        ListNode n=m.mergeKLists(new ListNode[]{
            new ListNode(1, new ListNode(4, new ListNode(5))),
            new ListNode(1, new ListNode(3, new ListNode(4))),
            new ListNode(2, new ListNode(6)),
            new ListNode(5, new ListNode(10, new ListNode(15, new ListNode(20)))),
            new ListNode(6, new ListNode(12, new ListNode(18)))
        });
        m.print(n);
    }
}
