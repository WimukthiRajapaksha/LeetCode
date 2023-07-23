/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */

class NestedInteger {
    Integer value;
    List<NestedInteger> list;
    // Constructor initializes an empty nested list.
    public NestedInteger(){this.list=new ArrayList<>();};

    // Constructor initializes a single integer.
    public NestedInteger(int value){this.value=value;this.list=new ArrayList<>();};

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){return this.list.isEmpty();};

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){return this.value;};

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){this.value=value;};

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){this.list.add(ni);};

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){return this.list;};

    @Override
    public String toString() {
        if(isInteger()) return " "+this.getInteger();
        String s="";
        for(NestedInteger n: getList()) {
            s+=" "+n;
        }
        return s;
    }
}

public class MiniParser {

    /**
     * @param args the command line arguments
     */
    
//    -----------------OPTIMAL -> O(N), O(N)-------------------
    public NestedInteger deserialize(String s) {
        if(s.charAt(0)!='[') return new NestedInteger(Integer.valueOf(s));
        Stack<NestedInteger> stack=new Stack<>();
        NestedInteger nested=new NestedInteger();
        stack.push(nested);
        int left=0;
        for(int i=0; i<s.length(); i++) {
            char c=s.charAt(i);
            if(c=='[') {
                NestedInteger nestedInteger=new NestedInteger();
                stack.peek().add(nestedInteger);
                stack.push(nestedInteger);
                left=i+1;
            } else if(c==',' || c==']') {
                if(i>left) {
                    Integer val=Integer.valueOf(s.substring(left, i));
                    NestedInteger nestedInteger=new NestedInteger(val);
                    stack.peek().add(nestedInteger);
                }
                left=i+1;
                if(c==']') {
                    stack.pop();
                }
            }
        }
        return nested.getList().get(0);
    }
    
    public static void main(String[] args) {
        MiniParser m=new MiniParser();
//        System.out.println(m.deserialize("321"));
        System.out.println(m.deserialize("[123,[456,[789]]]"));
    }
}
