package com.flash.easy;

import com.flash.common.TreeNode;

public class TheDeepOfTree {

    static int solution(TreeNode root){
        if(root == null) return 0;
        int left = solution(root.left);
        int right = solution(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(solution(root));
    }

}
