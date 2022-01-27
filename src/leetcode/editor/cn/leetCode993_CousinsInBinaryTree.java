//<p>在二叉树中，根节点位于深度 <code>0</code> 处，每个深度为 <code>k</code> 的节点的子节点位于深度 <code>k+1</code> 处。</p>
//
//<p>如果二叉树的两个节点深度相同，但<strong> 父节点不同</strong> ，则它们是一对<em>堂兄弟节点</em>。</p>
//
//<p>我们给出了具有唯一值的二叉树的根节点 <code>root</code> ，以及树中两个不同节点的值 <code>x</code> 和 <code>y</code> 。</p>
//
//<p>只有与值 <code>x</code> 和 <code>y</code> 对应的节点是堂兄弟节点时，才返回 <code>true</code> 。否则，返回 <code>false</code>。</p>
//
//<p> </p>
//
//<p><strong>示例 1：<br />
//<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-01.png" style="height: 160px; width: 180px;" /></strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1,2,3,4], x = 4, y = 3
//<strong>输出：</strong>false
//</pre>
//
//<p><strong>示例 2：<br />
//<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-02.png" style="height: 160px; width: 201px;" /></strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1,2,3,null,4,null,5], x = 5, y = 4
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-03.png" style="height: 160px; width: 156px;" /></strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1,2,3,null,4], x = 2, y = 3
//<strong>输出：</strong>false</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>二叉树的节点数介于 <code>2</code> 到 <code>100</code> 之间。</li>
//	<li>每个节点的值都是唯一的、范围为 <code>1</code> 到 <code>100</code> 的整数。</li>
//</ul>
//
//<p> </p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 252</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.*;

public class leetCode993_CousinsInBinaryTree{
      public static void main(String[] args) {
           Solution solution = new leetCode993_CousinsInBinaryTree().new Solution();

           TreeNode root = new TreeNode(1);
           TreeNode left = new TreeNode(2);
           TreeNode right = new TreeNode(3);

           root.left = left;
           root.right =right;

           left.left = new TreeNode(4);

           solution.isCousins(root, 4, 3);
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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

//        List<TreeNode> parents = new ArrayList<>();
//        List<Integer> depthList = new ArrayList<>();
        TreeNode parents = null;
        int targetDepth = 0;

        int depth = 0;
        boolean result = false;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode cur = queue.poll();

                if(cur.left != null)
                    queue.add(cur.left);

                if(cur.right != null)
                    queue.add(cur.right);

                if((cur.left != null && (cur.left.val == x || cur.left.val == y))
                        || (cur.right != null && (cur.right.val == x || cur.right.val == y) )){
//                    if(!parents.contains(cur) && parents.size() != 0){
//                        //得到深度
//                        int nowDepth = depthList.get(0);
//                        if(depth + 1 == nowDepth)
//                            result = true;
//                    }
                    if(parents != null && parents != cur){
                        if(targetDepth == depth + 1)
                            result = true;
                    }
//                    parents.add(cur);
//                    depthList.add(depth + 1);
                    parents = cur ;
                    targetDepth = depth + 1;
                }
            }

            depth++;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }