/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meeting.rooms.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */

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

public class MeetingRoomsII {

    /**
     * @param args the command line arguments
     */
    
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty()) return 0;
        int[] start=new int[intervals.size()];
        int[] end=new int[intervals.size()];
        
        for(int i=0; i<intervals.size(); i++) {
            start[i]=intervals.get(i).start;
            end[i]=intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startP=0;
        int endP=0;
        int count=0;
        int maxCount=1;
        while(startP<start.length) {
            if(start[startP]<end[endP]) {
                startP++;
                count++;
            } else {
                endP++;
                count--;
            }
            maxCount=Math.max(maxCount, count);
        }
        return maxCount;
    }
    
    public static void main(String[] args) {
        MeetingRoomsII m=new MeetingRoomsII();
        List<Interval> list=new ArrayList<>();
        list.add(new Interval(0,30));
        list.add(new Interval(5,10));
        list.add(new Interval(15,20));
        System.out.println(m.minMeetingRooms(list));
    }
}
