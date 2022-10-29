/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package range.sum.query.mutable;

/**
 *
 * @author wimukthirajapaksha
 */

public class RangeSumQueryMutable {
//    ---------------OPTIMAL -> BINARY INDEXED TREE---------------
//    class NumArray {
//        int[] arr;
//        int[] nums;
//        public NumArray(int[] nums) {
//            this.nums = nums;
//            this.arr=new int[nums.length+1];
//            for(int i=0; i<nums.length; i++) {
//                updateValues(i, nums[i]);
//            }
//        }
//
//        public int nextIndex(int index) {
//            return index+(index&-index);
//        }
//
//        public int getParent(int index) {
//            return index-(index&-index);
//        }
//
//        private void updateValues(int index, int value) {
//            index++;
//            while(index<this.arr.length) {
//                this.arr[index] += value;
//                index = nextIndex(index);
//            }
//        }
//
//        public void update(int index, int val) {
//            int diff=val-this.nums[index];
//            this.nums[index]=val;
//            this.updateValues(index, diff);
//        }
//
//        public int sumRange(int left, int right) {
//            return this.getSum(right)-this.getSum(left-1);
//        }
//
//        public int getSum(int index) {
//            int sum=0;
//            index++;
//            while(index>0) {
//                sum+=this.arr[index];
//                index=getParent(index);
//            }
//            return sum;
//        }
//    }


//    ---------------OPTIMAL -> SEGMENT TREE---------------
    class NumArray {

        class SegmentTree {
            int start;
            int end;
            SegmentTree left;
            SegmentTree right;
            int sum;

            public SegmentTree(int start, int end) {
                this.start=start;
                this.end=end;
                this.left=null;
                this.right=null;
                this.sum=0;
            }
        }

        SegmentTree root;
        public NumArray(int[] nums) {
            root=buildTree(nums, 0, nums.length-1);
        }

        private SegmentTree buildTree(int[] nums, int l, int r) {
            if(l>r) {
                return null;
            }
            SegmentTree segmentTree=new SegmentTree(l, r);
            if(l==r) {
                segmentTree.sum=nums[l];
            } else {
                int m=l+(r-l)/2;
                segmentTree.left=buildTree(nums, l, m);
                segmentTree.right=buildTree(nums, m+1, r);
                segmentTree.sum=segmentTree.left.sum+segmentTree.right.sum;
            }
            return segmentTree;
        }

        public void update(int index, int val) {
            update(root, index, val);
        }

        private void update(SegmentTree node, int index, int val) {
            if(node.start==node.end) {
                node.sum = val;
            } else {
                int mid=node.start+(node.end-node.start)/2;
                if(index<=mid) {
                    update(node.left, index, val);
                } else {
                    update(node.right, index, val);
                }
                node.sum=node.left.sum+node.right.sum;
            }
        }

        public int sumRange(int left, int right) {
            return sumRange(root, left, right);
        }

        public int sumRange(SegmentTree node, int l, int r) {
            if(node.start==l && node.end==r) {
                return node.sum;
            } else {
                int m=node.start+(node.end-node.start)/2;
                if(r<=m) {
                    return sumRange(node.left, l, r);
                } else if(l>=m+1) {
                    return sumRange(node.right, l, r);
                } else {
                    return sumRange(node.left, l, m) + sumRange(node.right, m+1, r);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        RangeSumQueryMutable r=new RangeSumQueryMutable();
    }
}
