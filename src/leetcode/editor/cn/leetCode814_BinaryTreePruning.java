//<p>给你二叉树的根结点&nbsp;<code>root</code>&nbsp;，此外树的每个结点的值要么是 <code>0</code> ，要么是 <code>1</code> 。</p>
//
//<p>返回移除了所有不包含 <code>1</code> 的子树的原二叉树。</p>
//
//<p>节点 <code>node</code> 的子树为 <code>node</code> 本身加上所有 <code>node</code> 的后代。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/06/1028_2.png" style="width: 500px; height: 140px;" />
//<pre>
//<strong>输入：</strong>root = [1,null,0,0,1]
//<strong>输出：</strong>[1,null,0,null,1]
//<strong>解释：</strong>
//只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/06/1028_1.png" style="width: 500px; height: 115px;" />
//<pre>
//<strong>输入：</strong>root = [1,0,1,0,0,0,1]
//<strong>输出：</strong>[1,null,1,null,1]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/05/1028.png" style="width: 500px; height: 134px;" />
//<pre>
//<strong>输入：</strong>root = [1,1,0,1,1,0,1,0]
//<strong>输出：</strong>[1,1,0,1,1,null,1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中节点的数目在范围 <code>[1, 200]</code> 内</li>
//	<li><code>Node.val</code> 为 <code>0</code> 或 <code>1</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 205</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode814_BinaryTreePruning{
      public static void main(String[] args) {
          Solution solution = new leetCode814_BinaryTreePruning().new Solution();

          TreeNode root = new TreeNode(1);
          TreeNode right = new TreeNode(0);

          root.right= right;

          right.left = new TreeNode(0);
          right.right = new TreeNode(1);

          solution.pruneTree(root);
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
    自己写的垃圾
     */
//    public TreeNode pruneTree(TreeNode root) {
//        if(root == null)
//            return null;
//        //清除所有返回false值的节点
//        boolean rootIsOne = haveOne(root);
//
//        if(rootIsOne == false && root != null)
//            root = null;
//
//        TreeNode left = null;
//        TreeNode right = null;
//        if(root != null){
//            left = pruneTree(root.left);
//            right = pruneTree(root.right);
//
//            root.left = left;
//            root.right = right;
//        }
//
//        return  root;
//    }
//
//    //判断一个节点的的子树中是否包含1
//    public boolean haveOne(TreeNode node){
//        if(node == null)
//            return false;
//
//        boolean isRootEqualOne = node.val == 1 ? true : false;
//
//        boolean left = haveOne(node.left);
//        boolean right = haveOne(node.right);
//
//        return isRootEqualOne || left || right;
//    }
    /*
    大神的优雅代码
     */
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }