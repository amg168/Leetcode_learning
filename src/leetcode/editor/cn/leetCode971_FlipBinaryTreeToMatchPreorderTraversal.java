//<p>给你一棵二叉树的根节点 <code>root</code> ，树中有 <code>n</code> 个节点，每个节点都有一个不同于其他节点且处于 <code>1</code> 到 <code>n</code> 之间的值。</p>
//
//<p>另给你一个由 <code>n</code> 个值组成的行程序列 <code>voyage</code> ，表示 <strong>预期</strong> 的二叉树 <a href="https://baike.baidu.com/item/%E5%85%88%E5%BA%8F%E9%81%8D%E5%8E%86/6442839?fr=aladdin" target="_blank"><strong>先序遍历</strong></a> 结果。</p>
//
//<p>通过交换节点的左右子树，可以 <strong>翻转</strong> 该二叉树中的任意节点。例，翻转节点 1 的效果如下：</p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/15/fliptree.jpg" style="width: 400px; height: 187px;" />
//<p>请翻转 <strong>最少 </strong>的树中节点，使二叉树的 <strong>先序遍历</strong> 与预期的遍历行程 <code>voyage</code> <strong>相匹配</strong> 。 </p>
//
//<p>如果可以，则返回 <strong>翻转的</strong> 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 <code>[-1]</code>。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2019/01/02/1219-01.png" style="width: 150px; height: 205px;" />
//<pre>
//<strong>输入：</strong>root = [1,2], voyage = [2,1]
//<strong>输出：</strong>[-1]
//<strong>解释：</strong>翻转节点无法令先序遍历匹配预期行程。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2019/01/02/1219-02.png" style="width: 150px; height: 142px;" />
//<pre>
//<strong>输入：</strong>root = [1,2,3], voyage = [1,3,2]
//<strong>输出：</strong>[1]
//<strong>解释：</strong>交换节点 2 和 3 来翻转节点 1 ，先序遍历可以匹配预期行程。</pre>
//
//<p><strong>示例 3：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2019/01/02/1219-02.png" style="width: 150px; height: 142px;" />
//<pre>
//<strong>输入：</strong>root = [1,2,3], voyage = [1,2,3]
//<strong>输出：</strong>[]
//<strong>解释：</strong>先序遍历已经匹配预期行程，所以不需要翻转节点。
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中的节点数目为 <code>n</code></li>
//	<li><code>n == voyage.length</code></li>
//	<li><code>1 <= n <= 100</code></li>
//	<li><code>1 <= Node.val, voyage[i] <= n</code></li>
//	<li>树中的所有值 <strong>互不相同</strong></li>
//	<li><code>voyage</code> 中的所有值 <strong>互不相同</strong></li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 87</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetCode971_FlipBinaryTreeToMatchPreorderTraversal{
      public static void main(String[] args) {
           Solution solution = new leetCode971_FlipBinaryTreeToMatchPreorderTraversal().new Solution();

          Integer[] arr = {1, 2, 3};
           TreeNode  root = GenerateBinaryTreeFromArray.generateBT(arr);
           int[] voyage = {1, 2, 3};

           solution.flipMatchVoyage(root, voyage);
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
    List<Integer> result = new LinkedList<>();
    int i = 0;
    boolean flag;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        preOrder(root,voyage);

        if(flag) {		//不匹配时，返回-1；
            List<Integer> ans = new ArrayList<>();
            ans.add(-1);
            return ans;
        }
        return result;
    }

    public void preOrder(TreeNode root,int[] voyage){
        if(root == null){
            return;
        }

        if(root.val != voyage[i]){
            flag = true;
            return;
        }
        System.out.println("当前i值为:" + i);
        System.out.println("当前root值为:" + root.val);
        //前序遍历打印值
        if(i <  voyage.length && root.left != null && root.left.val != voyage[i + 1]){
            //如果不相等，则应该交换其父节点的左右子树，进行翻转操作后在进行判断
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            result.add(root.val);
        }
        i++;
        preOrder(root.left, voyage);
        preOrder(root.right , voyage);
        System.out.println("当前result值为:" + result);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }