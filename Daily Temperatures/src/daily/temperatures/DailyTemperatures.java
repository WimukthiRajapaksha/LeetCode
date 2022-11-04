/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daily.temperatures;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class DailyTemperatures {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------------NOT OPTIMAL-----------------------
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] arr=new int[temperatures.length];
//        Stack<int[]> stack=new Stack<>();
//        stack.push(new int[]{temperatures[0], 0});
//        int i=1;
//        while(i<temperatures.length) {
//            if(!stack.isEmpty() && stack.peek()[0]<temperatures[i]) {
//                int[] t=stack.pop();
//                arr[t[1]]=i-t[1];
//            } else {
//                stack.push(new int[]{temperatures[i], i});
//                i++;
//            }
//        }
//        return arr;
//    }
    
    
    
//    ----------------ALTERNATE TO STACK; AN ARRAY IS USED-------------------
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] arr=new int[temperatures.length];
//        int[][] stack=new int[temperatures.length][2];
//        stack[0] = new int[]{temperatures[0], 0};
//        int i=1;
//        int j=0;
//        while(i<temperatures.length) {
//            if(j!=-1 && stack[j][0]<temperatures[i]) {
//                int[] t=stack[j];
//                arr[t[1]]=i-t[1];
//                j--;
//            } else {
//                stack[++j]=new int[]{temperatures[i], i};
//                i++;
//            }
//        }
//        return arr;
//    }
    
    
    
//    -----------------------OPTIMAL -> O(N), O(N)--------------------
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] arr=new int[temperatures.length];
//        Stack<Integer> stack=new Stack<>();
//        int i=0;
//        while(i<temperatures.length) {
//            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]) {
//                int temp=stack.pop();
//                arr[temp]=i-temp;
//            }
//            stack.push(i);
//            i++;
//        }
//        return arr;
//    }
    
    
//    ------------------------OPTIMAL -> BEST -> O(N), O(1)---------------------------
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr=new int[temperatures.length];
        int hottest=0;
        for(int i=temperatures.length-1; i>=0; i--) {
            if(temperatures[i]>=hottest) {
                hottest=temperatures[i];
                continue;
            }
//            System.out.print(i+" -> ");
            int days=1;
            while(temperatures[i]>=temperatures[i+days]) {
//                System.out.print(i+" "+days+" ");
                days+=arr[i+days];
            }
//            System.out.println();
            arr[i]=days;
        }
        return arr;
    }
    
    public static void main(String[] args) {
        DailyTemperatures d=new DailyTemperatures();
//        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
//        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{30,40,50,60})));
//        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{30,60,90})));
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{10,9,8,8,9,10,9,8,10,11,5})));
    }
}
