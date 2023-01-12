//<p>给你一个二叉树的根节点&nbsp;<code>root</code>。设根节点位于二叉树的第 <code>1</code> 层，而根节点的子节点位于第 <code>2</code> 层，依此类推。</p>
//
//<p>请返回层内元素之和 <strong>最大</strong> 的那几层（可能只有一层）的层号，并返回其中&nbsp;<strong>最小</strong> 的那个。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/08/17/capture.jpeg" style="height: 175px; width: 200px;" /></strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1,7,0,7,-8,null,null]
//<strong>输出：</strong>2
//<strong>解释：</strong>
//第 1 层各元素之和为 1，
//第 2 层各元素之和为 7 + 0 = 7，
//第 3 层各元素之和为 7 + -8 = -1，
//所以我们返回第 2 层的层号，它的层内元素之和最大。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [989,null,10250,98693,-89388,null,null,null,-32127]
//<strong>输出：</strong>2
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>树中的节点数在
//  <meta charset="UTF-8" />&nbsp;<code>[1, 10<sup>4</sup>]</code>范围内
//  <meta charset="UTF-8" /></li> 
// <li><code>-10<sup>5</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 98</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.*;

public class leetCode1161_MaximumLevelSumOfABinaryTree{
      public static void main(String[] args) {
           Solution solution = new leetCode1161_MaximumLevelSumOfABinaryTree().new Solution();
           Integer[] arr = {1,0,0,1,4,0,0,2,3,0,0};
           TreeNode root = GenerateBinaryTreeFromArray.generateBT(arr);

           solution.maxLevelSum(root);

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
    1.返回所有层中和最大的一层的层号，可能存在多个层级和相同的情况，则返回层号最小的一个
     */
//    public int maxLevelSum(TreeNode root) {
//        if(root == null)
//            return 0;
//
//        /*
//        记录全局最大值和最小层号
//         */
//        int maxSum = Integer.MIN_VALUE;
//        int level = 1;
//        Map<Integer,Integer> map = new HashMap<>();
//        int minLevelNo = Integer.MAX_VALUE;
//        Queue<TreeNode> nodes = new LinkedList<>();
//        nodes.add(root);
//
//        while(!nodes.isEmpty()){
//            int size = nodes.size();
//
//            /*
//            记录单层的和
//             */
//            int levelSum = 0;
//            for(int i = 0 ;i < size ;i++){
//                TreeNode cur = nodes.poll();
//                levelSum += cur.val;
//                if(cur.left != null)
//                    nodes.add(cur.left);
//
//                if(cur.right != null)
//                    nodes.add(cur.right);
//            }
//
//            if(levelSum > maxSum){
//               maxSum = levelSum;
//            }
//
//            map.put(level,levelSum);
//            level++;
//        }
//
//
//        for(Map.Entry<Integer,Integer> mapentry : map.entrySet()){
//            if(mapentry.getValue() == maxSum && mapentry.getKey() < minLevelNo)
//                minLevelNo = mapentry.getKey();
//        }
//
//        return minLevelNo;
//    }

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        int max = -0x3f3f3f3f, depth = 1, ans = 0;
        d.addLast(root);
        while (!d.isEmpty()) {
            int sz = d.size(), cur = 0;
            while (sz-- > 0) {
                TreeNode t = d.pollFirst();
                if (t.left != null) d.addLast(t.left);
                if (t.right != null) d.addLast(t.right);
                cur += t.val;
            }
            if (cur > max) {
                max = cur; ans = depth;
            }
            depth++;
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }