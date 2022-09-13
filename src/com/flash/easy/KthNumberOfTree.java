package com.flash.easy;

import com.flash.common.TreeNode;

import java.util.Arrays;
import java.util.List;

public class KthNumberOfTree {

    static int size = 0;
    static int solution(TreeNode root, int k){
        if(root == null){
            return -1;
        }
        int ret = solution(root.right, k);
        if(ret != -1){
            return ret;
        }
        size ++;
        if(size == k) {
            return root.val;
        }
        ret = solution(root.left, k);
        if(ret != -1){
            return ret;
        }
        return -1;
    }


    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 1, 4, null, 2});
        System.out.println(solution(tree, 2));
    }

}
