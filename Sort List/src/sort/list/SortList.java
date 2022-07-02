/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort.list;

/**
 *
 * @author wimukthirajapaksha
 */
public class SortList {

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
    
    public ListNode sortList(ListNode head) {
        ListNode dummy=new ListNode(0, head);
        int c=count(head);
        for(int i=1; i<c; i<<=1) {
            ListNode prev=dummy;
            ListNode curr=dummy.next;
            while(curr!=null) {
                ListNode left=curr;
                ListNode right=split(left, i);
                curr=split(right, i);
                prev=merge(left, right, prev);
            }
        }
        return dummy.next;
    }
    
    private ListNode merge(ListNode l, ListNode r, ListNode p) {
        while(l!=null && r!=null) {
            if(l.val<r.val) {
                p.next=l;
                l=l.next;
            } else {
                p.next=r;
                r=r.next;
            }
            p=p.next;
        }
        p.next=(l!=null) ? l : r;
        while(p.next!=null) p=p.next;
        return p;
    }
    
    private ListNode split(ListNode n, int i) {
        if(n==null) return n;
        for(int j=1; j<i && n.next!=null; j++) {
            n=n.next;
        }
        ListNode next=n.next;
        n.next=null;
        return next;
    }
    
    private int count(ListNode head) {
        int c=0;
        while(head!=null) {
            head=head.next;
            c++;
        }
        return c;
    }
    
    
//    ---------------------OPTIMAL -> O(1) SPACE COMPLEXITY---------------------
//    public ListNode sortList(ListNode head) {
//        ListNode dummy=new ListNode(0, head);
//        int c=count(head);
//        for(int i=1; i<c; i<<=1) {
//            ListNode prev=dummy;
//            ListNode curr=dummy.next;
//            while(curr!=null) {
//                ListNode left=curr;
//                ListNode right=split(left, i);
//                curr=split(right, i);
//                prev=merge(left, right, prev);
//            }
//        }
//        return dummy.next;
//    }
//    
//    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
//        while(left!=null && right!=null) {
//            if(left.val<right.val) {
//                prev.next=left;
//                left=left.next;
//            } else {
//                prev.next=right;
//                right=right.next;
//            }
//            prev=prev.next;
//        }
//        prev.next = (left!=null) ? left : right;
//        while(prev.next!=null) prev=prev.next;
//        return prev;
//    }
//    
//    private ListNode split(ListNode head, int steps) {
//        if(head==null) return head;
//        for(int i=1; i<steps && head.next!=null; i++) {
//            head=head.next;
//        }
//        ListNode right=head.next;
//        head.next=null;
//        return right;
//    }
//    
//    private int count(ListNode head) {
//        int c=0;
//        while(head!=null) {
//            head=head.next;
//            c++;
//        }
//        return c;
//    }
    
    
    
//    ---------------------OPTIMAL -> HARDER TO UNDERSTAND -> GIVEN SOLUTION -> O(1) SPACE COMPLEXITY---------------------
//    ListNode prevSubListTail=new ListNode();
//    ListNode nextSubList=new ListNode();
//    
//    public ListNode sortList(ListNode head) {
//        if(head==null || head.next==null) return head;
//        int count=getCount(head);
//        ListNode start=head;
//        ListNode dummyHead=new ListNode();
//        for(int i=1; i<count; i=i*2) {
//            prevSubListTail=dummyHead;
//            while(start!=null) {
//                if(start.next==null) { // to avoid passing null to split -> end would be null then causing error
//                    prevSubListTail.next=start;
//                    break;
//                }
//                ListNode mid=split(start, i);
//                merge(start, mid);
//                start=nextSubList;
//            }
//            start=dummyHead.next;
//        }
//        return dummyHead.next;
//    }
//    
//    private ListNode split(ListNode head, int size) {
//        ListNode midPrev=head;
//        ListNode end=head.next;
//        for(int i=1; i<size && (midPrev.next!=null || end.next!=null); i++) {
//            if(end.next!=null) {
//                end=(end.next.next!=null) ? end.next.next : end.next;
//            }
//            if(midPrev!=null) {
//                midPrev=midPrev.next;
//            }
//        }
//        ListNode mid=midPrev.next;
//        midPrev.next=null;
//        nextSubList=end.next;
//        end.next=null;
//        return mid;
//    }
//    
//    private void merge(ListNode h1, ListNode h2) {
//        ListNode dummy=new ListNode();
//        ListNode temp=dummy;
//        while(h1!=null && h2!=null) {
//            if(h1.val<h2.val) {
//                temp.next=h1;
//                h1=h1.next;
//            } else {
//                temp.next=h2;
//                h2=h2.next;
//            }
//            temp=temp.next;
//        }
//        temp.next = (h1!=null) ? h1 : h2;
//        while(temp.next!=null) {
//            temp=temp.next;
//        }
//        prevSubListTail.next=dummy.next;
//        prevSubListTail=temp;
//    }
//    
//    private int getCount(ListNode node) {
//        int c=0;
//        while(node!=null) {
//            node=node.next;
//            c++;
//        }
//        return c;
//    }
    
    
    
    
//    ---------------------OPTIMAL -> O(LOG N) SPACE COMPLEXITY---------------------
//    public ListNode sortList(ListNode head) {
//        if(head==null || head.next==null) return head;
//        ListNode slow=mid(head);
//        ListNode h1=sortList(head);
//        ListNode h2=sortList(slow);
//        return merge(h1, h2);
//    }
//    
//    private ListNode mid(ListNode head) {
//        ListNode pre=null;
//        while(head!=null && head.next!=null) {
//            pre=(pre==null) ? head : pre.next;
//            head=head.next.next;
//        }
//        ListNode ret=pre.next;
//        pre.next=null;
//        return ret;
//    }
//    
//    private ListNode merge(ListNode h1, ListNode h2) {
//        ListNode ret=new ListNode();
//        ListNode returnNode=ret;
//        while(h1!=null && h2!=null) {
//            if(h1.val<h2.val) {
//                ret.next=h1;
//                h1=h1.next;
//            } else {
//                ret.next=h2;
//                h2=h2.next;
//            }
//            ret=ret.next;
//        }
//        ret.next = (h1!=null) ? h1 : h2;
//        return returnNode.next;
//    }
    
    
    
//    ---------------------OPTIMAL -> O(LOG N) SPACE COMPLEXITY---------------------
//    public ListNode sortList(ListNode head) {
//        if(head==null || head.next==null) return head;
//        ListNode slow=head;
//        ListNode fast=head;
//        ListNode pre=null;
//        while(fast!=null && fast.next!=null) {
//            pre=slow;
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        pre.next=null;
//        ListNode h1=sortList(head);
//        ListNode h2=sortList(slow);
//        return merge(h1, h2);
//    }
//    
//    private ListNode merge(ListNode h1, ListNode h2) {
//        ListNode ret=new ListNode();
//        ListNode returnNode=ret;
//        while(h1!=null && h2!=null) {
//            if(h1.val<h2.val) {
//                ret.next=h1;
//                h1=h1.next;
//            } else {
//                ret.next=h2;
//                h2=h2.next;
//            }
//            ret=ret.next;
//        }
//        if(h1!=null) {
//            ret.next=h1;
//        } 
//        if(h2!=null){
//            ret.next=h2;
//        }
//        return returnNode.next;
//    }
    
    private void print(ListNode head) {
        if(head==null) return;
        System.out.print(head.val+" ");
        print(head.next);
    }
    
    public static void main(String[] args) {
        SortList s=new SortList();
        ListNode ret=s.sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        s.print(ret);
        System.out.println();
        ret=s.sortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0))))));
        s.print(ret);
    }
}
