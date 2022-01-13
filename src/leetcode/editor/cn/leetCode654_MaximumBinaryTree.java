//给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下： 
//
// 
// 二叉树的根是数组 nums 中的最大元素。 
// 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。 
// 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。 
// 
//
// 返回有给定数组 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 362 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class leetCode654_MaximumBinaryTree{
      public static void main(String[] args) {

          Solution solution = new leetCode654_MaximumBinaryTree().new Solution();

          int[] nums = {3,2,1,6,0,5};
          solution.constructMaximumBinaryTree(nums);
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)
            return null;

        int[] firstMax = getMax(nums);

        TreeNode root = null;
        TreeNode left ;
        TreeNode right = null;

        root = new TreeNode(firstMax[1]);

        if(nums.length == 1) {
            root.left = null;
            root.right = null;
        }
        else{

            if(firstMax[0] == 0)
                left = null;
            else
                left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,firstMax[0]));

            if(firstMax[0] == nums.length - 1)
                right = null;
            else
                right= constructMaximumBinaryTree(Arrays.copyOfRange(nums,firstMax[0]+  1, nums.length));

            root.left = left;
            root.right = right;
        }

        return root;
    }

    //返回最大值和坐标
    public int[] getMax(int[] nums){
        int index = 0;
        int Max = Integer.MIN_VALUE;

        for(int i = 0 ;i < nums.length ; i++){
            if(nums[i] > Max){
                Max = nums[i];

                index = i;
            }

        }

        int[] result = new int[2];
        result[0] = index ;
        result[1] = Max;

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }