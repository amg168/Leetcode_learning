//<p>给你二叉搜索树的根节点 <code>root</code> ，同时给定最小边界<code>low</code> 和最大边界 <code>high</code>。通过修剪二叉搜索树，使得所有节点的值在<code>[low, high]</code>中。修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。</p>
//
//<p>所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/09/09/trim1.jpg" style="width: 450px; height: 126px;" />
//<pre>
//<strong>输入：</strong>root = [1,0,2], low = 1, high = 2
//<strong>输出：</strong>[1,null,2]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/09/09/trim2.jpg" style="width: 450px; height: 277px;" />
//<pre>
//<strong>输入：</strong>root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//<strong>输出：</strong>[3,2,null,1]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1], low = 1, high = 2
//<strong>输出：</strong>[1]
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1,null,2], low = 1, high = 3
//<strong>输出：</strong>[1,null,2]
//</pre>
//
//<p><strong>示例 5：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1,null,2], low = 2, high = 4
//<strong>输出：</strong>[2]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中节点数在范围 <code>[1, 10<sup>4</sup>]</code> 内</li>
//	<li><code>0 <= Node.val <= 10<sup>4</sup></code></li>
//	<li>树中每个节点的值都是唯一的</li>
//	<li>题目数据保证输入是一棵有效的二叉搜索树</li>
//	<li><code>0 <= low <= high <= 10<sup>4</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 460</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode669_TrimABinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new leetCode669_TrimABinarySearchTree().new Solution();
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return root;

        if(root.val > high)
            return  trimBST(root.left , low, high);

        if(root.val < low)
            return  trimBST(root.right, low, high);


        root.left = trimBST(root.left , low , high);
        root.right = trimBST(root.right , low , high);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }