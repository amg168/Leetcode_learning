//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 355 👎 0

  
package leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetCode652_FindDuplicateSubtrees{
      public static void main(String[] args) {
           Solution solution = new leetCode652_FindDuplicateSubtrees().new Solution();
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
    //统计每个节点的序列出现的次数
    Map<String,Integer> map = new HashMap<>();

    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findDumplicatTreesByNode(root);

        return  result;
    }

    //通过序列化得到某节点的字符串序列
    public String findDumplicatTreesByNode(TreeNode node){
        if(node == null)
            return "#";

        String serial = node.val + "," + findDumplicatTreesByNode(node.left) + "," + findDumplicatTreesByNode(node.right);

        map.put(serial,map.getOrDefault(serial,0)+1);

        if(map.get(serial) == 2)
            result.add(node);

        return serial;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }