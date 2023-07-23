/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.underground.system;

import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author wimukthirajapaksha
 */


//  -----------------OPTIMAL -> O(N), O(N)----------------
//class UndergroundSystem {
//    Map<String, int[]> map;
//    int[] times;
//    String[] stations;
//    public UndergroundSystem() {
//        map=new HashMap<>();
//        times=new int[1000001];
//        stations=new String[1000001];
//    }
//    
//    public void checkIn(int id, String stationName, int t) {
//        times[id]=t;
//        stations[id]=stationName;
//    }
//    
//    public void checkOut(int id, String stationName, int t) {
//        StringBuffer sb=new StringBuffer(stations[id]);
//        sb.append("*").append(stationName);
//        if(!map.containsKey(sb.toString())) {
//            map.put(sb.toString(), new int[2]);
//        }
//        int[] val=map.get(sb.toString());
//        val[0]+=t-times[id];
//        val[1]++;
//        times[id]=0;
//    }
//    
//    public double getAverageTime(String startStation, String endStation) {
//        StringBuffer sb=new StringBuffer(startStation);
//        sb.append("*").append(endStation);
//        return map.get(sb.toString())[0]/(double)map.get(startStation+"*"+endStation)[1];
//    }
//}



//  -----------------OPTIMAL -> O(N), O(N)----------------
class UndergroundSystem {
    Map<String, Pair<Integer, Integer>> collections;
    Map<Integer, Pair<String, Integer>> stations;
    public UndergroundSystem() {
        collections=new HashMap<>();
        stations=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        stations.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> prev=stations.get(id);
        StringBuffer sb=new StringBuffer(prev.getKey());
        sb.append("*").append(stationName);
        Pair<Integer, Integer> already=collections.getOrDefault(sb.toString(), new Pair<>(0, 0));
        collections.put(sb.toString(), new Pair<>(already.getKey()+t-prev.getValue(), already.getValue()+1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        StringBuffer sb=new StringBuffer(startStation);
        sb.append("*").append(endStation);
        return collections.get(sb.toString()).getKey()/(double)collections.get(sb.toString()).getValue();
    }
}

public class DesignUndergroundSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UndergroundSystem u=new UndergroundSystem();
        u.checkIn(45, "Leyton",3);
        u.checkIn(32,"Paradise",8);
        u.checkIn(27,"Leyton",10);
        u.checkOut(45,"Waterloo",15);
        u.checkOut(27,"Waterloo",20);
        u.checkOut(32,"Cambridge",22);
        System.out.println(u.getAverageTime("Paradise","Cambridge"));
        System.out.println(u.getAverageTime("Leyton","Waterloo"));
        u.checkIn(10,"Leyton",24);
        System.out.println(u.getAverageTime("Leyton","Waterloo"));
        u.checkOut(10,"Waterloo",38);
        System.out.println(u.getAverageTime("Leyton","Waterloo"));
    }
}
