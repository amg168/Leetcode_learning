//<p>返回与给定的前序和后序遍历匹配的任何二叉树。</p>
//
//<p>&nbsp;<code>pre</code>&nbsp;和&nbsp;<code>post</code>&nbsp;遍历中的值是不同的正整数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<pre><strong>输入：</strong>pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//<strong>输出：</strong>[1,2,3,4,5,6,7]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= pre.length == post.length &lt;= 30</code></li>
//	<li><code>pre[]</code>&nbsp;和&nbsp;<code>post[]</code>&nbsp;都是&nbsp;<code>1, 2, ..., pre.length</code>&nbsp;的排列</li>
//	<li>每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 215</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.Arrays;

public class leetCode889_ConstructBinaryTreeFromPreorderAndPostorderTraversal{
      public static void main(String[] args) {
           Solution solution = new leetCode889_ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();

          int[] pre = {1,2,4,5,3,6,7};
          int[] post = {4,5,2,6,7,3,1};

          solution.constructFromPrePost(pre , post);
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder.length == 0 || postorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1 || postorder.length == 1)
            return root;

        //preorder[1]为左子树的根节点，在后序遍历中找到其位置
        /*
        执行耗时:1 ms,击败了65.06% 的Java用户
		内存消耗:41.4 MB,击败了5.04% 的Java用户
         */
        int index = 0;
        for(int i = 0 ;i < postorder.length ; i++){
            if(postorder[i] == preorder[1]) {
                index = i;
                break;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(preorder,1, 2 + index),Arrays.copyOfRange(postorder,0, index +  1));
        root.right = constructFromPrePost(Arrays.copyOfRange(preorder,index + 2, preorder.length),Arrays.copyOfRange(postorder,1 + index, postorder.length - 1));

        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }