//<p>给定一个二叉树，我们在树的节点上安装摄像头。</p>
//
//<p>节点上的每个摄影头都可以监视<strong>其父对象、自身及其直接子对象。</strong></p>
//
//<p>计算监控树的所有节点所需的最小摄像头数量。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/bst_cameras_01.png" style="height: 163px; width: 138px;"></p>
//
//<pre><strong>输入：</strong>[0,0,null,0,0]
//<strong>输出：</strong>1
//<strong>解释：</strong>如图所示，一台摄像头足以监控所有节点。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/bst_cameras_02.png" style="height: 312px; width: 139px;"></p>
//
//<pre><strong>输入：</strong>[0,0,null,0,null,0,null,null,0]
//<strong>输出：</strong>2
//<strong>解释：</strong>需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
//</pre>
//
//<p><br>
//<strong>提示：</strong></p>
//
//<ol>
//	<li>给定树的节点数的范围是&nbsp;<code>[1, 1000]</code>。</li>
//	<li>每个节点的值都是 0。</li>
//</ol>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>动态规划</li><li>二叉树</li></div></div><br><div><li>👍 412</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode968_BinaryTreeCameras{
      public static void main(String[] args) {
           Solution solution = new leetCode968_BinaryTreeCameras().new Solution();
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
    int result ;
    public int minCameraCover(TreeNode root) {
        result = 0;
        if(travels(root) == 0)
            result++;

        return result;

    }

    public int travels(TreeNode root){
        if(root == null)
            return 2;

        int left = travels(root.left);
        int right = travels(root.right);

        if(left == 2 &&  right == 2)
            return 0;

        if(left == 0 ||  right == 0){
            result++;
            return 1;
        }

        if(left == 1 ||  right == 1){
            return 2;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }