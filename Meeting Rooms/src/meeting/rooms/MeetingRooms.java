/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meeting.rooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */

//https://www.lintcode.com/problem/920/description

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start+" "+end;
    }
}

public class MeetingRooms {

    /**
     * @param args the command line arguments
     */
    
//    public boolean canAttendMeetings(List<Interval> intervals) {
//        Collections.sort(intervals, new Comparator<Interval>(){
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return Integer.compare(o1.end, o2.end);
//            }
//        });
//        for(int i=1; i<intervals.size(); i++) {
//            if(intervals.get(i-1).end>intervals.get(i).start) return false;
//        }
//        return true;
//    }
    
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (Interval i1, Interval i2) -> Integer.compare(i1.end, i2.end));
        for(int i=1; i<intervals.size(); i++) {
            if(intervals.get(i-1).end>intervals.get(i).start) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        MeetingRooms m=new MeetingRooms();
        List<Interval> list=new ArrayList<>();
        list.add(new Interval(0,30));
        list.add(new Interval(5,10));
        list.add(new Interval(15,20));
        System.out.println(m.canAttendMeetings(list));
    }
}
