//<p>给定一个有 <code>N</code> 个结点的二叉树的根结点 <code>root</code>，树中的每个结点上都对应有 <code>node.val</code> 枚硬币，并且总共有 <code>N</code> 枚硬币。</p>
//
//<p>在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。</p>
//
//<p>返回使每个结点上只有一枚硬币所需的移动次数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/01/19/tree1.png" style="height: 142px; width: 150px;"></strong></p>
//
//<pre><strong>输入：</strong>[3,0,0]
//<strong>输出：</strong>2
//<strong>解释：</strong>从树的根结点开始，我们将一枚硬币移到它的左子结点上，一枚硬币移到它的右子结点上。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/01/19/tree2.png" style="height: 142px; width: 150px;"></strong></p>
//
//<pre><strong>输入：</strong>[0,3,0]
//<strong>输出：</strong>3
//<strong>解释：</strong>从根结点的左子结点开始，我们将两枚硬币移到根结点上 [移动两次]。然后，我们把一枚硬币从根结点移到右子结点上。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/01/19/tree3.png" style="height: 142px; width: 150px;"></strong></p>
//
//<pre><strong>输入：</strong>[1,0,2]
//<strong>输出：</strong>2
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/01/19/tree4.png" style="height: 156px; width: 155px;"></strong></p>
//
//<pre><strong>输入：</strong>[1,0,0,null,3]
//<strong>输出：</strong>4
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li><code>1&lt;= N &lt;= 100</code></li>
//	<li><code>0 &lt;= node.val &lt;= N</code></li>
//</ol>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 288</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode979_DistributeCoinsInBinaryTree{
      public static void main(String[] args) {
           Solution solution = new leetCode979_DistributeCoinsInBinaryTree().new Solution();
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
    int count = 0;
    public int distributeCoins(TreeNode root) {
        count = 0;

        dfs(root);

        return count;
    }

    public int dfs(TreeNode root){
        if(root == null)
            return 0;

        int L = dfs(root.left);
        int R = dfs(root.right);

        count += Math.abs(L) + Math.abs(R);

        return root.val + L + R - 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }