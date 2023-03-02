//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 543 👎 0

  
package leetcode.editor.cn;

import leetcode.editor.cn.common.TestBinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetCode230_KthSmallestElementInABst{
      public static void main(String[] args) {
           Solution solution = new leetCode230_KthSmallestElementInABst().new Solution();

          TestBinarySearchTree testBinarySearchTree = new TestBinarySearchTree();
          TreeNode root = testBinarySearchTree.getTestBST();

          System.out.println(solution.kthSmallest(root,5));
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
    解法一:通过中序遍历取得第K个元素
     */
//    List<Integer> result = new ArrayList<>();
//
//    public int kthSmallest(TreeNode root, int k) {
//        if(root == null)
//            return 0;
//
//        inOrder(root);
//
//        return result.get(k-1);
//    }
//
//    //中序遍历得到升序序列
//    public void inOrder(TreeNode root){
//        if(root == null)
//            return;
//        inOrder(root.left);
//        result.add(root.val);
//        inOrder(root.right);
//    }

    /*
    解法二：
    我们可以记录下以每个结点为根结点的子树的结点数，并在查找第 kk 小的值时，使用如下方法搜索：
    node 等于根结点，开始搜索。对当前结点 node 进行如下操作：
        如果 node 的左子树的结点数 left 小于 k-1，则第 k小的元素一定在 node 的右子树中，令 node 等于其的右子结点，k 等于 k−left−1，并继续搜索；
        如果 node 的左子树的结点数 left 等于 k-1，则第 k小的元素即为 node ，结束搜索并返回 node 即可；
        如果 node 的左子树的结点数 left 大于 k-1，则第 K小的元素一定在 node 的左子树中，令 node 等于其左子结点，并继续搜索。
     */
    public int kthSmallest(TreeNode root, int k) {
        Mybst mybst = new Mybst(root);
        return  mybst.kthSmallest(k);
    }
}

class Mybst{

    public TreeNode root;
    public Map<TreeNode, Integer> countMap;

    public Mybst(TreeNode root){
        this.root =  root;
        countMap = new HashMap<>();
        nodeCount(root);
    }

    public int nodeCount(TreeNode node){
        //得到左子树的节点个数
        if(node == null )
            return 0;

        int leftNodeCount = nodeCount(node.left);
        int rightNodeCount = nodeCount(node.right);

        countMap.put(node,leftNodeCount + rightNodeCount + 1);
        return countMap.get(node);
    }

    public int kthSmallest(int k) {
        TreeNode node = root;

        while(node != null){
            int leftCount = countMap.getOrDefault(node.left,0);

            if(leftCount < k - 1){
                node = node.right;
                k -= leftCount + 1;
            }else if(leftCount == k - 1){
                break;
            }else{
                node = node.left;
            }

        }

        return  node.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }