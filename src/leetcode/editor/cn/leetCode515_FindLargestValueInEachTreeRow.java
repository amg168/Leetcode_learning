//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
//解释:
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
//解释:
//          1
//         / \
//        2   3
// 
//
// 示例3： 
//
// 
//输入: root = [1]
//输出: [1]
// 
//
// 示例4： 
//
// 
//输入: root = [1,null,2]
//输出: [1,2]
//解释:      
//           1 
//            \
//             2     
// 
//
// 示例5： 
//
// 
//输入: root = []
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 163 👎 0

  
package leetcode.editor.cn;

import leetcode.editor.cn.common.TestTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetCode515_FindLargestValueInEachTreeRow{
      public static void main(String[] args) {
           Solution solution = new leetCode515_FindLargestValueInEachTreeRow().new Solution();

          TestTree testTree = new TestTree();
          TreeNode root = testTree.getTestBT();

          solution.largestValues(root);
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

    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;

            int size = queue.size();
            for(int i = 0 ;i < size ; i++){
                TreeNode cur = queue.poll();

                if(cur.val >  max) {
                    max = cur.val;
                }

                if(cur.left != null)
                    queue.add(cur.left);

                if(cur.right  != null)
                    queue.add(cur.right);

            }

            result.add(max);
        }


        return  result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }