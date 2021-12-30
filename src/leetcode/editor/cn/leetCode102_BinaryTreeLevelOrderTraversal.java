//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1121 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetCode102_BinaryTreeLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new leetCode102_BinaryTreeLevelOrderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();

        if(root == null)
            return res;

        Queue<TreeNode> q=new LinkedList<TreeNode>();

        q.offer(root);

        while(!q.isEmpty())
        {
            List<Integer> list=new ArrayList<Integer>();

            int size=q.size();

            for(int i=1;i<=size;++i)
            {
                TreeNode node=q.poll();

                list.add(node.val);

                if(node.left != null)
                    q.offer(node.left);

                if(node.right != null)
                    q.offer(node.right);
            }

            res.add(list);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }