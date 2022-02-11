//<p><strong>完全二叉树</strong> 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。</p>
//
//<p>设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。</p>
//
//<p>实现 <code>CBTInserter</code> 类:</p>
//
//<ul>
//	<li><code>CBTInserter(TreeNode root)</code>&nbsp;使用头节点为&nbsp;<code>root</code>&nbsp;的给定树初始化该数据结构；</li>
//	<li><code>CBTInserter.insert(int v)</code>&nbsp; 向树中插入一个值为&nbsp;<code>Node.val == val</code>的新节点&nbsp;<code>TreeNode</code>。使树保持完全二叉树的状态，<strong>并返回插入节点</strong>&nbsp;<code>TreeNode</code>&nbsp;<strong>的父节点的值</strong>；</li>
//	<li><code>CBTInserter.get_root()</code> 将返回树的头节点。</li>
//</ul>
//
//<p>&nbsp;</p>
//
//<ol>
//</ol>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img src="https://assets.leetcode.com/uploads/2021/08/03/lc-treeinsert.jpg" style="height: 143px; width: 500px;" /></p>
//
//<pre>
//<strong>输入</strong>
//["CBTInserter", "insert", "insert", "get_root"]
//[[[1, 2]], [3], [4], []]
//<strong>输出</strong>
//[null, 1, 2, [1, 2, 3, 4]]
//
//<strong>解释</strong>
//CBTInserter cBTInserter = new CBTInserter([1, 2]);
//cBTInserter.insert(3);  // 返回 1
//cBTInserter.insert(4);  // 返回 2
//cBTInserter.get_root(); // 返回 [1, 2, 3, 4]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中节点数量范围为&nbsp;<code>[1, 1000]</code>&nbsp;</li>
//	<li><code>0 &lt;= Node.val &lt;= 5000</code></li>
//	<li><code>root</code>&nbsp;是完全二叉树</li>
//	<li><code>0 &lt;= val &lt;= 5000</code>&nbsp;</li>
//	<li>每个测试用例最多调用&nbsp;<code>insert</code>&nbsp;和&nbsp;<code>get_root</code>&nbsp;操作&nbsp;<code>10<sup>4</sup></code>&nbsp;次</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>设计</li><li>二叉树</li></div></div><br><div><li>👍 59</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetCode919_CompleteBinaryTreeInserter{
      public static void main(String[] args) {
          TreeNode root = new TreeNode(1);
          root.left = new TreeNode(2);

          CBTInserter solution = new leetCode919_CompleteBinaryTreeInserter().new CBTInserter(root);
          solution.insert(3);
          solution.insert(4);
          solution.get_root();

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
class CBTInserter {

    Queue<TreeNode> queue ;
    List<TreeNode> nodeList;

    public CBTInserter(TreeNode root) {
        queue = new ArrayDeque<>();
        nodeList = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0 ;i < size;i++){
                TreeNode cur = queue.poll();
                nodeList.add(cur);

                if(cur.left != null)
                    queue.add(cur.left);

                if(cur.right != null)
                    queue.add(cur.right);
            }
        }

    }
    
    public int insert(int val) {
        //当期节点的索引为i时，其父节点的索引为(i - 1) / 2
        TreeNode node = new TreeNode(val);
        nodeList.add(node);
        //得到其父节点
        TreeNode parent = nodeList.get((nodeList.size() - 2) / 2);
        if(parent.left == null)
            parent.left = node;
        else
            parent.right = node;

        //新添加的节点为queue.size() - 1
        return nodeList.get((nodeList.size() - 2) / 2).val;
    }
    
    public TreeNode get_root() {
        return nodeList.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
//leetcode submit region end(Prohibit modification and deletion)

  }