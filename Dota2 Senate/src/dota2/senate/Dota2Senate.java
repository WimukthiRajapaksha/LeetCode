/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dota2.senate;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class Dota2Senate {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------OPTIMAL -> O(N), O(N)--------------
    public String predictPartyVictory(String senate) {
        Queue<Character> queue=new LinkedList<>();
        int rCount=0;
        int dCount=0;
        for(char c: senate.toCharArray()) {
            queue.offer(c);
            if(c=='R') rCount++;
            else dCount++;
        }
        int removeRCount=0;
        int removeDCount=0;
        while(rCount!=0 && dCount!=0) {
            char c=queue.poll();
            if(removeRCount>0 && c=='R') {
                removeRCount--;
                rCount--;
            } else if(removeDCount>0 && c=='D') {
                removeDCount--;
                dCount--;
            } else if(c=='R') {
                removeDCount++;
                queue.offer('R');
            } else if(c=='D') {
                removeRCount++;
                queue.offer('D');
            }
        }
        return queue.peek()=='R' ? "Radiant" : "Dire";
    }
    
    
    
//    ------------OPTIMAL -> O(N), O(N)--------------
//    public String predictPartyVictory(String senate) {
//        Queue<Integer> rQueue=new LinkedList<>();
//        Queue<Integer> dQueue=new LinkedList<>();
//        int n=senate.length();
//        for(int i=0; i<senate.length(); i++) {
//            if(senate.charAt(i)=='R') rQueue.offer(i);
//            else dQueue.offer(i);
//        }
//        while(!rQueue.isEmpty() && !dQueue.isEmpty()) {
//            int r=rQueue.poll();
//            int d=dQueue.poll();
//            if(r<d) rQueue.offer(n++);
//            else dQueue.offer(n++);
//        }
//        return rQueue.isEmpty() ? "Dire" : "Radiant";
//    }
    
    public static void main(String[] args) {
        Dota2Senate d=new Dota2Senate();
        System.out.println(d.predictPartyVictory("RD"));
        System.out.println(d.predictPartyVictory("RDD"));
        System.out.println(d.predictPartyVictory("RRDD"));
        System.out.println(d.predictPartyVictory("RRRDDD"));
        System.out.println(d.predictPartyVictory("DDDDDDDDD"));
        System.out.println(d.predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
}


//Radiant
//Dire
//Radiant
//Radiant
//Dire
