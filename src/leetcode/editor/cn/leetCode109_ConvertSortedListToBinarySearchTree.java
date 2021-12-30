//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 631 👎 0

  
package leetcode.editor.cn;
public class leetCode109_ConvertSortedListToBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new leetCode109_ConvertSortedListToBinarySearchTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return generateBST(head,null);
    }

    public TreeNode generateBST(ListNode left,ListNode right)
    {
        if(left == right)
            return null;

        ListNode mid = getMid(left,right);

        TreeNode root = new TreeNode(mid.val);

        root.left = generateBST(left,mid);

        root.right = generateBST(mid.next,right);

        return root;
    }

    public ListNode getMid(ListNode left,ListNode right)
    {
        ListNode fast = left;

        ListNode slow = left;

        while(fast != right && fast.next != right)
        {
            fast =fast.next.next;

            slow = slow.next;
        }

        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }