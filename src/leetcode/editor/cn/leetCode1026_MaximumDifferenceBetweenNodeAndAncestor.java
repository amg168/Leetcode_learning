//<p>给定二叉树的根节点 <code>root</code>，找出存在于 <strong>不同</strong> 节点 <code>A</code> 和 <code>B</code> 之间的最大值 <code>V</code>，其中 <code>V = |A.val - B.val|</code>，且 <code>A</code> 是 <code>B</code> 的祖先。</p>
//
//<p>（如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/09/tmp-tree.jpg" style="width: 400px; height: 390px;" /></p>
//
//<pre>
//<strong>输入：</strong>root = [8,3,10,1,6,null,14,null,null,4,7,13]
//<strong>输出：</strong>7
//<strong>解释： </strong>
//我们有大量的节点与其祖先的差值，其中一些如下：
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/09/tmp-tree-1.jpg" style="width: 250px; height: 349px;" />
//<pre>
//<strong>输入：</strong>root = [1,null,2,null,0,3]
//<strong>输出：</strong>3
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中的节点数在 <code>2</code> 到 <code>5000</code> 之间。</li>
//	<li><code>0 <= Node.val <= 10<sup>5</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 113</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.*;

public class leetCode1026_MaximumDifferenceBetweenNodeAndAncestor{
      public static void main(String[] args) {
           Solution solution = new leetCode1026_MaximumDifferenceBetweenNodeAndAncestor().new Solution();

           Integer[] arr = {8,3,10,1,6,null,14,null,null,4,7,13};
           TreeNode root = GenerateBinaryTreeFromArray.generateBT(arr);

           solution.maxAncestorDiff(root);
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
    List<Integer> result = new ArrayList<>();
    int resultValue = Integer.MIN_VALUE;
    int res = Integer.MIN_VALUE;


    public int maxAncestorDiff(TreeNode root) {
        if(root == null)
            return 0;
//
//        dfs(root,result);
//
//        return resultValue;
        dfs(root, root.val , root.val);

        return res;

    }

    /*
    我自己写的垃圾
     */
//    public List<Integer> dfs(TreeNode root,List<Integer> list){
//        if(root == null)
//            return  null;
//
//        list.add(root.val);
//
//        if(root.left == null && root.right == null) {
//            System.out.println(list);
//            int minValue = Integer.MAX_VALUE;
//            int maxValue = Integer.MIN_VALUE;
//
//            for(int i = 0 ; i <list.size() ;i++){
//                int number = list.get(i);
//                if(number > maxValue)
//                    maxValue = number;
//                if(number < minValue)
//                    minValue = number;
//            }
//
//            resultValue = resultValue > maxValue - minValue ? resultValue : maxValue - minValue;
//        }
//
//        dfs(root.left,list);
//        dfs(root.right,list);
//        list.remove(list.size() - 1);
//
//        return list;
//    }

    /*
    改进的dfs,保存每条从根节点到叶子节点中的最大值和最小值，进行更新
     */
    public void dfs(TreeNode root, int max ,int min) {
        if(root == null)
            return;

        max = Math.max(root.val , max);
        min = Math.min(root.val, min);

        if(root.left == null && root.right == null) {
            res  = Math.max(res , Math.abs(max - min));
        }

        dfs(root.left,max, min);
        dfs(root.right,max, min);
    }

    
}
//leetcode submit region end(Prohibit modification and deletion)

  }