//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1333 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class leetCode105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new leetCode105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inorderLength=inorder.length;

        int preorderLength=preorder.length;

        if(inorderLength ==0 || preorderLength == 0)
            return null;

        int rootVal=preorder[0];

        TreeNode root;

        TreeNode rootLeftChild;

        TreeNode rootRightChild;

        //找到左子树和右子树的根，链接到根节点
        int[] leftList;

        int[] rightList;

        if(inorderLength !=1)
        {
            int rootIndex=0;
            for(int i=0;i<inorderLength;i++)
            {
                if(inorder[i] == rootVal)
                {
                    rootIndex=i;

                    break;
                }
            }

            leftList=Arrays.copyOfRange(inorder, 0, rootIndex);

            rightList=Arrays.copyOfRange(inorder, rootIndex+1, inorderLength);

            //构建左子树
            rootLeftChild=buildTree(Arrays.copyOfRange(preorder, 1, leftList.length+1),leftList);

            //构建右子树,如果左子树不存在
            if(leftList.length != 0)
                rootRightChild=buildTree( Arrays.copyOfRange(preorder, leftList.length+1,preorderLength),rightList);
            else
                rootRightChild=buildTree(Arrays.copyOfRange(preorder, 1,preorderLength),rightList);

            root=new TreeNode(rootVal,rootLeftChild,rootRightChild);
        }
        else
        {
            root=new TreeNode(rootVal,null,null);
        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }