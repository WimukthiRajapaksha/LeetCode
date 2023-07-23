/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroid.collision;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class AsteroidCollision {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------OPTIMAL -> O(N), O(N)--------------
//    public int[] asteroidCollision(int[] asteroids) {
//        Stack<Integer> stack=new Stack<>();
//        for(int i: asteroids) {
//            if(i<0) {
//                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<-i) {
//                    stack.pop();
//                }
//                if(stack.isEmpty() || stack.peek()<0) stack.push(i);
//                else if(stack.peek()==-i) stack.pop();
//            } else {
//                stack.push(i);
//            }
//        }
//        int[] arr=new int[stack.size()];
//        int j=0;
//        for(int i: stack) {
//            arr[j++]=i;
//        }
//        return arr;
//    }
    
    
//    ----------OPTIMAL -> O(N), O(N)--------------
//    public int[] asteroidCollision(int[] asteroids) {
//        Stack<Integer> stack=new Stack<>();
//        for(int i: asteroids) {
//            while(!stack.isEmpty() && stack.peek()>0 && i<0 && stack.peek()<-i) {
//                stack.pop();
//            }
//            if(stack.isEmpty() || (stack.peek()<0 && i<0) || (stack.peek()>0 && i>0) || (stack.peek()<0 && i>0)) stack.push(i);
//            else if(stack.peek()==-i) stack.pop();
//        }
//        int[] arr=new int[stack.size()];
//        int j=0;
//        for(int i: stack) {
//            arr[j++]=i;
//        }
//        return arr;
//    }
    
    
    
//    ----------OPTIMAL -> O(N), O(N)--------------
//    public int[] asteroidCollision(int[] asteroids) {
//        int i=1;
//        for(int j=1; j<asteroids.length; j++) {
//            if((asteroids[j]<0 && asteroids[i-1]>0)) {
//                while(i>0 && asteroids[i-1]>0 && asteroids[i-1]<-asteroids[j]) {
//                    i--;
//                }
//                if(i==0 || asteroids[i-1]<0) asteroids[i++]=asteroids[j];
//                else if(asteroids[i-1]==-asteroids[j]) i--;
//            } else {
//                asteroids[i++]=asteroids[j];
//            }
//        }
//        int[] ret=new int[i];
//        for(int j=0; j<i; j++) {
//            ret[j]=asteroids[j];
//        }
//        return ret;
//    }
    
    
    
    
//    ----------OPTIMAL -> BREAUTIFUL -> O(N), O(N)--------------
//    public int[] asteroidCollision(int[] asteroids) {
//        Stack<Integer> stack=new Stack<>();
//        for(int i: asteroids) {
//            while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<-i) {
//                stack.pop();
//            }
//            if(stack.isEmpty() || i>0 || stack.peek()<0) stack.push(i);
//            else if(stack.peek()==-i) stack.pop();
//        }
//        int[] arr=new int[stack.size()];
//        int j=0;
//        for(int i: stack) {
//            arr[j++]=i;
//        }
//        return arr;
//    }
    
    
    
//    ----------OPTIMAL -> BREAUTIFUL -> O(N), O(N)--------------
    public int[] asteroidCollision(int[] asteroids) {
        int i=1;
        for(int j=1; j<asteroids.length; j++) {
            while(i>0 && asteroids[i-1]>0 && asteroids[i-1]<-asteroids[j]) {
                i--;
            }
            if(i==0 || asteroids[i-1]<0 || asteroids[j]>0) asteroids[i++]=asteroids[j];
            else if(asteroids[i-1]==-asteroids[j]) i--;
        }
        int[] ret=new int[i];
        for(int j=0; j<i; j++) {
            ret[j]=asteroids[j];
        }
        return ret;
    }
    
    
    public static void main(String[] args) {
        AsteroidCollision a=new AsteroidCollision();
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{8,-8})));
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{10,2,-5})));
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{-1,-2,-3,-4})));
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{-2,-2,1,-2})));
    }
}
