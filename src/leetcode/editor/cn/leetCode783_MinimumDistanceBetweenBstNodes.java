//<p>给你一个二叉搜索树的根节点 <code>root</code> ，返回 <strong>树中任意两不同节点值之间的最小差值</strong> 。</p>
//
//<p>差值是一个正数，其数值等于两值之差的绝对值。</p>
//
//<p>&nbsp;</p>
//
//<div class="original__bRMd">
//<div>
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/05/bst1.jpg" style="width: 292px; height: 301px;" />
//<pre>
//<strong>输入：</strong>root = [4,2,6,1,3]
//<strong>输出：</strong>1
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/05/bst2.jpg" style="width: 282px; height: 301px;" />
//<pre>
//<strong>输入：</strong>root = [1,0,48,null,null,12,49]
//<strong>输出：</strong>1
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中节点的数目范围是 <code>[2, 100]</code></li>
//	<li><code>0 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>注意：</strong>本题与 530：<a href="https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/">https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/</a> 相同</p>
//</div>
//</div>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 211</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class leetCode783_MinimumDistanceBetweenBstNodes{
      public static void main(String[] args) {
           Solution solution = new leetCode783_MinimumDistanceBetweenBstNodes().new Solution();
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

    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        for(int i = 0; i < result.size() - 1 ; i++){
            if(result.get(i + 1) - result.get(i) < minDiff)
                minDiff = result.get(i + 1) - result.get(i);
        }

        return minDiff;
    }

    //中序遍历
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