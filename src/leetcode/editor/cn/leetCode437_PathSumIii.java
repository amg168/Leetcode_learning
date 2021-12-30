//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1178 👎 0

  
package leetcode.editor.cn;

import leetcode.editor.cn.common.TestTree;

import java.util.HashMap;
import java.util.Map;

public class leetCode437_PathSumIii{
      public static void main(String[] args) {

          Solution solution = new leetCode437_PathSumIii().new Solution();

          TestTree testTree = new TestTree();
          TreeNode root = testTree.getTestBT();

          solution.pathSum(root,16);
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
//    public int pathSum(TreeNode root, int targetSum) {
//        if(root == null)
//            return 0;
//
//        int ret = count(root,targetSum);
//        ret += pathSum(root.left,targetSum);
//        ret += pathSum(root.right,targetSum);
//
//        return  ret;
//    }
//
//    public int count(TreeNode node,int targetSum){
//        int ret  = 0;
//        if(node == null)
//            return 0;
//
//        if(node.val == targetSum)
//            ret++;
//
//        ret += count(node.left,targetSum - node.val);
//        ret += count(node.right,targetSum - node.val);
//
//        return ret;
//
//    }

    /*
    方法二：前缀和
     */
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }