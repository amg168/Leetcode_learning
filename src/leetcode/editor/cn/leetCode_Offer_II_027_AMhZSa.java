//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 10⁵] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 👍 19 👎 0

  
package leetcode.editor.cn;
public class leetCode_Offer_II_027_AMhZSa{
      public static void main(String[] args) {
           Solution solution = new  leetCode_Offer_II_027_AMhZSa().new Solution();
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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;

        ListNode fast=head;

        //标志中间节点
        ListNode middle=null;

        //快慢指针，当快指针走到最后时，慢指针走到正中间
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;

            fast=fast.next.next;
        }

        middle=slow;

        //从慢指针往后将链表反转
        ListNode newHead=null;

        ListNode middleNext=middle.next;

        while(middleNext != null)
        {
            ListNode temp=middleNext.next;

            middleNext.next=newHead;

            newHead=middleNext;

            middleNext=temp;
        }

        //分别从两头来时遍历，得到的节点相应的数据域相等，则为回文链表，否则不是回文链表
        boolean isPalindrome=true;

        ListNode startNode=head;

        while(newHead !=null)
        {
            if(startNode.val != newHead.val)
                isPalindrome=false;

            startNode=startNode.next;

            newHead=newHead.next;
        }

        //将中间节点到最后节点反转过来
        ListNode nextmiddle=middle.next;

        ListNode p4=null;

        while(nextmiddle !=null)
        {
            p4=nextmiddle.next;

            nextmiddle.next=middle;

            middle=nextmiddle;

            nextmiddle=p4;
        }

        return isPalindrome;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }