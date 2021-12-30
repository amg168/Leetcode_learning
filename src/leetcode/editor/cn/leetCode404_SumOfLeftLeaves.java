//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 370 👎 0

  
  package leetcode.editor.cn;
  public class leetCode404_SumOfLeftLeaves{
      public static void main(String[] args) {
           Solution solution = new leetCode404_SumOfLeftLeaves().new Solution();
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int res = 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }