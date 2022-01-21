//<p>设计一个找到数据流中第 <code>k</code> 大元素的类（class）。注意是排序后的第 <code>k</code> 大元素，不是第 <code>k</code> 个不同的元素。</p>
//
//<p>请实现 <code>KthLargest</code> 类：</p>
//
//<ul>
//	<li><code>KthLargest(int k, int[] nums)</code> 使用整数 <code>k</code> 和整数流 <code>nums</code> 初始化对象。</li>
//	<li><code>int add(int val)</code> 将 <code>val</code> 插入数据流 <code>nums</code> 后，返回当前数据流中第 <code>k</code> 大的元素。</li>
//</ul>
//
//<p> </p>
//
//<p><strong>示例：</strong></p>
//
//<pre>
//<strong>输入：</strong>
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//<strong>输出：</strong>
//[null, 4, 5, 5, 8, 8]
//
//<strong>解释：</strong>
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
//</pre>
//
//<p> </p>
//<strong>提示：</strong>
//
//<ul>
//	<li><code>1 <= k <= 10<sup>4</sup></code></li>
//	<li><code>0 <= nums.length <= 10<sup>4</sup></code></li>
//	<li><code>-10<sup>4</sup> <= nums[i] <= 10<sup>4</sup></code></li>
//	<li><code>-10<sup>4</sup> <= val <= 10<sup>4</sup></code></li>
//	<li>最多调用 <code>add</code> 方法 <code>10<sup>4</sup></code> 次</li>
//	<li>题目数据保证，在查找第 <code>k</code> 大元素时，数组中至少有 <code>k</code> 个元素</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>设计</li><li>二叉搜索树</li><li>二叉树</li><li>数据流</li><li>堆（优先队列）</li></div></div><br><div><li>👍 315</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.*;

public class leetCode703_KthLargestElementInAStream{
      public static void main(String[] args) {
          int k = 3 ;
          int[] nums = {4,5,8,2};

          KthLargest solution = new leetCode703_KthLargestElementInAStream().new KthLargest(k ,nums);

          solution.add(3);
          solution.add(5);

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {

    PriorityQueue<Integer> numsList;

    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        numsList = new PriorityQueue<>();
        for(int i = 0; i < nums.length ; i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        numsList.add(val);

        if(numsList.size() > k){
            numsList.poll();
        }

        return  numsList.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }