//<p>我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。</p>
//
//<p>只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X <em>翻转等价</em>于二叉树 Y。</p>
//
//<p>编写一个判断两个二叉树是否是<em>翻转等价</em>的函数。这些树由根节点&nbsp;<code>root1</code> 和 <code>root2</code>&nbsp;给出。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<pre><strong>输入：</strong>root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
//<strong>输出：</strong>true
//<strong>解释：</strong>我们翻转值为 1，3 以及 5 的三个节点。
//<img alt="Flipped Trees Diagram" src="https://assets.leetcode.com/uploads/2018/11/29/tree_ex.png" style="height: 220px; width: 500px;">
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li>每棵树最多有&nbsp;<code>100</code>&nbsp;个节点。</li>
//	<li>每棵树中的每个值都是唯一的、在 <code>[0, 99]</code>&nbsp;范围内的整数。</li>
//</ol>
//
//<p>&nbsp;</p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 117</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode951_FlipEquivalentBinaryTrees{
      public static void main(String[] args) {
           Solution solution = new leetCode951_FlipEquivalentBinaryTrees().new Solution();

           Integer[] arr1 = {0, 1};
           TreeNode root1 = GenerateBinaryTreeFromArray.generateBT(arr1);

          Integer[] arr2 = {0, 1};
          TreeNode root2 = GenerateBinaryTreeFromArray.generateBT(arr2);

           solution.flipEquiv(root1, root2);

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
    我写的垃圾代码
     */
//    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//        if(root1 == null && root2 == null)
//            return true;
//
//        if((root1 == null || root2 == null) || root1.val != root2.val)
//            return  false;
//
//        System.out.println(process(root1,root2));
//        return  process(root1,root2);
//
//    }
//
//    public boolean process(TreeNode root1, TreeNode root2){
//        boolean left = false;
//        boolean right = false;
//
//        if(root1 == null && root2 == null)
//            return  true;
//        if(root1.val ==  root2.val && root1.left == null && root1.right == null && root2.left == null && root2.right == null){
//            return  true;
//        }
//
//        if(root1.left != null && root2.left != null && root1.left.val == root2.left.val){
//            left = process(root1.left , root2.left);
//        }else if(root1.left == null && root2.left == null){
//            left = true;
//        }
//
//        if(root1.right != null && root2.right != null && root1.right.val == root2.right.val){
//            right = process(root1.right , root2.right);
//        }else if(root1.right == null && root2.right == null)
//        {
//            right =true;
//        }
//
//        if(root1.left != null && root2.right != null && root1.left.val == root2.right.val){
//            left = process(root1.left , root2.right);
//        }else if(root1.left == null && root2.right == null){
//            left = true;
//        }
//
//        if(root1.right != null && root2.left != null && root1.right.val == root2.left.val ){
//            right = process(root1.right , root2.left);
//        }else if(root1.right == null && root2.left == null){
//            right = true;
//        }
//
//
//        return root1.val == root2.val && left  && right;
//    }
    /*
    官方简洁解法
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 ==  root2)
            return true;

        if(root1 == null || root2 == null || root1.val != root2.val)
            return  false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right , root2.right) ||
                flipEquiv(root1.left , root2.right) && flipEquiv(root1.right, root2.left));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }