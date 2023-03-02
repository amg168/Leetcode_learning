//<p>输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。</p>
//
//<p>例如：</p>
//
//<p>给定二叉树 <code>[3,9,20,null,null,15,7]</code>，</p>
//
//<pre>    3
//   / \
//  9  20
//    /  \
//   15   7</pre>
//
//<p>返回它的最大深度&nbsp;3 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol> 
// <li><code>节点总数 &lt;= 10000</code></li> 
//</ol>
//
//<p>注意：本题与主站 104&nbsp;题相同：<a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/</a></p>
//
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 226</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCodeOffer55_ErChaShuDeShenDuLcof{
      public static void main(String[] args) {
           Solution solution = new leetCodeOffer55_ErChaShuDeShenDuLcof().new Solution();

           Integer[] arr = {3,9,20,null,null,15,7};
           TreeNode root = GenerateBinaryTreeFromArray.generateBT(arr);

          System.out.println(solution.maxDepth(root));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }