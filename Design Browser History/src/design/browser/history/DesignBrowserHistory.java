/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.browser.history;

/**
 *
 * @author wimukthirajapaksha
 */

class Node {
    String page;
    Node prev;
    Node next;

    public Node(String page, Node prev, Node next) {
        this.page = page;
        this.prev = prev;
        this.next = next;
    }

    public Node(String page) {
        this.page=page;
    }
    
    public Node addNode(Node node) {
        this.next=node;
        this.next.prev=this;
        return node;
    }
}

class BrowserHistory {
    Node head=new Node("");
    Node temp;

    public BrowserHistory(String homepage) {
        temp = head.addNode(new Node(homepage));
    }
    
    public void visit(String url) {
        this.temp=this.temp.addNode(new Node(url));
    }
    
//    -------------------OPTIMAL -> O(min(m,n)), O(1)------------------
    public String back(int steps) {
        while(steps>0 && !this.temp.prev.page.equals("")) {
            this.temp=this.temp.prev;
            steps--;
        }
        return this.temp.page;
    }
    
//    -------------------OPTIMAL -> O(min(m,n)), O(1)------------------
    public String forward(int steps) {
        while(temp.next!=null && steps>0) {
            temp=temp.next;
            steps--;
        }
        return temp.page;
    }
}

public class DesignBrowserHistory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BrowserHistory b=new BrowserHistory("leetcode.com");
        b.visit("google.com");
        b.visit("facebook.com");
        b.visit("youtube.com");
        System.out.println(b.back(1));
        System.out.println(b.back(1));
        System.out.println(b.forward(1));
        b.visit("linkedin.com");
        System.out.println(b.forward(2));
        System.out.println(b.back(2));
        System.out.println(b.back(7));
    }
}
