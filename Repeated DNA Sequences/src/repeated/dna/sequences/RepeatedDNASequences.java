/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repeated.dna.sequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class RepeatedDNASequences {

    /**
     * @param args the command line arguments
     */
    
    
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list=new ArrayList<>();
        if(s.length()<=10) return list;
        Map<Integer, Boolean> map=new HashMap<>();
        int val=0;
        for(int i=0; i<s.length(); i++) {
            val=((val<<2) | ((s.charAt(i)-'A'+1)%5)) & 0xfffff;
            if(i<9) {
                continue;
            }
            if(map.containsKey(val) && !map.get(val)) {
                list.add(s.substring(i-9, i+1));
                map.put(val, true);
            } else if(!map.containsKey(val)) {
                map.put(val, false);
            }
        }
        return list;
    }
    
    
//    public List<String> findRepeatedDnaSequences(String s) {
//        List<String> list=new ArrayList<>();
//        if(s.length()<=10) return list;
//        Map<String, Boolean> map=new HashMap<>();
//        for(int i=0; i<s.length()-9; i++) {
//            String sub=s.substring(i, i+10);
//            if(map.containsKey(sub) && !map.get(sub)) {
//                list.add(sub);
//                map.put(sub, true);
//            } else if(!map.containsKey(sub)) {
//                map.put(sub, false);
//            }
//        }
//        return list;
//    }
    
    public static void main(String[] args) {
        RepeatedDNASequences r=new RepeatedDNASequences();
        System.out.println(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(r.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        System.out.println(r.findRepeatedDnaSequences("AAAAAAAAAAA"));
        System.out.println(r.findRepeatedDnaSequences("TGCTCCTGTCACAACTTCTTTACCAGCCTGTTTTTCTAGAGTCGGCTCAAAACCTGCCTTTATGCGCAGCTGTCCACGAGAATTTCATGTTATCGAGGACCGCGATATACCCAATCGCGCGCCCCAGAAAAAAGAGTCTTACCAGATGTATACGGTGACGACCCAGTGGGTAAGACCGCTCTGCTCAGCGACCCGTCCATACCCACAGTCAGCCATGTGTGACATATCAGCGTGCATTCTTGATCTGTATGGGTGCGCTGCCCCCGCACTTGATGGGGTATGTGATGACTCCGCTCGGTAAGCAAGACCCTGGGGGTTCGGACGTAGGGTATACCCGAACTTCACGTATGCGGACACCAACGCACGTGCCAATTTATCTAACGTATGTCTCCATGCCGCCCAGAAGGTTAAAGTGGACCGCCGTTCGTATACTGTTTCTGCAATTGTGTGCGGCAGCACCAGGTAGAGAGCATTCTATTTCGCTAGCTAGTAAATCTACTTCACCGAGTCTGGAAGCTCCAATCGCTGTTTACAAACTTTTTGCCCCTGCGTGGGTCAGGCCATGTCCCGTTCCCGAGGATTCTAGCACTGACCTAGCCCTATATCACGAGCCGGGTTTTCTTAAAATAGAGATCGGGACGTTAAGGTCTTATGAACGGCTTCAGCTATCTTCCGCTTACCAACTGAGCCGAACTATCTCCGGGTGTTACATGGATCCTAAAATGCTCTCCAATTTTGCCCCTGCATGGTATTTCTCTTGAGACTACTGGATCTACCTGGGTTGTGCATGTTTCGTGTCTCTTCCGACGTTCGACAATTGGGGGCGACGCTTTAAGTTCTACTACGGTGAGATGCACATCCCACGGACGCCCTTTTCCTTTGGCTCTTCCTACGTTCGCGAGCGGTCCTGTAGGACAGTTGCTTTATGCCAACTTTTACGAGGGTGGAATACAGTATCGCCATGACACTCTGAAAAAGGATGGAAGACCTGAGATTCACC"));
    }
}
