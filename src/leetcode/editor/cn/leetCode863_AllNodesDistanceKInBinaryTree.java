//<p>给定一个二叉树（具有根结点&nbsp;<code>root</code>），&nbsp;一个目标结点&nbsp;<code>target</code>&nbsp;，和一个整数值 <code>K</code> 。</p>
//
//<p>返回到目标结点 <code>target</code> 距离为 <code>K</code> 的所有结点的值的列表。 答案可以以任何顺序返回。</p>
//
//<p>&nbsp;</p>
//
//<ol>
//</ol>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//<strong>输出：</strong>[7,4,1]
//<strong>解释：</strong>
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/06/28/sketch0.png" style="height: 240px; width: 280px;">
//
//注意，输入的 &quot;root&quot; 和 &quot;target&quot; 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li>给定的树是非空的。</li>
//	<li>树上的每个结点都具有唯一的值&nbsp;<code>0 &lt;= node.val &lt;= 500</code>&nbsp;。</li>
//	<li>目标结点&nbsp;<code>target</code>&nbsp;是树上的结点。</li>
//	<li><code>0 &lt;= K &lt;= 1000</code>.</li>
//</ol>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 478</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetCode863_AllNodesDistanceKInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new leetCode863_AllNodesDistanceKInBinaryTree().new Solution();

        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);

        root.left = left;
        root.right = right;

        left.left = new TreeNode(6);
        TreeNode left_right = new TreeNode(2);
        left.right = left_right;
        left_right.left = new TreeNode(7);
        left_right.right = new TreeNode(4);

        right.left = new TreeNode(0);
        right.right = new TreeNode(8);

        solution.distanceK(root, left , 2);
    }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int value = 0;
    List<Integer> result = new ArrayList<>();
    List<Integer> left = null;
    List<Integer> right = null;
    Stack<TreeNode> stack = new Stack<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        rootToTarget(root,target,stack);

        //根节点到target节点的距离
        int size = stack.size() - 1;

        left = distanceK(target.left , target ,k);
        right = distanceK(target.right, target ,k);

        if(k > size){
            left = distanceK(root.left , target , k - size);
            right = distanceK(root.right, target , k - size);
        }

        result.addAll(left);
        result.addAll(right);

        return result;
    }

    //得到根节点到target节点的距离
    public boolean rootToTarget(TreeNode root, TreeNode target, Stack<TreeNode> s){
        if(root == null)
            return false;

        s.push(root);

        if(root.val == target.val)
            return true;

        boolean b = false;
        //先去左子树找
        if(root.left != null)
            b = rootToTarget(root.left,target,s);
        //左子树找不到并且右子树不为空的情况下才去找
        if(!b && root.right != null)
            b = rootToTarget(root.right,target,s);
        //左右都找不到，弹出栈顶元素
        if(!b) s.pop();
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }