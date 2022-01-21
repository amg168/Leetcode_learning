//<p>给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 <strong>保证</strong> ，新值和原始二叉搜索树中的任意节点值都不同。</p>
//
//<p><strong>注意</strong>，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 <strong>任意有效的结果</strong> 。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/insertbst.jpg" style="width: 752px; height: 221px;" />
//<pre>
//<strong>输入：</strong>root = [4,2,7,1,3], val = 5
//<strong>输出：</strong>[4,2,7,1,3,5]
//<strong>解释：</strong>另一个满足题目要求可以通过的树是：
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/bst.jpg" style="width: 352px; height: 301px;" />
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [40,20,60,10,30,50,70], val = 25
//<strong>输出：</strong>[40,20,60,10,30,50,70,null,null,25]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
//<strong>输出：</strong>[4,2,7,1,3,5]
//</pre>
//
//<p> </p>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>给定的树上的节点数介于 <code>0</code> 和 <code>10^4</code> 之间</li>
//	<li>每个节点都有一个唯一整数值，取值范围从 <code>0</code> 到 <code>10^8</code></li>
//	<li><code>-10^8 <= val <= 10^8</code></li>
//	<li>新值和原始二叉搜索树中的任意节点值都不同</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 253</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode701_InsertIntoABinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new leetCode701_InsertIntoABinarySearchTree().new Solution();

           TreeNode root = new TreeNode(4);
           TreeNode left = new TreeNode(2);
           TreeNode right = new TreeNode(7);

           root.left = left;
           root.right = right;

           left.left = new TreeNode(1);
           left.right = new TreeNode(3);

           int val = 5;
           solution.insertIntoBST(root, 5);
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        if(val < root.val){
            root.left = insertIntoBST(root.left , val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }