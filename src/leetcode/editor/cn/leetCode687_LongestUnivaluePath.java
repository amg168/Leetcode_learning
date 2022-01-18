//<p>给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。</p>
//
//<p><strong>注意</strong>：两个节点之间的路径长度由它们之间的边数表示。</p>
//
//<p><strong>示例 1:</strong></p>
//
//<p>输入:</p>
//
//<pre>
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
//</pre>
//
//<p>输出:</p>
//
//<pre>
//2
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<p>输入:</p>
//
//<pre>
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
//</pre>
//
//<p>输出:</p>
//
//<pre>
//2
//</pre>
//
//<p><strong>注意:</strong> 给定的二叉树不超过10000个结点。&nbsp;树的高度不超过1000。</p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 526</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode687_LongestUnivaluePath{
      public static void main(String[] args) {
           Solution solution = new leetCode687_LongestUnivaluePath().new Solution();
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
    int ans ;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        path(root);

        return ans;
    }

    public int path(TreeNode node) {
        if (node == null)
            return 0;
        int valueLeft = 0;
        int valueRight = 0;

        int left = path(node.left);
        int right = path(node.right);
        if (node.left != null && node.val == node.left.val) {
            valueLeft += left + 1;
        }

        if (node.right != null && node.val == node.right.val) {
            valueRight += right + 1;
        }

        ans = Math.max(ans, valueLeft + valueRight);

        return Math.max(valueLeft, valueRight);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }