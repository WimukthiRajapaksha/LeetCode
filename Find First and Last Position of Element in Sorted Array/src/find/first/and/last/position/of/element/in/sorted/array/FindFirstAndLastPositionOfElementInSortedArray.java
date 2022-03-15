/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.first.and.last.position.of.element.in.sorted.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * @param args the command line arguments
     */
    
//    public int[] searchRange(int[] nums, int target) {
//        int first = bin(nums, target, true);
//        int second = bin(nums, target, false);
//        if(first==-1 || second==-1) return new int[]{-1, -1};
//        return new int[]{first, second};
//    }
//    
//    private int bin(int[] n, int t, boolean isFirst) {
//        int i=0;
//        int j=n.length-1;
//        int index=-1;
//        while(i<=j) {
//            int m=i+(j-i)/2;
//            if(n[m]==t) {
//                index=m;
//                if(isFirst) {
//                    j=m-1;
//                } else {
//                    i=m+1;
//                }
//            } else if (n[m]<t) {
//                i=m+1;
//            } else {
//                j=m-1;
//            }
//        }
//        return index;
//    }
    
    
    
//    public int[] searchRange(int[] nums, int target) {
//        int[] arr=new int[]{-1, -1};
//        bin(nums, 0, nums.length-1, target, arr);
//        System.out.println(arr[0]+" "+arr[1]);
//        return arr;
//    }
//    
//    private void bin(int[] n, int i, int j, int t, int[] a) {
//        if(i>j) return;
//        int m=(i+(j-i)/2);
//        if(n[m]==t) {
//            if(m>0 && n[m-1]==t) {
//                bin(n, i, m-1, t, a);
//            } else {
//                a[0]=m;
//            }
//            if(m<n.length-1 && n[m+1]==t) {
//                bin(n, m+1, j, t, a);
//            } else {
//                a[1]=m;
//            }
//        } else if(n[m]<t) {
//            bin(n, m+1, j, t, a);
//        } else {
//            bin(n, i, m-1, t, a);
//        }
//    }
    
    
    
    
    public int[] searchRange(int[] nums, int target) {
        int first=findFirst(nums, target);
        int last=findLast(nums, target);
        return new int[]{first, last};
    }
    
    private int findFirst(int[] n, int t) {
        int index=-1;
        int i=0;
        int j=n.length-1;
        while(i<=j) {
            int m=i+(j-i)/2;
            if(n[m]>=t) {
                j=m-1;
            } else {
                i=m+1;
            }
            if(n[m]==t) index=m;
        }
        return index;
    }
    
    private int findLast(int[] n, int t) {
        int index=-1;
        int i=0;
        int j=n.length-1;
        while(i<=j) {
            int m=i+(j-i)/2;
            if(n[m]<=t) {
                i=m+1;
            } else {
                j=m-1;
            }
            if(n[m]==t) index=m;
        }
        return index;
    }
    
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray f=new FindFirstAndLastPositionOfElementInSortedArray();
        f.searchRange(new int[]{5,7,7,8,8,10}, 8);
        f.searchRange(new int[]{5,7,7,8,8,10}, 6);
        f.searchRange(new int[]{}, 0);
        f.searchRange(new int[]{1}, 1);
    }
}
