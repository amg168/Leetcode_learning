//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 452 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetCode349_IntersectionOfTwoArrays{
      public static void main(String[] args) {
           Solution solution = new leetCode349_IntersectionOfTwoArrays().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<Integer>();

        Set<Integer> set2=new HashSet<Integer>();

        for(int i=0;i<nums1.length;i++)
        {
            set1.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++)
        {
            if(set1.contains(nums2[i]))
                set2.add(nums2[i]);
        }

        Integer[] temp=set2.toArray(new Integer[0]);

        return Arrays.stream(temp).mapToInt(Integer::valueOf).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }