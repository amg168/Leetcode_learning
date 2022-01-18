//<p>在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：</p>
//
//<ol>
//	<li>行数&nbsp;<code>m</code>&nbsp;应当等于给定二叉树的高度。</li>
//	<li>列数&nbsp;<code>n</code>&nbsp;应当总是奇数。</li>
//	<li>根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（<strong>左下部分和右下部分</strong>）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。</li>
//	<li>每个未使用的空间应包含一个空的字符串<code>&quot;&quot;</code>。</li>
//	<li>使用相同的规则输出子树。</li>
//</ol>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong>
//     1
//    /
//   2
//<strong>输出:</strong>
//[[&quot;&quot;, &quot;1&quot;, &quot;&quot;],
// [&quot;2&quot;, &quot;&quot;, &quot;&quot;]]
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong>
//     1
//    / \
//   2   3
//    \
//     4
//<strong>输出:</strong>
//[[&quot;&quot;, &quot;&quot;, &quot;&quot;, &quot;1&quot;, &quot;&quot;, &quot;&quot;, &quot;&quot;],
// [&quot;&quot;, &quot;2&quot;, &quot;&quot;, &quot;&quot;, &quot;&quot;, &quot;3&quot;, &quot;&quot;],
// [&quot;&quot;, &quot;&quot;, &quot;4&quot;, &quot;&quot;, &quot;&quot;, &quot;&quot;, &quot;&quot;]]
//</pre>
//
//<p><strong>示例 3:</strong></p>
//
//<pre>
//<strong>输入:</strong>
//      1
//     / \
//    2   5
//   / 
//  3 
// / 
//4 
//<strong>输出:</strong>
//[[&quot;&quot;,  &quot;&quot;,  &quot;&quot;, &quot;&quot;,  &quot;&quot;, &quot;&quot;, &quot;&quot;, &quot;1&quot;, &quot;&quot;,  &quot;&quot;,  &quot;&quot;,  &quot;&quot;,  &quot;&quot;, &quot;&quot;, &quot;&quot;]
// [&quot;&quot;,  &quot;&quot;,  &quot;&quot;, &quot;2&quot;, &quot;&quot;, &quot;&quot;, &quot;&quot;, &quot;&quot;,  &quot;&quot;,  &quot;&quot;,  &quot;&quot;,  &quot;5&quot;, &quot;&quot;, &quot;&quot;, &quot;&quot;]
// [&quot;&quot;,  &quot;3&quot;, &quot;&quot;, &quot;&quot;,  &quot;&quot;, &quot;&quot;, &quot;&quot;, &quot;&quot;,  &quot;&quot;,  &quot;&quot;,  &quot;&quot;,  &quot;&quot;,  &quot;&quot;, &quot;&quot;, &quot;&quot;]
// [&quot;4&quot;, &quot;&quot;,  &quot;&quot;, &quot;&quot;,  &quot;&quot;, &quot;&quot;, &quot;&quot;, &quot;&quot;,  &quot;&quot;,  &quot;&quot;,  &quot;&quot;,  &quot;&quot;,  &quot;&quot;, &quot;&quot;, &quot;&quot;]]
//</pre>
//
//<p><strong>注意:</strong> 二叉树的高度在范围 [1, 10] 中。</p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 113</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetCode655_PrintBinaryTree{
      public static void main(String[] args) {
           Solution solution = new leetCode655_PrintBinaryTree().new Solution();
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
    List<List<String>> result = new ArrayList<>();

    Queue<AnnotatedNode> queue = new LinkedList<>();

    public List<List<String>> printTree(TreeNode root) {
        if (root == null)
            return result;

        //假设二叉树其高度为height;
        int height = getHeightOfATree(root);
        //总的字符个数为
        double strCountOfNode = Math.pow(2, height) - 1;
        queue.add(new AnnotatedNode(root, 0, (int) (strCountOfNode / 2)));
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<String> levelResult = new ArrayList<>();
            for (int i = 0; i < strCountOfNode; i++)
                levelResult.add("");

            for (int i = 0; i < size; i++) {
                AnnotatedNode cur = queue.poll();

                levelResult.set(cur.pos, cur.node.val + "");
                if (cur.node.left != null)
                    queue.add(new AnnotatedNode(cur.node.left, cur.depth + 1, (int) (cur.pos - Math.pow(2, height - (cur.depth + 1) - 1))));

                if (cur.node.right != null)
                    queue.add(new AnnotatedNode(cur.node.right, cur.depth + 1, (int) (cur.pos + Math.pow(2, height - (cur.depth + 1) - 1))));
            }

            System.out.println(levelResult);
            result.add(levelResult);
        }

        return result;

    }

    public int getHeightOfATree(TreeNode root) {
        if (root == null)
            return 0;

        int left = getHeightOfATree(root.left);
        int right = getHeightOfATree(root.right);

        return Math.max(left, right) + 1;
    }

    class AnnotatedNode {
        TreeNode node;
        int depth, pos;

        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }