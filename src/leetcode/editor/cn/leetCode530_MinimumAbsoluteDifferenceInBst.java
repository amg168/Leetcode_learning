//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 294 👎 0

  
package leetcode.editor.cn;

import leetcode.editor.cn.common.TestBinarySearchTree;

import java.util.LinkedList;
import java.util.Stack;

public class leetCode530_MinimumAbsoluteDifferenceInBst{
      public static void main(String[] args) {
           Solution solution = new leetCode530_MinimumAbsoluteDifferenceInBst().new Solution();

          TestBinarySearchTree testBinarySearchTree = new TestBinarySearchTree();
          TreeNode root = testBinarySearchTree.getTestBST();

          solution.getMinimumDifference(root);
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
    public int getMinimumDifference(TreeNode root) {
        //中序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        int diff = 0;
        int result = Integer.MAX_VALUE;
        int preNodeValue = 0;
        int count = 0;

        while(!stack.isEmpty() ||  node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                node = stack.pop();

                if(count  == 0)
                    diff = result;
                else
                    diff = Math.abs(node.val -preNodeValue);

                preNodeValue = node.val;

                result = diff < result ? diff : result;
                count++;
                node = node.right;
            }
        }

        return result;

    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }