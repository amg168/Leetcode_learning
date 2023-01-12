//<p>给你&nbsp;<code>root1</code> 和 <code>root2</code>&nbsp;这两棵二叉搜索树。请你返回一个列表，其中包含&nbsp;<strong>两棵树&nbsp;</strong>中的所有整数并按 <strong>升序</strong> 排序。.</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/29/q2-e1.png" /></p>
//
//<pre>
//<strong>输入：</strong>root1 = [2,1,4], root2 = [1,0,3]
//<strong>输出：</strong>[0,1,1,2,3,4]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/29/q2-e5-.png" /></p>
//
//<pre>
//<strong>输入：</strong>root1 = [1,null,8], root2 = [8,1]
//<strong>输出：</strong>[1,1,8,8]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>每棵树的节点数在&nbsp;<code>[0, 5000]</code> 范围内</li> 
// <li><code>-10<sup>5</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li><li>排序</li></div></div><br><div><li>👍 162</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class leetCode1305_AllElementsInTwoBinarySearchTrees{
      public static void main(String[] args) {
           Solution solution = new leetCode1305_AllElementsInTwoBinarySearchTrees().new Solution();

           Integer[] arr = {6,2,9,1,5,8,10};
           Integer[] arr1 = {8,4,10,3,7};

           TreeNode root1 = GenerateBinaryTreeFromArray.generateBT(arr);
           TreeNode root2 = GenerateBinaryTreeFromArray.generateBT(arr1);

           solution.getAllElements(root1, root2);

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
    垃圾代码也算是通过了，哎，心累
    执行耗时:19 ms,击败了36.20% 的Java用户
	内存消耗:43.9 MB,击败了41.93% 的Java用户
     */
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //中序遍历搜索二叉树，得到递增序列
        preOrder(root1, list1);
        preOrder(root2,list2);

        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()) {
            if (list1.get(i) > list2.get(j)) {
                result.add(list2.get(j));
                j++;
            } else {
                result.add(list1.get(i));
                i++;
            }
        }

        while(i <= list1.size() - 1){
            result.add(list1.get(i));
            i++;
        }


        while(j <= list2.size() - 1) {
            result.add(list2.get(j));
            j++;
        }

        return  result;
    }

    public void preOrder(TreeNode root,List<Integer> list){
        if(root == null)
            return;

        preOrder(root.left, list);
        list.add(root.val);
        preOrder(root.right,list);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }