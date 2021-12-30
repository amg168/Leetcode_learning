//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
// Related Topics 树 二叉搜索树 二叉树 👍 605 👎 0

  
package leetcode.editor.cn;

import leetcode.editor.cn.common.TestBinarySearchTree;

public class leetCode450_DeleteNodeInABst{
      public static void main(String[] args) {

          Solution solution = new leetCode450_DeleteNodeInABst().new Solution();

          TestBinarySearchTree testBinarySearchTree = new TestBinarySearchTree();
          TreeNode root = testBinarySearchTree.getTestBST();

          solution.deleteNode(root,4);
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
/*
如果目标节点大于当前节点值，则去右子树中删除；
如果目标节点小于当前节点值，则去左子树中删除；
如果目标节点就是当前节点，分为以下三种情况：
其无左子：其右子顶替其位置，删除了该节点；
其无右子：其左子顶替其位置，删除了该节点；
其左右子节点都有：其左子树转移到其右子树的最左节点的左子树上，然后右子树顶替其位置，由此删除了该节点。
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(key > root.val){
            //迭代到右子树删除
            root.right = deleteNode(root.right , key);
        }else if(key < root.val){
            //迭代到左子树进行删除
            root.left = deleteNode(root.left,key);
        }else{
            //如果等于当前节点的话，判断其左右节点情况
            if(root.left == null){
                //右节点顶替其位置
                root = root.right;
            }else if(root.right == null){
                //左子树顶替其位置
                root = root.left;
            }else{
                //将左子树连接到右子树最左节点的左子树位置上
                TreeNode mostLeftNodeOfRightNode = root.right;
                while(mostLeftNodeOfRightNode.left != null){
                    mostLeftNodeOfRightNode = mostLeftNodeOfRightNode.left;
                }

                mostLeftNodeOfRightNode.left = root.left;

                root = root.right;
            }
        }


        return  root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }