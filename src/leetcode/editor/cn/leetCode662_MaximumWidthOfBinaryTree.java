//<p>给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与<strong>满二叉树（full binary tree）</strong>结构相同，但一些节点为空。</p>
//
//<p>每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的<code>null</code>节点也计入长度）之间的长度。</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> 
//
//           1
//         /   \
//        3     2
//       / \     \  
//      5   3     9 
//
//<strong>输出:</strong> 4
//<strong>解释:</strong> 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> 
//
//          1
//         /  
//        3    
//       / \       
//      5   3     
//
//<strong>输出:</strong> 2
//<strong>解释:</strong> 最大值出现在树的第 3 层，宽度为 2 (5,3)。
//</pre>
//
//<p><strong>示例&nbsp;3:</strong></p>
//
//<pre>
//<strong>输入:</strong> 
//
//          1
//         / \
//        3   2 
//       /        
//      5      
//
//<strong>输出:</strong> 2
//<strong>解释:</strong> 最大值出现在树的第 2 层，宽度为 2 (3,2)。
//</pre>
//
//<p><strong>示例 4:</strong></p>
//
//<pre>
//<strong>输入:</strong> 
//
//          1
//         / \
//        3   2
//       /     \  
//      5       9 
//     /         \
//    6           7
//<strong>输出:</strong> 8
//<strong>解释:</strong> 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
//</pre>
//
//<p><strong>注意:</strong> 答案在32位有符号整数的表示范围内。</p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 294</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class leetCode662_MaximumWidthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new leetCode662_MaximumWidthOfBinaryTree().new Solution();
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
    public int widthOfBinaryTree(TreeNode root) {
        //层序遍历得到每一层最左不为空的节点和最右边不为空的节点之间的距离
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root , 0 ,0));

        int curDepth = 0, left = 0, ans = 0;

        while(!queue.isEmpty()){
            AnnotatedNode cur = queue.poll();

            if(cur.node != null){
                queue.add(new AnnotatedNode(cur.node.left , cur.depth + 1 , cur.pos * 2));
                queue.add(new AnnotatedNode(cur.node.right , cur.depth + 1 , cur.pos * 2 + 1));

                if (curDepth != cur.depth) {
                    curDepth = cur.depth;
                    left = cur.pos;
                }
                ans = Math.max(ans, cur.pos - left + 1);
            }

        }

        return  ans;
    }

    class AnnotatedNode {
        TreeNode node;
        int depth, pos;

        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }