//<p>给你一个 <strong>二叉树 </strong>的根结点&nbsp;<code>root</code>，该二叉树由恰好&nbsp;<code>3</code>&nbsp;个结点组成：根结点、左子结点和右子结点。</p>
//
//<p>如果根结点值等于两个子结点值之和，返回&nbsp;<code>true</code>&nbsp;，否则返回<em>&nbsp;</em><code>false</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2022/04/08/graph3drawio.png" style="width: 281px; height: 199px;" />
//<pre>
//<strong>输入：</strong>root = [10,4,6]
//<strong>输出：</strong>true
//<strong>解释：</strong>根结点、左子结点和右子结点的值分别是 10 、4 和 6 。
//由于 10 等于 4 + 6 ，因此返回 true 。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2022/04/08/graph3drawio-1.png" style="width: 281px; height: 199px;" />
//<pre>
//<strong>输入：</strong>root = [5,3,1]
//<strong>输出：</strong>false
//<strong>解释：</strong>根结点、左子结点和右子结点的值分别是 5 、3 和 1 。
//由于 5 不等于 3 + 1 ，因此返回 false 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树只包含根结点、左子结点和右子结点</li>
//	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>二叉树</li></div></div><br><div><li>👍 10</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode2236_RootEqualsSumOfChildren{
      public static void main(String[] args) {
           Solution solution = new leetCode2236_RootEqualsSumOfChildren().new Solution();
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
    public boolean checkTree(TreeNode root) {

        if(root == null)
            return false;
        else{
            if(root.left == null  || root.right ==null)
                return false;
            else{
                if(root.val == root.left.val + root.right.val)
                    return true;
                else
                    return false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }