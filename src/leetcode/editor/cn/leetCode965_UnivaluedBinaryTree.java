//<p>如果二叉树每个节点都具有相同的值，那么该二叉树就是<em>单值</em>二叉树。</p>
//
//<p>只有给定的树是单值二叉树时，才返回&nbsp;<code>true</code>；否则返回 <code>false</code>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/screen-shot-2018-12-25-at-50104-pm.png" style="height: 159px; width: 200px;"></p>
//
//<pre><strong>输入：</strong>[1,1,1,1,1,null,1]
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/screen-shot-2018-12-25-at-50050-pm.png" style="height: 158px; width: 200px;"></p>
//
//<pre><strong>输入：</strong>[2,2,2,5,2]
//<strong>输出：</strong>false
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li>给定树的节点数范围是&nbsp;<code>[1, 100]</code>。</li>
//	<li>每个节点的值都是整数，范围为&nbsp;<code>[0, 99]</code>&nbsp;。</li>
//</ol>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 99</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode965_UnivaluedBinaryTree{
      public static void main(String[] args) {
           Solution solution = new leetCode965_UnivaluedBinaryTree().new Solution();

           TreeNode root = new TreeNode(2);
           TreeNode left = new TreeNode(2);
           TreeNode right = new TreeNode(2);

           root.left = left;
           root.right = right;

           left.left = new TreeNode(5);
           left.right = new TreeNode(2);

           solution.isUnivalTree(root);

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
    int value = 0;
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
            return true;

        value = root.val;

        return dfs(root);
    }

    public boolean dfs(TreeNode root){
        if(root == null)
            return true;

        if(root.val != value)
            return false;

        boolean left = dfs(root.left);
        boolean right = dfs(root.right);

        return left && right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }