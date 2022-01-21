//<p>请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 <strong>叶值序列 </strong>。</p>
//
//<p><img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/16/tree.png" style="height: 240px; width: 300px;" /></p>
//
//<p>举个例子，如上图所示，给定一棵叶值序列为 <code>(6, 7, 4, 9, 8)</code> 的树。</p>
//
//<p>如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 <em>叶相似 </em>的。</p>
//
//<p>如果给定的两个根结点分别为 <code>root1</code> 和 <code>root2</code> 的树是叶相似的，则返回 <code>true</code>；否则返回 <code>false</code> 。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/03/leaf-similar-1.jpg" style="height: 297px; width: 750px;" /></p>
//
//<pre>
//<strong>输入：</strong>root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>root1 = [1], root2 = [1]
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>root1 = [1], root2 = [2]
//<strong>输出：</strong>false
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre>
//<strong>输入：</strong>root1 = [1,2], root2 = [2,2]
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例 5：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/03/leaf-similar-2.jpg" style="height: 165px; width: 450px;" /></p>
//
//<pre>
//<strong>输入：</strong>root1 = [1,2,3], root2 = [1,3,2]
//<strong>输出：</strong>false
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>给定的两棵树可能会有 <code>1</code> 到 <code>200</code> 个结点。</li>
//	<li>给定的两棵树上的值介于 <code>0</code> 到 <code>200</code> 之间。</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 179</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class leetCode872_LeafSimilarTrees{
      public static void main(String[] args) {
          Solution solution = new leetCode872_LeafSimilarTrees().new Solution();

          TreeNode root1 = new TreeNode(1);
          TreeNode root2 = new TreeNode(1);

          root1.left = new TreeNode(2);
          root1.right = new TreeNode(3);

          root2.left = new TreeNode(3);
          root2.right = new TreeNode(2);

          solution.leafSimilar(root1,root2);
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
    /*
    本人写的垃圾算法
     */
//    List<Integer> list1 = new ArrayList<>();
//    List<Integer> list2 = new ArrayList<>();
//    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
//        allLeaves(root1);
//        allLeaves2(root2);
//        if(root1 == null || root2 == null)
//            return false;
//        boolean result = true;
//        int size1 = list1.size();
//        int size2 = list2.size();
//        if(size1 != size2)
//            return false;
//        else{
//            for(int i = 0 ;i < list1.size() ;i++){
//                if(list1.get(i) !=  list2.get(i))
//                    result = false;
//            }
//        }
//
//
//        return result;
//    }
//
//    //得到所有叶子节点
//    public void allLeaves(TreeNode root){
//        if(root == null)
//            return;
//
//        if(root.left == null && root.right == null){
//            list1.add(root.val);
//
//            return;
//        }
//
//        allLeaves(root.left);
//        allLeaves(root.right);
//    }
//
//    public void allLeaves2(TreeNode root){
//        if(root == null)
//            return;
//
//        if(root.left == null && root.right == null){
//            list2.add(root.val);
//
//            return;
//        }
//
//        allLeaves2(root.left);
//        allLeaves2(root.right);
//    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();

        if(root1 != null)
            dfs(root1,list1);

        List<Integer> list2= new ArrayList<>();

        if(root2 != null)
            dfs(root2, list2);

        return list1.equals(list2);
    }

    public void dfs(TreeNode root,List<Integer> list){
        if(root.left == null && root.right == null)
            list.add(root.val);
        else{
            if(root.left != null){
                dfs(root.left,list);
            }
            if(root.right != null)
                dfs(root.right,list);
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

  }