//<p>给出一个满足下述规则的二叉树：</p>
//
//<ol> 
// <li><code>root.val == 0</code></li> 
// <li>如果 <code>treeNode.val == x</code> 且&nbsp;<code>treeNode.left != null</code>，那么&nbsp;<code>treeNode.left.val == 2 * x + 1</code></li> 
// <li>如果 <code>treeNode.val == x</code> 且 <code>treeNode.right != null</code>，那么&nbsp;<code>treeNode.right.val == 2 * x + 2</code></li> 
//</ol>
//
//<p>现在这个二叉树受到「污染」，所有的&nbsp;<code>treeNode.val</code>&nbsp;都变成了&nbsp;<code>-1</code>。</p>
//
//<p>请你先还原二叉树，然后实现&nbsp;<code>FindElements</code>&nbsp;类：</p>
//
//<ul> 
// <li><code>FindElements(TreeNode* root)</code>&nbsp;用受污染的二叉树初始化对象，你需要先把它还原。</li> 
// <li><code>bool find(int target)</code>&nbsp;判断目标值&nbsp;<code>target</code>&nbsp;是否存在于还原后的二叉树中并返回结果。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/16/untitled-diagram-4-1.jpg" style="height: 119px; width: 320px;" /></strong></p>
//
//<pre><strong>输入：</strong>
//["FindElements","find","find"]
//[[[-1,null,-1]],[1],[2]]
//<strong>输出：</strong>
//[null,false,true]
//<strong>解释：</strong>
//FindElements findElements = new FindElements([-1,null,-1]); 
//findElements.find(1); // return False 
//findElements.find(2); // return True </pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/16/untitled-diagram-4.jpg" style="height: 198px; width: 400px;" /></strong></p>
//
//<pre><strong>输入：</strong>
//["FindElements","find","find","find"]
//[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
//<strong>输出：</strong>
//[null,true,true,false]
//<strong>解释：</strong>
//FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
//findElements.find(1); // return True
//findElements.find(3); // return True
//findElements.find(5); // return False</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/16/untitled-diagram-4-1-1.jpg" style="height: 274px; width: 306px;" /></strong></p>
//
//<pre><strong>输入：</strong>
//["FindElements","find","find","find","find"]
//[[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
//<strong>输出：</strong>
//[null,true,false,false,true]
//<strong>解释：</strong>
//FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
//findElements.find(2); // return True
//findElements.find(3); // return False
//findElements.find(4); // return False
//findElements.find(5); // return True
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>TreeNode.val == -1</code></li> 
// <li>二叉树的高度不超过&nbsp;<code>20</code></li> 
// <li>节点的总数在&nbsp;<code>[1,&nbsp;10^4]</code>&nbsp;之间</li> 
// <li>调用&nbsp;<code>find()</code>&nbsp;的总次数在&nbsp;<code>[1,&nbsp;10^4]</code>&nbsp;之间</li> 
// <li><code>0 &lt;= target &lt;= 10^6</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>设计</li><li>哈希表</li><li>二叉树</li></div></div><br><div><li>👍 41</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetCode1261_FindElementsInAContaminatedBinaryTree{
      public static void main(String[] args) {
          TreeNode root = GenerateBinaryTreeFromArray.generateBT(new Integer[]{-1,-1,-1,-1,-1});
          FindElements solution = new leetCode1261_FindElementsInAContaminatedBinaryTree().new FindElements(root);

          System.out.println(solution.find(3));
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
class FindElements {
    //将元素存在一个list中
    List<Integer> nodeValueList = new ArrayList<>();

    public FindElements(TreeNode root) {
        if(root == null )
            return;

        if(root.val != 0)
            root.val = 0;

        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ;i < size ;i++){
                TreeNode cur = queue.poll();
                nodeValueList.add(cur.val);

                if(cur.left != null) {
                    queue.add(cur.left);
                    if(cur.left.val != cur.val * 2 + 1)
                        cur.left.val = cur.val * 2 + 1;
                }

                if(cur.right != null) {
                    queue.add(cur.right);
                    if(cur.right.val != cur.val * 2 + 2)
                        cur.right.val = cur.val * 2 + 2;
                }
            }
        }

    }
    
    public boolean find(int target) {
        return nodeValueList.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }