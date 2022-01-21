//<p>给你一棵二叉搜索树，请你 <strong>按中序遍历</strong> 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex1.jpg" style="width: 600px; height: 350px;" />
//<pre>
//<strong>输入：</strong>root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//<strong>输出：</strong>[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex2.jpg" style="width: 300px; height: 114px;" />
//<pre>
//<strong>输入：</strong>root = [5,1,7]
//<strong>输出：</strong>[1,null,5,null,7]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中节点数的取值范围是 <code>[1, 100]</code></li>
//	<li><code>0 <= Node.val <= 1000</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>栈</li><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 258</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode897_IncreasingOrderSearchTree{
      public static void main(String[] args) {
           Solution solution = new leetCode897_IncreasingOrderSearchTree().new Solution();
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
    TreeNode resNode;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        createTree(root);
        return dummyNode.right;
    }

    public void createTree(TreeNode node){
        if(node == null)
            return;
        //对任意一个节点的操作为，将其左子树变成根节点，根节点和其右子树变成其右子树
        createTree(node.left);

        resNode.right = node;
        node.left = null;
        resNode = node;

        createTree(node.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }