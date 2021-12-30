//给定一个 N 叉树，返回其节点值的 前序遍历 。 
//
// N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
// 
// 
//
// 进阶： 
//
// 递归法很简单，你可以使用迭代法完成此题吗? 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[1,3,5,6,2,4]
// 
//示例 2：
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
// 
//
// 
//
// 提示： 
//
// 
// N 叉树的高度小于或等于 1000 
// 节点总数在范围 [0, 10^4] 内 
// 
// 
// 
// Related Topics 栈 树 深度优先搜索 👍 196 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetCode589_NAryTreePreorderTraversal{
      public static void main(String[] args) {
           Solution solution = new leetCode589_NAryTreePreorderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> result=new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {

        if(root == null)
            return result;

        result.add(root.val);

        for(int i=0;i<root.children.size();i++)
        {
            preorder(root.children.get(i));
        }

        return result;
    }


    //非递归版本
//    public List<Integer> preorder(Node root) {
//        if(root == null)
//            return result;
//
//        Stack<Node> stack=new Stack<Node>();
//
//        stack.push(root);
//
//        while(!stack.isEmpty())
//        {
//            Node node=stack.pop();
//
//            result.add(node.val);
//
//            for(int i=node.children.size()-1;i>=0;i--)
//            {
//                Node child=node.children.get(i);
//
//                if(child != null)
//                    stack.push(child);
//            }
//        }
//
//        return result;
//    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }