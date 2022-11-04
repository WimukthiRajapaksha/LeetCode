/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partition.labels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class PartitionLabels {

    /**
     * @param args the command line arguments
     */
    
    public List<Integer> partitionLabels(String s) {
        int[] index=new int[26];
        for(int i=0; i<s.length(); i++) {
            index[s.charAt(i)-'a']=i;
        }
        List<Integer> list=new ArrayList<>();
        int temp=0;
        int beg=-1;
        System.out.println(Arrays.toString(index));
        for(int i=0; i<s.length(); i++) {
            if(temp<index[s.charAt(i)-'a']) {
                temp=index[s.charAt(i)-'a'];
            }
            if(temp==i) {
                list.add(i-beg);
                beg=i;
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        PartitionLabels p=new PartitionLabels();
        System.out.println(p.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(p.partitionLabels("eccbbbbdec"));
    }
}
