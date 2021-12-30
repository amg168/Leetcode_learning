//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 724 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetCode145_BinaryTreePostorderTraversal{
      public static void main(String[] args) {
           Solution solution = new leetCode145_BinaryTreePostorderTraversal().new Solution();
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<Integer>();

        TreeNode node = root;

        Stack<TreeNode> stack=new Stack<TreeNode>();

        TreeNode prev=null;

        while(node !=null || !stack.isEmpty())
        {
            while(node != null)
            {
                stack.push(node);

                node = node.left;
            }

            node=stack.peek();

            if(node.right ==null || node.right == prev)
            {
                stack.pop();

                result.add(node.val);

                prev=node;

                node=null;
            }
            else {
                node = node.right;
            }

        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }