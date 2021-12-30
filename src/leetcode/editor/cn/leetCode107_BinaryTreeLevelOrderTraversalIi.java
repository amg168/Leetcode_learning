//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 518 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetCode107_BinaryTreeLevelOrderTraversalIi{
      public static void main(String[] args) {
           Solution solution = new leetCode107_BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();

            List<Integer> level = new ArrayList<Integer>();
            for(int i=0;i<size;i++)
            {
                TreeNode cur=queue.poll();

                level.add(cur.val);

                if(cur.left != null)
                {
                    queue.add(cur.left);
                }

                if(cur.right != null)
                {
                    queue.add(cur.right);
                }

            }

            result.add(0,level);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }