//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 632 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class leetCode106_ConstructBinaryTreeFromInorderAndPostorderTraversal{
      public static void main(String[] args) {
           Solution solution = new leetCode106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inorderLength=inorder.length;

        int postorderLength=postorder.length;

        if(inorderLength ==0 || postorderLength == 0)
            return null;

        int rootVal=postorder[postorderLength-1];

        TreeNode root;

        TreeNode rootLeftChild;

        TreeNode rootRightChild;

        //找到左子树和右子树的根，链接到根节点
        int[] leftList;

        int[] rightList;

        if(postorderLength !=1)
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

            leftList= Arrays.copyOfRange(inorder, 0, rootIndex);

            rightList=Arrays.copyOfRange(inorder, rootIndex+1, inorderLength);

            //构建左子树
            rootLeftChild=buildTree(leftList, Arrays.copyOfRange(postorder, 0, leftList.length));

            //构建右子树,如果左子树不存在
            if(leftList.length != 0)
                rootRightChild=buildTree(rightList, Arrays.copyOfRange(postorder, leftList.length,postorderLength-1));
            else
                rootRightChild=buildTree(rightList, Arrays.copyOfRange(postorder, 0,postorderLength-1));

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