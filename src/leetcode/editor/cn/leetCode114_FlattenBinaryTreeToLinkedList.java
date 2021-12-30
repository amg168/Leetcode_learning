//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1005 👎 0

  
package leetcode.editor.cn;

import leetcode.editor.cn.common.TestTree;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class leetCode114_FlattenBinaryTreeToLinkedList{
      public static void main(String[] args) {
          Solution solution = new leetCode114_FlattenBinaryTreeToLinkedList().new Solution();

          TestTree testTree = new TestTree();
          TreeNode root = testTree.getTestBT();

//          solution.preOrder(root);
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
    解法1：通过前序遍历将节点顺序存入list中，然后通过遍历list将节点串联起来
     */
//    List<TreeNode> nodeList = new ArrayList<>();
//
//    public void flatten(TreeNode root) {
//        preOrder(root);
//        //根据nodelist重构
//        for(int i = 0; i < nodeList.size(); i++){
//            if(i != nodeList.size() -1){
//                nodeList.get(i).left = null;
//                nodeList.get(i).right = nodeList.get(i + 1);
//            }else{
//                nodeList.get(i).left = null;
//                nodeList.get(i).right = null;
//            }
//        }
//    }
//
//    public void preOrder(TreeNode root){
//        if(root == null)
//            return;
//        //更新节点信息
//        nodeList.add(root);
//        preOrder(root.left);
//        preOrder(root.right);
//    }

    /*
    解法2：使用方法一的前序遍历，由于将节点展开之后会破坏二叉树的结构而丢失子节点的信息，
    因此前序遍历和展开为单链表分成了两步。能不能在不丢失子节点的信息的情况下，将前序遍历和展开为单链表同时进行？
    之所以会在破坏二叉树的结构之后丢失子节点的信息，是因为在对左子树进行遍历时，没有存储右子节点的信息，
    在遍历完左子树之后才获得右子节点的信息。只要对前序遍历进行修改，在遍历左子树之前就获得左右子节点的信息，
    并存入栈内，子节点的信息就不会丢失，就可以将前序遍历和展开为单链表同时进行。
    该做法不适用于递归实现的前序遍历，只适用于迭代实现的前序遍历。
    修改后的前序遍历的具体做法是，每次从栈内弹出一个节点作为当前访问的节点，获得该节点的子节点，
    如果子节点不为空，则依次将右子节点和左子节点压入栈内（注意入栈顺序）。
    展开为单链表的做法是，维护上一个访问的节点 prev，每次访问一个节点时，
    令当前访问的节点为 curr，将 prev 的左子节点设为 null 以及将 prev 的右子节点设为 curr，然后将 curr 赋值给 prev，进入下一个节点的访问，
    直到遍历结束。需要注意的是，初始时 prev 为 null，只有在 prev 不为 null 时才能对 prev 的左右子节点进行更新。
     */
//    public void flatten(TreeNode root) {
//        if(root == null)
//            return;
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        TreeNode pre =  null;
//
//        while(!stack.isEmpty()){
//            TreeNode cur = stack.pop();
//            if(pre != null){
//                pre.left = null;
//                pre.right = cur;
//            }
//
//            TreeNode left = cur.left;
//            TreeNode right = cur.right;
//
//            if(right != null)
//                stack.push(right);
//
//            if(left != null)
//                stack.push(left);
//
//            pre = cur;
//        }
//    }

    /*
    解法3：
    对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，
    作为前驱节点，将当前节点的右子节点赋给前驱节点的右子节点，
    然后将当前节点的左子节点赋给当前节点的右子节点，
    并将当前节点的左子节点设为空。对当前节点处理结束后，
    继续处理链表中的下一个节点，直到所有节点都处理结束。
     */
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }