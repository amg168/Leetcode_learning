//<p>给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：</p>
//
//<ul>
//	<li>该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）</li>
//</ul>
//
//<p>如果不存在祖父节点值为偶数的节点，那么返回&nbsp;<code>0</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/10/1473_ex1.png" style="height: 214px; width: 350px;"></strong></p>
//
//<pre><strong>输入：</strong>root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//<strong>输出：</strong>18
//<strong>解释：</strong>图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中节点的数目在&nbsp;<code>1</code> 到&nbsp;<code>10^4</code>&nbsp;之间。</li>
//	<li>每个节点的值在&nbsp;<code>1</code> 到&nbsp;<code>100</code> 之间。</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 69</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode1315_SumOfNodesWithEvenValuedGrandparent{
      public static void main(String[] args) {
           Solution solution = new leetCode1315_SumOfNodesWithEvenValuedGrandparent().new Solution();

           Integer[] arr = {6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
           TreeNode root = GenerateBinaryTreeFromArray.generateBT(arr);

           solution.sumEvenGrandparent(root);
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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        getGrandsonNode(root);

        return sum;
    }

    //当某一个节点值为偶数时，返回其孙子节点的和
    public void getGrandsonNode(TreeNode node){
        if(node == null)
            return;
        if(node.val % 2 == 0){
            if(node.left != null){
                if(node.left.left != null){
                    sum += node.left.left.val;
                }

                if(node.left.right != null){
                    sum += node.left.right.val;
                }
            }
            if(node.right != null){
                if(node.right.left != null){
                    sum += node.right.left.val;
                }

                if(node.right.right != null){
                    sum += node.right.right.val;
                }
            }
        }

        getGrandsonNode(node.left);
        getGrandsonNode(node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }