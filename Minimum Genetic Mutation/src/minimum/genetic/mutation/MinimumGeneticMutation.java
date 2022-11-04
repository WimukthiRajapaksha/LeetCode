/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.genetic.mutation;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumGeneticMutation {

    /**
     * @param args the command line arguments
     */
    
    public int minMutation(String start, String end, String[] bank) {
        int st=convert(start);
        int en=convert(end);
        int[] arr=new int[bank.length];
        for(int i=0; i<bank.length; i++) {
            arr[i]=convert(bank[i]);
        }
        return dfs(st, en, arr);
    }
    
    private int dfs(int start, int end, int[] bank) {
        if(start==end) return 0;
        for(int i=0; i<16; i+=2) {
            if((((start>>>i)^(end>>>i))&3)==0) {
                continue;
            }
            int placeEnd=((end>>>i)&3)<<i;
            int placeStart=((start>>>(i+2))<<2)|placeEnd;
            (placeStart<<i)|(start&)
            int val=(start|(3<<i))&(placeEnd<<i);
//            int val=((start&3)<<i)^((end&3)<<i);
            if(val!=0) {
                int temp=start;
                temp=((temp>>>(i+2))<<2)|((end>>>(i))&3);
                int valu=dfs(temp, end, bank);
                if(valu!=-1) {
                    return valu+1;
                }
            }
        }
        return -1;
    }
    
    private int convert(String s) {
        int v=0;
        int shift=0;
        for(int j=s.length()-1; j>=0; j--) {
            v+= ((s.charAt(j)-'A'+1)%5)<<(shift);
            shift+=2;
        }
        return v;
    }
    
    public static void main(String[] args) {
        MinimumGeneticMutation m=new MinimumGeneticMutation();
        System.out.println(m.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
//        System.out.println();
        System.out.println(m.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
        
        System.out.println(m.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        
//        System.out.println(('a'-'a'+1)%5);
//        System.out.println(('c'-'a'+1)%5);
//        System.out.println(('t'-'a'+1)%5);
//        System.out.println(('g'-'a'+1)%5);
    }
}
