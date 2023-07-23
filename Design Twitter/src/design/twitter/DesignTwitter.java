/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */


//-------------------OPTIMAL -> BEAUTIFUL----------------------
class Twitter {
    class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next=null;
        }

        @Override
        public String toString() {
            return "Tweet{" + "id=" + id + ", time=" + time + ", next=" + next + '}';
        }
    }
    
    class User {
        public int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            this.followed.add(id);
            this.head = null;
        }
        
        public void follow(int id) {
            followed.add(id);
        }
        
        public void unfollow(int id) {
            followed.remove(id);
        }
        
        public void tweet(int id) {
            Tweet nt=new Tweet(id, timeStamp++);
            nt.next=head;
            head=nt;
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", followed=" + followed + ", head=" + head + '}';
        }
    }

    Map<Integer, User> userMap;
    int timeStamp;
    
    public Twitter() {
        userMap=new HashMap<>();
        timeStamp=0;
    }
    
//    ----------------------O(1)------------------
    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).tweet(tweetId);
        System.out.println(userMap);
    }
    
//    ----------------------O(KLOG K)------------------
    public List<Integer> getNewsFeed(int userId) {
        System.out.println(userMap);
        List<Integer> list=new LinkedList<>();
        if(!userMap.containsKey(userId)) return list;
        Set<Integer> set=userMap.get(userId).followed;
        System.out.println("\t"+set);
        Queue<Tweet> queue=new PriorityQueue<>((t1,t2)->Integer.compare(t2.time, t1.time));
        for(int s: set) {
            Tweet t=userMap.get(s).head;
            if(t!=null) queue.offer(t);
        }
        int n=0;
        while(!queue.isEmpty() && n<10) {
            Tweet t=queue.poll();
            list.add(t.id);
            n++;
            if(t.next!=null) {
                queue.offer(t.next);
            }
        }
        return list;
    }
    
    
//    ----------------------O(1)---------------------
    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
        System.out.println(userMap);
    }
    
//    ----------------------O(1)---------------------
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}



//-------------------ALTERNATE -> NOT BEAUTIFUL----------------------
//class Twitter {
//    Map<Integer, List<int[]>> map;
//    Map<Integer, Set<Integer>> follow;
//    int count=0;
//
//    public Twitter() {
//        map=new HashMap<>();
//        follow=new HashMap<>();
//    }
//    
//    public void postTweet(int userId, int tweetId) {
//        if(!map.containsKey(userId)) {
//            map.put(userId, new ArrayList<>());
//        }
//        map.get(userId).add(new int[]{count++, tweetId});
//    }
//    
//    public List<Integer> getNewsFeed(int userId) {
//        Queue<int[]> pq=new PriorityQueue<>((p1,p2)->Integer.compare(p2[0], p1[0]));
//        if(map.get(userId)!=null) {
//            pq.addAll(map.get(userId));
////            for(int i=map.get(userId).size()-1; i>=Math.max(0, map.get(userId).size()-11); i--) {
////                pq.offer(map.get(userId).get(i));
////            }
//        }
//        int count=0;
//        if(follow.get(userId)!=null) {
//            for(int i: follow.get(userId)) {
//                if(map.get(i)==null) continue;
//                for(int j=map.get(i).size()-1; j>=Math.max(0, map.get(i).size()-11); j--) {
//                    pq.offer(map.get(i).get(j));
//                }
//            }
//        }
//        List<Integer> ret=new ArrayList<>();
//        while(ret.size()<10 && !pq.isEmpty()) {
//            ret.add(pq.poll()[1]);
//        }
//        return ret;
//    }
//    
//    public void follow(int followerId, int followeeId) {
//        if(!follow.containsKey(followerId)) {
//            follow.put(followerId, new HashSet<>());
//        }
//        follow.get(followerId).add(followeeId);
//    }
//    
//    public void unfollow(int followerId, int followeeId) {
//        if(follow.containsKey(followerId)) {
//            follow.get(followerId).remove(followeeId);
//        }
//    }
//}

public class DesignTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Twitter t=new Twitter();
//        t.postTweet(1, 5);
//        System.out.println(t.getNewsFeed(1));
//        t.follow(1, 2);
//        t.postTweet(2, 6);
//        System.out.println(t.getNewsFeed(1));
//        t.unfollow(1, 2);
//        System.out.println(t.getNewsFeed(1));

        Twitter t=new Twitter();
        t.postTweet(1, 5);
        t.follow(1, 2);
        t.follow(2, 1);
//        System.out.println(t.getNewsFeed(1)+"-------");
        System.out.println(t.getNewsFeed(2)+"-------");
        t.postTweet(2, 6);
        System.out.println(t.getNewsFeed(1)+"-------");
        System.out.println(t.getNewsFeed(2)+"-------");
        t.unfollow(2, 1);
        System.out.println(t.getNewsFeed(1)+"-------");
        System.out.println(t.getNewsFeed(2)+"-------");
        t.unfollow(1, 2);
        System.out.println(t.getNewsFeed(1)+"-------");
        System.out.println(t.getNewsFeed(2)+"-------");
    }
}


//["getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed"]
//[[1],[2],[1,2],[1],[2]]