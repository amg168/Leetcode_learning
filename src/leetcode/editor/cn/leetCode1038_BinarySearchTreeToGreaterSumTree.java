//<p><span style="font-size:10.5pt"><span style="font-family:Calibri"><span style="font-size:10.5000pt"><span style="font-family:宋体"><font face="宋体">给定一个二叉搜索树</font></span></span></span></span>&nbsp;<code>root</code>&nbsp;(BST)<span style="font-size:10.5pt"><span style="font-family:Calibri"><span style="font-size:10.5000pt"><span style="font-family:宋体"><font face="宋体">，请将它的每个</font></span></span></span></span>节点<span style="font-size:10.5pt"><span style="font-family:Calibri"><span style="font-size:10.5000pt"><span style="font-family:宋体"><font face="宋体">的值替换成树中大于或者等于该</font></span></span></span></span>节点<span style="font-size:10.5pt"><span style="font-family:Calibri"><span style="font-size:10.5000pt"><span style="font-family:宋体"><font face="宋体">值的所有</font></span></span></span></span>节点<span style="font-size:10.5pt"><span style="font-family:Calibri"><span style="font-size:10.5000pt"><span style="font-family:宋体"><font face="宋体">值之和。</font></span></span></span></span></p>
//
//<p>提醒一下， <em>二叉搜索树</em> 满足下列约束条件：</p>
//
//<ul>
//	<li>节点的左子树仅包含键<strong> 小于 </strong>节点键的节点。</li>
//	<li>节点的右子树仅包含键<strong> 大于</strong> 节点键的节点。</li>
//	<li>左右子树也必须是二叉搜索树。</li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/05/03/tree.png" style="height:273px; width:400px" /></strong></p>
//
//<pre>
//<strong>输入：</strong>[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//<strong>输出：</strong>[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [0,null,1]
//<strong>输出：</strong>[1,null,1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中的节点数在&nbsp;<code>[1, 100]</code>&nbsp;范围内。</li>
//	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
//	<li>树中的所有值均 <strong>不重复</strong>&nbsp;。</li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>注意：</strong>该题目与 538:&nbsp;<a href="https://leetcode-cn.com/problems/convert-bst-to-greater-tree/">https://leetcode-cn.com/problems/convert-bst-to-greater-tree/&nbsp; </a>相同</p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 174</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.*;

public class leetCode1038_BinarySearchTreeToGreaterSumTree{
      public static void main(String[] args) {
           Solution solution = new leetCode1038_BinarySearchTreeToGreaterSumTree().new Solution();

           Integer[] arr = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
           TreeNode root = GenerateBinaryTreeFromArray.generateBT(arr);

           solution.rightInOrder(root);
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
    先通过中序遍历得到递增序列，然后进行累加
     */
//    List<Integer> nodelist = new ArrayList<>();
//    TreeNode cur = null;
//    public TreeNode bstToGst(TreeNode root) {
//
//        InOrder(root);
//        cur = root;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()){
//            int size = queue.size();
//
//            for(int i = 0 ; i < size ; i++){
//                cur = queue.poll();
//                int index = nodelist.indexOf(cur.val);
//                int count  = 0 ;
//                for(int j = index ; j < nodelist.size() ; j++){
//                    count += nodelist.get(j);
//                }
//
//                cur.val = count;
//
//                if(cur.left != null)
//                    queue.add(cur.left);
//
//                if(cur.right != null){
//                    queue.add(cur.right);
//                }
//            }
//        }
//
//        return root;
//    }
//
//    public void InOrder(TreeNode root){
//        if(root == null)
//            return;
//
//        InOrder(root.left);
//        nodelist.add(root.val);
//        InOrder(root.right);
//    }

    public TreeNode bstToGst(TreeNode root) {
        return rightInOrder(root);
    }

    //实现从最右侧节点到根到左侧节点的遍历
    public TreeNode rightInOrder(TreeNode root){
        if(root == null)
            return root;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.right;
            }

            if(!stack.isEmpty()){
                node = stack.pop();
                count += node.val;
                node.val = count;
                node = node.left;
            }
        }

        return  root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }