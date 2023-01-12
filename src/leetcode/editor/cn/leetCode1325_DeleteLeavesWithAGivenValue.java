//<p>给你一棵以&nbsp;<code>root</code>&nbsp;为根的二叉树和一个整数&nbsp;<code>target</code>&nbsp;，请你删除所有值为&nbsp;<code>target</code> 的&nbsp;<strong>叶子节点</strong> 。</p>
//
//<p>注意，一旦删除值为&nbsp;<code>target</code>&nbsp;的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是&nbsp;<code>target</code> ，那么这个节点也应该被删除。</p>
//
//<p>也就是说，你需要重复此过程直到不能继续删除。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/16/sample_1_1684.png" style="height: 120px; width: 550px;" /></strong></p>
//
//<pre><strong>输入：</strong>root = [1,2,3,2,null,2,4], target = 2
//<strong>输出：</strong>[1,null,3,null,4]
//<strong>解释：
//</strong>上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
//有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/16/sample_2_1684.png" style="height: 120px; width: 300px;" /></strong></p>
//
//<pre><strong>输入：</strong>root = [1,3,3,3,2], target = 3
//<strong>输出：</strong>[1,3,null,null,2]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/16/sample_3_1684.png" style="width: 450px;" /></strong></p>
//
//<pre><strong>输入：</strong>root = [1,2,null,2,null,2], target = 2
//<strong>输出：</strong>[1]
//<strong>解释：</strong>每一步都删除一个绿色的叶子节点（值为 2）。</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre><strong>输入：</strong>root = [1,1,1], target = 1
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 5：</strong></p>
//
//<pre><strong>输入：</strong>root = [1,2,3], target = 1
//<strong>输出：</strong>[1,2,3]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= target&nbsp;&lt;= 1000</code></li> 
// <li>每一棵树最多有 <code>3000</code> 个节点。</li> 
// <li>每一个节点值的范围是&nbsp;<code>[1, 1000]</code>&nbsp;。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 98</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode1325_DeleteLeavesWithAGivenValue{
      public static void main(String[] args) {
           Solution solution = new leetCode1325_DeleteLeavesWithAGivenValue().new Solution();
           Integer[] arr = {1,2,null,2,null,2};
           TreeNode root = GenerateBinaryTreeFromArray.generateBT(arr);

           solution.removeLeafNodes(root,2);
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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return null;
        return  remove(root,target);
    }

    public TreeNode remove(TreeNode node, int target){
        if(node == null)
            return null;
        TreeNode left = remove(node.left,target);
        TreeNode right = remove(node.right,target);

        node.left = left;
        node.right = right;

        if(node.left == null && node.right == null && node.val == target)
            return null;

        return node;
    }

//    //判断一个节点是否是叶子节点，且val值是否等于target
//    public boolean checkIsLeafNodeAndEqualTarget(TreeNode node,int target){
//        boolean flag = false;
//        if(node.left == null && node.right == null && node.val == target){
//            flag = true;
//        }
//
//        return flag;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }