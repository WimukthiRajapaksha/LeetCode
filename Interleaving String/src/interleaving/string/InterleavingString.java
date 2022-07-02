/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interleaving.string;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class InterleavingString {

    /**
     * @param args the command line arguments
     */
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        boolean[] visited=new boolean[s2.length()+1];
        for(int i=0; i<s1.length()+1; i++) {
            for(int j=0; j<s2.length()+1; j++) {
                if(i==0 && j==0) visited[j]=true;
                else if(i==0) visited[j]=visited[j-1] && s2.charAt(j-1)==s3.charAt(i+j-1);
                else if(j==0) visited[j]=visited[j] && s1.charAt(i-1)==s3.charAt(i+j-1);
                else visited[j]=((visited[j] && s1.charAt(i-1)==s3.charAt(i+j-1)) || (visited[j-1] && s2.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }
        return visited[s2.length()];
    }
    
    
    
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length()+s2.length()!=s3.length()) return false;
//        boolean[][] visited=new boolean[s1.length()+1][s2.length()+1];
//        for(int i=0; i<s1.length()+1; i++) {
//            for(int j=0; j<s2.length()+1; j++) {
//                if(i==0 && j==0) visited[i][j]=true;
//                else if(i==0) visited[i][j]=visited[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1);
//                else if(j==0) visited[i][j]=visited[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1);
//                else visited[i][j]=((visited[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)) || (visited[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1)));
//            }
//        }
//        return visited[s1.length()][s2.length()];
//    }
    
    
    
    
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length()+s2.length()!=s3.length()) return false;
//        Boolean[][] visited=new Boolean[s1.length()+1][s2.length()+1];
//        return dp(visited, s1, s2, s3, 0, 0, 0);
//    }
//    
//    private boolean dp(Boolean[][] visited, String s1, String s2, String s3, int i, int j, int k) {
//        if(i==s1.length() && j==s2.length() && k==s3.length()) return true;
//        if(visited[i][j]!=null) return visited[i][j];
//        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)) {
//            if(dp(visited, s1, s2, s3, i+1, j, k+1)) {
//                visited[i][j]=true;
//                return true;
//            }
//        }
//        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)) {
//            if(dp(visited, s1, s2, s3, i, j+1, k+1)) {
//                visited[i][j]=true;
//                return true;
//            }
//        }
//        visited[i][j]=false;
//        return false;
//    }
    
    
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length()+s2.length()!=s3.length()) return false;
//        Map<String, Boolean> map = new HashMap<>();
//        return canGenerate(s1, s2, s3, 0, 0, 0, map);
//    }
//    
//    private boolean canGenerate(String s1, String s2, String s3, int i, int j, int k, Map<String, Boolean> map) {
//        if(k==s3.length()) {
//            if(i==s1.length() && j==s2.length()) return true;
//            return false;
//        }
//        StringBuffer sb=new StringBuffer();
//        sb.append(i).append("*").append(j);
//        if(map.containsKey(sb.toString())) return map.get(sb.toString());
//        boolean can=false;
//        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)) {
//            can |= canGenerate(s1, s2, s3, i+1, j, k+1, map);
//        }
//        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)) {
//            can |= canGenerate(s1, s2, s3, i, j+1, k+1, map);
//        }
//        map.put(sb.toString(), can);
//        return can;
//    }
    
    public static void main(String[] args) {
        InterleavingString i=new InterleavingString();
        System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
//        System.out.println(i.isInterleave("", "", ""));
        System.out.println(i.isInterleave("abababababababababababababababababababababababababababababababababababababababababababababababababbb", "babababababababababababababababababababababababababababababababababababababababababababababababaaaba", "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb"));
    }
}
