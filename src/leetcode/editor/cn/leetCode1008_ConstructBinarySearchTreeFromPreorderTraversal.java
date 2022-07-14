//<p>给定一个整数数组，它表示BST(即 <strong>二叉搜索树</strong> )的 <strong>先</strong><strong>序遍历</strong> ，构造树并返回其根。</p>
//
//<p><strong>保证</strong> 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。</p>
//
//<p><strong>二叉搜索树</strong> 是一棵二叉树，其中每个节点，&nbsp;<code>Node.left</code>&nbsp;的任何后代的值 <strong>严格小于</strong> <code>Node.val</code>&nbsp;,&nbsp;<code>Node.right</code>&nbsp;的任何后代的值 <strong>严格大于</strong> <code>Node.val</code>。</p>
//
//<p>二叉树的 <strong>前序遍历</strong> 首先显示节点的值，然后遍历<code>Node.left</code>，最后遍历<code>Node.right</code>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img src="https://assets.leetcode.com/uploads/2019/03/06/1266.png" /></p>
//
//<pre>
//<strong>输入：</strong>preorder = [8,5,1,7,10,12]
//<strong>输出：</strong>[8,5,10,1,7,null,12]
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> preorder = [1,3]
//<strong>输出:</strong> [1,null,3]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= preorder.length &lt;= 100</code></li>
//	<li><code>1 &lt;= preorder[i]&nbsp;&lt;= 10^8</code></li>
//	<li><code>preorder</code> 中的值 <strong>互不相同</strong></li>
//</ul>
//
//<p>&nbsp;</p>
//<div><div>Related Topics</div><div><li>栈</li><li>树</li><li>二叉搜索树</li><li>数组</li><li>二叉树</li><li>单调栈</li></div></div><br><div><li>👍 201</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.Arrays;

public class leetCode1008_ConstructBinarySearchTreeFromPreorderTraversal{
      public static void main(String[] args) {
           Solution solution = new leetCode1008_ConstructBinarySearchTreeFromPreorderTraversal().new Solution();

           int[] arr = {4,2};
           solution.bstFromPreorder(arr);

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
//    public TreeNode bstFromPreorder(int[] preorder) {
//        if(preorder.length == 0)
//            return null;
//
//        TreeNode root = new TreeNode(preorder[0]);
//
//        if(preorder.length > 1){
//            int index = getFirstMaxVaule(preorder, preorder[0]);
//
//            if(index != 0){
//                root.left  = bstFromPreorder(Arrays.copyOfRange(preorder, 1 , index));
//                root.right = bstFromPreorder(Arrays.copyOfRange(preorder, index , preorder.length));
//            }else {
//                root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1 , preorder.length));
//                root.right = null;
//            }
//
//        }
//
//        return root;
//    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = bst(preorder, 0 , preorder.length - 1);

        return root;
    }

    //通过给定的数，找到第一个比该值大的数组的所以位置
    public int getFirstMaxVaule(int[] preorder, int value){
        for(int i = 0 ; i < preorder.length ; i++){
            if(preorder[i] > value)
                return  i;
        }

        return 0;
    }

    public TreeNode bst(int[] preorder,int start, int end) {
        if(start > end)
            return null;

        TreeNode root = new TreeNode(preorder[start]);

        int index = start + 1;
        for(; index <= end ; index++){
            if(preorder[index] > root.val)
                break;
        }

        root.left  = bst(preorder, start + 1 , index - 1);
        root.right = bst(preorder, index , end);

        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }