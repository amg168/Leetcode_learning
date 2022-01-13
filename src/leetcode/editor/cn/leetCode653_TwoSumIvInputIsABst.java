//给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 
//
// 示例 1： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
// 
//
// 示例 2： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
// 
//
// 示例 3： 
//
// 
//输入: root = [2,1,3], k = 4
//输出: true
// 
//
// 示例 4： 
//
// 
//输入: root = [2,1,3], k = 1
//输出: false
// 
//
// 示例 5： 
//
// 
//输入: root = [2,1,3], k = 3
//输出: true
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root 为二叉搜索树 
// -10⁵ <= k <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 304 👎 0

  
package leetcode.editor.cn;

import leetcode.editor.cn.common.TestTree;

import java.util.ArrayList;
import java.util.List;

public class leetCode653_TwoSumIvInputIsABst{
      public static void main(String[] args) {
           Solution solution = new leetCode653_TwoSumIvInputIsABst().new Solution();

          TestTree testTree = new TestTree();
          TreeNode root = testTree.getTestBT();

          solution.findTarget(root,9);
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
    List<Integer> result = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        for(int i = 0; i < result.size() ; i++){
            if(result.contains(k - result.get(i)) && k - result.get(i) != result.get(i)){
                return  true;
            }
        }

        return false;
    }

    //中序遍历存入list中
    public void inOrder(TreeNode root){
        if(root == null)
            return;

        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }