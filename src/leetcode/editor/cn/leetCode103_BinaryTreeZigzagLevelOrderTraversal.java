//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 563 👎 0

  
package leetcode.editor.cn;

import leetcode.editor.cn.common.TestTree;

import java.util.*;

public class leetCode103_BinaryTreeZigzagLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new leetCode103_BinaryTreeZigzagLevelOrderTraversal().new Solution();

          TestTree testTree = new TestTree();
          TreeNode root = testTree.getTestBT();

          solution.zigzagLevelOrder(root);

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
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    //暴力解法，通过层序遍历，偶数层反转
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        //根据count来判断。偶数层正常遍历，奇数层反转
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            List<Integer> levelList = new ArrayList<>();

            for(int i=0;i<size;i++)
            {
                TreeNode cur = queue.poll();

                if(cur != null)
                    levelList.add(cur.val);

                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }

            count+=1;
            if(count %2 == 0)
                Collections.reverse(levelList);

            result.add(levelList);
        }

        System.out.println(result);
        return  result;
    }

    //官方解法，通过双端队列和标志实现，标志为真时，添加到双端队列的尾部，否则添加到头部

}
//leetcode submit region end(Prohibit modification and deletion)

  }