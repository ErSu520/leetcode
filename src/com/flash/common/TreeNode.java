package com.flash.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode(int x) { val = x; }

     public static TreeNode createTree(Integer[] treeNumber){
          if(treeNumber == null || treeNumber.length < 1 || treeNumber[0] == null){
               return null;
          }
          Queue<TreeNode> queue = new LinkedList<>();
          TreeNode tree = new TreeNode(treeNumber[0]);
          queue.offer(tree);
          queue.offer(tree);

          TreeNode cur;
          for(int i=1;i<treeNumber.length;i++){
               cur = queue.poll();
               // 没有取到节点，说明树断层了
               if(cur == null){
                    break;
               }
               // 若数字为空，说明子树不存在
               if(treeNumber[i] == null){
                    continue;
               }
               // 若当前的队列节点与下一个队列节点相同，则说明正在建造左子树
               if(cur == queue.peek()){
                    cur.left = new TreeNode(treeNumber[i]);
                    queue.offer(cur.left);
                    queue.offer(cur.left);
               }else{
                    cur.right = new TreeNode(treeNumber[i]);
                    queue.offer(cur.right);
                    queue.offer(cur.right);
               }
          }
          return tree;
     }

}
