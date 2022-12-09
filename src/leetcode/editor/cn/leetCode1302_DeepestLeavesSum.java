//<p>给你一棵二叉树的根节点 <code>root</code> ，请你返回 <strong>层数最深的叶子节点的和</strong> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/28/1483_ex1.png" style="height: 265px; width: 273px;" /></strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//<strong>输出：</strong>15
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//<strong>输出：</strong>19
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>树中节点数目在范围 <code>[1, 10<sup>4</sup>]</code>&nbsp;之间。</li> 
// <li><code>1 &lt;= Node.val &lt;= 100</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 147</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class leetCode1302_DeepestLeavesSum{
      public static void main(String[] args) {

          Solution solution = new leetCode1302_DeepestLeavesSum().new Solution();

          Integer[] arr = {1,2,3,4,5,null,6,7,null,null,null,null,8};
          TreeNode root = GenerateBinaryTreeFromArray.generateBT(arr);

          System.out.println(solution.deepestLeavesSum(root));

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
//    public int deepestLeavesSum(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        int depth = 1;
//        int maxDepth = getDepthOfTree(root);
//        int result = 0;
//        while(!queue.isEmpty()){
//            int size = queue.size();
//
//            for(int i = 0 ; i < size ; i++){
//                TreeNode cur = queue.poll();
//
//                if(cur.left != null)
//                    queue.add(cur.left);
//
//                if(cur.right != null)
//                    queue.add(cur.right);
//
//                if(cur.left == null && cur.right == null && depth == maxDepth)
//                    result += cur.val;
//            }
//
//            depth++;
//        }
//
//        return result;
//    }
//
//    //得到树的最大深度
//    public int getDepthOfTree(TreeNode root){
//        if(root == null)
//            return 0;
//
//        return 1 + Math.max(getDepthOfTree(root.left) , getDepthOfTree(root.right));
//    }

//    int maxLevel = -1;
//    int sum = 0;
//    public int deepestLeavesSum(TreeNode root) {
//        dfs(root, 0);
//
//        return sum;
//    }
//
//    public void dfs(TreeNode node, int depth){
//        if(node == null)
//            return;
//
//        if(depth > maxLevel){
//            maxLevel = depth;
//            sum = node.val;
//        }else if(depth == maxLevel){
//            sum += node.val;
//        }
//
//        dfs(node.left, depth + 1);
//        dfs(node.right ,depth + 1);
//    }
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            //在每一层初始化sum为0
            sum = 0;
            int size = queue.size();

            for(int i = 0 ; i < size ;i++){
                TreeNode cur = queue.poll();
                sum += cur.val;

                if(cur.left != null)
                    queue.add(cur.left);

                if(cur.right != null)
                    queue.add(cur.right);
            }
        }

        return sum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }