//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 👍 872 👎 0

  
package leetcode.editor.cn;

import leetcode.editor.cn.common.TestTree;

public class leetCode543_DiameterOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new leetCode543_DiameterOfBinaryTree().new Solution();

          TestTree testTree = new TestTree();
          TreeNode root = testTree.getTestBT();

          solution.diameterOfBinaryTree(root);
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
    /*
    最长路径为左子树最下层节点到右子树最下层节点的路径
    化简为
    1.如果根节点参与，则为左子树最下层节点所在的层数加上右子树最下层的层数
    2.左子树最长路径
    3.右子树最长路径
     */
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;

        maxDepth(root);

        return  ans - 1;
    }

    public int maxDepth(TreeNode node){
        if(node == null)
            return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        ans = Math.max(ans,left + right + 1);

        return Math.max(left , right ) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }