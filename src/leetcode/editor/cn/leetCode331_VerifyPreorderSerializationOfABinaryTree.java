//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。 
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈 树 字符串 二叉树 👍 353 👎 0

  
package leetcode.editor.cn;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Stack;

public class leetCode331_VerifyPreorderSerializationOfABinaryTree{
      public static void main(String[] args) {
           Solution solution = new leetCode331_VerifyPreorderSerializationOfABinaryTree().new Solution();

           String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";
           solution.isValidSerialization(str);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public boolean isValidSerialization(String preorder) {
//        LinkedList<String> stack = new LinkedList<>();
//        for (String s : preorder.split(",")) {
//            stack.push(s);
//            while (stack.size() >= 3
//                    && stack.get(0).equals("#")
//                    && stack.get(1).equals("#")
//                    && !stack.get(2).equals("#")) {
//                stack.pop();
//                stack.pop();
//                stack.pop();
//                stack.push("#");
//            }
//        }
//        return stack.size() == 1 && stack.pop().equals("#");
//    }

    /*
    解法2：
    所有节点的入度之和等于出度之和。可以根据这个特点判断输入序列是否为有效的！
    在一棵二叉树中：
    每个空节点（ "#" ）会提供 0 个出度和 1 个入度。
    每个非空节点会提供 2 个出度和 1 个入度（根节点的入度是 0）。
    我们只要把字符串遍历一次，每个节点都累加 diff = 出度 - 入度 。在遍历到任何一个节点的时候，要求diff >= 0，原因是还没遍历到该节点的子节点，所以此时的出度应该大于等于入度。当所有节点遍历完成之后，整棵树的 diff == 0 。
    这里解释一下为什么下面的代码中 diff 的初始化为 1。因为，
    我们加入一个非空节点时，都会对 diff 先减去 1（入度），再加上 2（出度）。
    但是由于根节点没有父节点，所以其入度为 0，出度为 2。因此 diff 初始化为 1，
    是为了在加入根节点的时候，diff 先减去 1（入度），再加上 2（出度），
    此时 diff 正好应该是2.
     */

      public boolean isValidSerialization(String preorder) {
          int diff = 1;
          for(String s : preorder.split(",")){
              diff--;
              // 每加入一个节点 都要先减去一个入度   若该节点是非空节点 还要再加上两个出度
              // 遍历完之前，出度是大于等于入度的    1个出度认为提供一个挂载点  1个入度认为消耗一个挂载点
              // 若小于等于 消耗的挂载点 大于等于 提供的挂载点  不可能再继续遍历挂载剩下的节点了
              if (diff < 0){
                  return false;
              }
              if(!s.equals("#")){
                  diff += 2;
              }
          }
          return diff == 0;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

  }