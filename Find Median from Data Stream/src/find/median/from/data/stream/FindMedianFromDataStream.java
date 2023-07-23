/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.median.from.data.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */

//------------------------OPTIMAL -> ADD - O(LOG N), FIND MEDIAN - O(1)------------
class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder()); 
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return maxHeap.size()>minHeap.size() ? maxHeap.peek() : (minHeap.peek()+maxHeap.peek())/2.0;
    }
}


//------------------------OPTIMAL -> ADD - O(LOG N), FIND MEDIAN - O(1)------------
//class MedianFinder {
//    PriorityQueue<Integer> minHeap;
//    PriorityQueue<Integer> maxHeap;
//    boolean isEven=true;
//    
//    public MedianFinder() {
//        minHeap=new PriorityQueue<>();
//        maxHeap=new PriorityQueue<>(Collections.reverseOrder()); 
//    }
//    
//    public void addNum(int num) {
//        if(isEven) {
//            minHeap.offer(num);
//            maxHeap.offer(minHeap.poll());
//        } else {
//            maxHeap.offer(num);
//            minHeap.offer(maxHeap.poll());
//        }
//        isEven = !isEven;
//    }
//    
//    public double findMedian() {
//        if((minHeap.size()+maxHeap.size())%2==0) {
//            System.out.println(minHeap.peek()+" -> "+maxHeap.peek());
//            return (minHeap.peek()+maxHeap.peek())/2.0;
//        } else {
//            if(minHeap.size()>maxHeap.size()) {
//                return minHeap.peek();
//            } else {
//                return maxHeap.peek();
//            }
//        }
//    }
//}


//------------------------OPTIMAL -> ADD - O(LOG N), FIND MEDIAN - O(1)------------
//class MedianFinder {
//    PriorityQueue<Integer> minHeap;
//    PriorityQueue<Integer> maxHeap;
//    
//    public MedianFinder() {
//        minHeap=new PriorityQueue<>();
//        maxHeap=new PriorityQueue<>(Collections.reverseOrder()); 
//    }
//    
//    public void addNum(int num) {
//        if(maxHeap.isEmpty()) {
//            maxHeap.add(num);
//        } else if(maxHeap.peek()>=num) {
//            maxHeap.offer(num);
//            if(maxHeap.size()>minHeap.size()+1) {
//                int t=maxHeap.poll();
//                minHeap.offer(t);
//            }
//        } else {
//            minHeap.offer(num);
//            if(minHeap.size()>maxHeap.size()+1) {
//                int t=minHeap.poll();
//                maxHeap.offer(t);
//            }
//        }
//    }
//    
//    public double findMedian() {
//        if((minHeap.size()+maxHeap.size())%2==0) {
//            System.out.println(minHeap.peek()+" -> "+maxHeap.peek());
//            return (minHeap.peek()+maxHeap.peek())/2.0;
//        } else {
//            if(minHeap.size()>maxHeap.size()) {
//                return minHeap.peek();
//            } else {
//                return maxHeap.peek();
//            }
//        }
//    }
//}


//------------------------OPTIMAL -> ADD - O(LOG N), FIND MEDIAN - O(1)------------
//class MedianFinder {
//    PriorityQueue<Integer> minHeap;
//    PriorityQueue<Integer> maxHeap;
//    
//    public MedianFinder() {
//        minHeap=new PriorityQueue<>();
//        maxHeap=new PriorityQueue<>((o1,o2)->Integer.compare(o2, o1)); 
//    }
//    
//    public void addNum(int num) {
//        if(maxHeap.isEmpty()) {
//            maxHeap.add(num);
//        } else if(maxHeap.peek()>=num) {
//            maxHeap.offer(num);
//            if(maxHeap.size()>minHeap.size()+1) {
//                int t=maxHeap.poll();
//                minHeap.offer(t);
//            }
//        } else {
//            minHeap.offer(num);
//            if(minHeap.size()>maxHeap.size()+1) {
//                int t=minHeap.poll();
//                maxHeap.offer(t);
//            }
//        }
//    }
//    
//    public double findMedian() {
//        if((minHeap.size()+maxHeap.size())%2==0) {
//            System.out.println(minHeap.peek()+" -> "+maxHeap.peek());
//            return (minHeap.peek()+maxHeap.peek())/2.0;
//        } else {
//            if(minHeap.size()>maxHeap.size()) {
//                return minHeap.peek();
//            } else {
//                return maxHeap.peek();
//            }
//        }
//    }
//}

public class FindMedianFromDataStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MedianFinder m=new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
        m.addNum(4);
        System.out.println(m.findMedian());
    }
}
