//<p>给定一个二叉树的<meta charset="UTF-8" />&nbsp;<code>root</code>&nbsp;，确定它是否是一个&nbsp;<em>完全二叉树</em>&nbsp;。</p>
//
//<p>在一个&nbsp;<strong><a href="https://baike.baidu.com/item/完全二叉树/7773232?fr=aladdin" target="_blank">完全二叉树</a></strong>&nbsp;中，除了最后一个关卡外，所有关卡都是完全被填满的，并且最后一个关卡中的所有节点都是尽可能靠左的。它可以包含<meta charset="UTF-8" />&nbsp;<code>1</code>&nbsp;到<meta charset="UTF-8" />&nbsp;<code>2<sup>h</sup></code>&nbsp;节点之间的最后一级 <code>h</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/complete-binary-tree-1.png" /></p>
//
//<pre>
//<strong>输入：</strong>root = [1,2,3,4,5,6]
//<strong>输出：</strong>true
//<strong>解释：</strong>最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/complete-binary-tree-2.png" /></strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1,2,3,4,5,null,7]
//<strong>输出：</strong>false
//<strong>解释：</strong>值为 7 的结点没有尽可能靠向左侧。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树的结点数在范围 <meta charset="UTF-8" />&nbsp;<code>[1, 100]</code>&nbsp;内。</li>
//	<li><code>1 &lt;= Node.val &lt;= 1000</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 173</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import sun.rmi.runtime.NewThreadAction;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetCode958_CheckCompletenessOfABinaryTree{
      public static void main(String[] args) {
           Solution solution = new leetCode958_CheckCompletenessOfABinaryTree().new Solution();

          Integer[] arr = {1,2,3,null,null,7,8};
           GenerateBinaryTreeFromArray generateBinaryTreeFromArray = new GenerateBinaryTreeFromArray();
           TreeNode root = GenerateBinaryTreeFromArray.generateBT(arr);
           System.out.println(solution.isCompleteTree(root));
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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;

        List<NewNode> queue = new LinkedList<>();
        queue.add(new NewNode(root , 1));

        int i = 0;
        while(i < queue.size()){

            NewNode cur = queue.get(i++);

            if(cur.node != null){
                queue.add(new NewNode(cur.node.left , cur.index * 2));
                queue.add(new NewNode(cur.node.right ,cur.index * 2 + 1 ));
            }
        }

        return queue.get(i-1).index == queue.size();
    }


}

class NewNode{
    TreeNode node;

    int index;

    public NewNode(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }