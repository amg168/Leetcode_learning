//<p>给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。</p>
//
//<p>例如，</p>
//
//<pre>
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
//</pre>
//
//<p>你应该返回如下子树:</p>
//
//<pre>
//      2     
//     / \   
//    1   3
//</pre>
//
//<p>在上述示例中，如果要找的值是 <code>5</code>，但因为没有节点值为 <code>5</code>，我们应该返回 <code>NULL</code>。</p>
//<div><div>Related Topics</div><div><li>树</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 229</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode700_SearchInABinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new leetCode700_SearchInABinarySearchTree().new Solution();
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;

        if(root.val == val)
            return root;
        else if(root.val > val){
            return  searchBST(root.left,val);
        }else{
            return  searchBST(root.right,val);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }