//<p><em>满二叉树</em>是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。</p>
//
//<p>返回包含 <code>N</code> 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。</p>
//
//<p>答案中每个树的每个<code>结点</code>都<strong>必须</strong>有 <code>node.val=0</code>。</p>
//
//<p>你可以按任何顺序返回树的最终列表。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<pre><strong>输入：</strong>7
//<strong>输出：</strong>[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//<strong>解释：</strong>
//<img alt="" src="https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/08/24/fivetrees.png" style="height: 400px; width: 700px;">
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= N &lt;= 20</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>递归</li><li>记忆化搜索</li><li>动态规划</li><li>二叉树</li></div></div><br><div><li>👍 244</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class leetCode894_AllPossibleFullBinaryTrees{
      public static void main(String[] args) {
           Solution solution = new leetCode894_AllPossibleFullBinaryTrees().new Solution();
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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n %2 == 0)
            return  ans;

        if(n == 1){
            TreeNode head = new TreeNode(0);
            ans.add(head);
            return  ans;
        }

        for(int i = 1; i < n ; i += 2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i -1);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode head = new TreeNode(0);
                    head.left = l;
                    head.right = r;
                    ans.add(head);
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }