//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。 
//
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。 
//
// 示例 1: 
//
// 
//输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//输出: "1(2(4))(3)"
//
//解释: 原本将是“1(2(4)())(3())”，
//在你省略所有不必要的空括号对之后，
//它将是“1(2(4))(3)”。
// 
//
// 示例 2: 
//
// 
//输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \  
//      4 
//
//输出: "1(2()(4))(3)"
//
//解释: 和第一个示例相似，
//除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 234 👎 0

  
package leetcode.editor.cn;

import leetcode.editor.cn.common.TestTree;
import sun.reflect.generics.tree.Tree;

public class leetCode606_ConstructStringFromBinaryTree{
      public static void main(String[] args) {
           Solution solution = new leetCode606_ConstructStringFromBinaryTree().new Solution();

          TestTree testTree = new TestTree();
          TreeNode root = testTree.getTestBT();
//
//          TreeNode root = new TreeNode(1);
//
//          TreeNode left = new TreeNode(2);
//          TreeNode right = new TreeNode(3);
//
//          root.left = left;
//          root.right = right;
//
//          left.left = new TreeNode(4);
//          left.right = null;

          System.out.println(solution.tree2str(root));
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
    StringBuffer str = new StringBuffer();

//    public String tree2str(TreeNode root) {
//        String result = treeToStr(root);
//
//        return  result.substring(1,result.length() - 1);
//    }
//
//    public String treeToStr(TreeNode root){
//        if(root == null)
//            return "";
//
//        String rootVal = node2Str(root);
//
//        String left = treeToStr(root.left);
//        String right = treeToStr(root.right);
//        if(left.equals("") && !right.equals(""))
//            left += "()";
//
//        if(!left.equals(""))
//            right += ")";
//
//        return rootVal + left + right;
//    }
//
//    public String node2Str(TreeNode node){
//        if(node == null)
//            return "";
//        StringBuilder str = new StringBuilder();
//
////        if(node.left != null && node.right == null)
//////            str.append("(" + node.val + "(" + node.left.val + "))");
//////        else if(node.left == null && node.right != null)
//////            str.append("(" + node.val + "()(" + node.right.val + "))");
//////        else
//        if(node.left != null || node.right != null)
//            str.append("(" + node.val);
//        else
//            str.append("(" + node.val + ")");
//
//        return str.toString();
//    }

    //官方递归算法
    public String tree2str(TreeNode root) {
        if(root==null)
            return "";
        if(root.left==null && root.right==null)
            return root.val+"";
        if(root.right==null)
            return root.val+"("+tree2str(root.left)+")";
        return root.val+"("+tree2str(root.left)+")("+tree2str(root.right)+")";
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }