/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.an.ordered.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class DesignAnOrderedStream {

    /**
     * @param args the command line arguments
     */
    String[] list;
    int i=0;
    int j=0;
    List<String> ret;
    public DesignAnOrderedStream(int n) {
        this.list=new String[n];
    }
    
    public List<String> insert(int idKey, String value) {
        this.list[--idKey] = value;
        j=i;
        ret=new ArrayList<>();
        while(j<this.list.length && list[j]!=null) {
            ret.add(list[j++]);            
        }
        i=j;
        return ret;
    }
    
    public static void main(String[] args) {
        DesignAnOrderedStream d=new DesignAnOrderedStream(5);
        System.out.println(d.insert(3, "ccccc"));
        System.out.println(d.insert(1, "aaaaa"));
        System.out.println(d.insert(2, "bbbbb"));
        System.out.println(d.insert(5, "eeeee"));
        System.out.println(d.insert(4, "ddddd"));
    }
}
