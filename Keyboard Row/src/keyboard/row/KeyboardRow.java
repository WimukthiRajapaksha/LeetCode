/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.row;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author wimukthirajapaksha
 */
public class KeyboardRow {

    /**
     * @param args the command line arguments
     */
    
    public String[] findWords(String[] words) {
        String[] arr=new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> list=new ArrayList<>();
        for(String ss: words) {
            int place=0;
            String s=ss.toLowerCase();
            if(arr[1].indexOf(s.charAt(0))>=0) {
                place=1;
            } else if(arr[2].indexOf(s.charAt(0))>=0) {
                place=2;
            }
            list.add(ss);
            for(char c: s.toCharArray()) {
                if(arr[place].indexOf(c)<0) {
                    list.remove(list.size()-1);
                    break;
                }
            }
        }
        System.out.println(list);
        return list.toArray(new String[list.size()]);
    }
    
    
//    -------------------------ALTERNATE -> NOT OPTIMAL-------------------------
//    public String[] findWords(String[] words) {
//        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
//    }
    
    
//    -------------------------ALTERNATE -> OPTIMAL-----------------------------
//    public String[] findWords(String[] words) {
//        String[] arr=new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
//        List<String> list=new ArrayList<>();
//        for(String ss: words) {
//            int place=0;
//            String s=ss.toLowerCase();
//            if(arr[1].indexOf(s.charAt(0))>=0) {
//                place=1;
//            } else if(arr[2].indexOf(s.charAt(0))>=0) {
//                place=2;
//            }
//            if(checkAllExistance(s, arr[place])) {
//                list.add(ss);
//            }
//        }
//        System.out.println(list);
//        return list.toArray(new String[list.size()]);
//    }
//    
//    
//    private boolean checkAllExistance(String checking, String sta) {
//        for(char c: checking.toLowerCase().toCharArray()) {
//            if(sta.indexOf(c)<0) return false;
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        KeyboardRow k=new KeyboardRow();
        k.findWords(new String[]{"Hello","Alaska","Dad","Peace"});
        k.findWords(new String[]{"omk"});
        k.findWords(new String[]{"adsdf","sfd"});
    }
    
}
