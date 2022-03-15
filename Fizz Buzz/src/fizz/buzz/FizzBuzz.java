/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fizz.buzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class FizzBuzz {

    /**
     * @param args the command line arguments
     */
    
    public List<String> fizzBuzz(int n) {
        String[] list=new String[n];
        for(int i=1; i<=n; i++) {
            if(i%15==0) {
                list[i-1]="FizzBuzz";
            } else if (i%5==0) {
                list[i-1]="Buzz";
            } else if (i%3==0) {
                list[i-1]="Fizz";
            } else {
                list[i-1]=String.valueOf(i);
            }
        }
        return Arrays.asList(list);
    }
    
    public static void main(String[] args) {
        FizzBuzz f=new FizzBuzz();
        System.out.println(f.fizzBuzz(15));
    }
}
