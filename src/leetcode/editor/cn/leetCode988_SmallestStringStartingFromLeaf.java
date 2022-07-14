//<p>给定一颗根结点为&nbsp;<code>root</code>&nbsp;的二叉树，树中的每一个结点都有一个&nbsp;<code>[0, 25]</code>&nbsp;范围内的值，分别代表字母&nbsp;<code>'a'</code> 到&nbsp;<code>'z'</code>。</p>
//
//<p>返回 <em><strong>按字典序最小</strong> 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束</em>。</p>
//
//<blockquote>
//<p>注<strong>：</strong>字符串中任何较短的前缀在 <strong>字典序上</strong> 都是 <strong>较小</strong> 的：</p>
//
//<ul>
//	<li>例如，在字典序上&nbsp;<code>"ab"</code> 比&nbsp;<code>"aba"</code>&nbsp;要小。叶结点是指没有子结点的结点。&nbsp;</li>
//</ul>
//</blockquote>
//
//<p>节点的叶节点是没有子节点的节点。</p>
//
//<p>&nbsp;</p>
//
//<ol>
//</ol>
//
//<p><strong>示例 1：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/02/tree1.png" style="height: 358px; width: 534px;" /></strong></p>
//
//<pre>
//<strong>输入：</strong>root = [0,1,2,3,4,3,4]
//<strong>输出：</strong>"dba"
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img src="https://assets.leetcode.com/uploads/2019/01/30/tree2.png" /></p>
//
//<pre>
//<strong>输入：</strong>root = [25,1,3,1,3,0,2]
//<strong>输出：</strong>"adz"
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<p><img src="https://assets.leetcode.com/uploads/2019/02/01/tree3.png" style="height: 513px; width: 490px;" /></p>
//
//<pre>
//<strong>输入：</strong>root = [2,2,1,null,1,0,null,0]
//<strong>输出：</strong>"abc"
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>给定树的结点数在&nbsp;<code>[1, 8500]</code> 范围内</li>
//	<li><code>0 &lt;= Node.val &lt;= 25</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>字符串</li><li>二叉树</li></div></div><br><div><li>👍 77</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.*;

public class leetCode988_SmallestStringStartingFromLeaf{
      public static void main(String[] args) {
           Solution solution = new leetCode988_SmallestStringStartingFromLeaf().new Solution();

           Integer[] arr = {25,1,null,0,0,1,null,null,null,0};
           TreeNode root = GenerateBinaryTreeFromArray.generateBT(arr);

           solution.smallestFromLeaf(root);
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
//    List<TreeNode> nodeList = new ArrayList<>();
//    List<String> result = new ArrayList<>();
//
//    public String smallestFromLeaf(TreeNode root) {
//        if(root == null)
//            return result.toString();
//
//        return Bfs(root);
//    }
//
//    //进行广度优先遍历，得到层数最小的叶子节点，如果有多个的话，进行比对
//    public String Bfs(TreeNode root){
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        boolean flag = false;
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//
//            for(int i = 0 ; i < size ; i++){
//                StringBuffer str = new StringBuffer();
//                str.delete(0, str.length());
//                TreeNode cur = queue.poll();
//
//                nodeList.add(cur);
//
//                if(cur != null){
//                    queue.add(cur.left);
//                    queue.add(cur.right);
//               }
//
//                //得到最上层叶子节点的路径，并进行比较
//                if(cur != null && cur.left == null && cur.right == null) {
//                    //得到其路径
//                    boolean isFinished = false;
//                    int temp = 0;
//                    for(int j = nodeList.size() - 1; j >= 0 && !isFinished; j = (j - 1) / 2) {
//                        if(nodeList.get(j) != null){
//                            char ch = (char) (nodeList.get(j).val + 'a');
//                            str.append(ch);
//                        }
//                        if(j == 0)
//                            isFinished = true;
//                    }
//                    result.add(str.toString());
//                }
//            }
//        }
//
//        Collections.sort(result, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        return result.get(0);
//    }

        String ans = "~";
        public String smallestFromLeaf(TreeNode root) {
            dfs(root, new StringBuilder());
            return ans;
        }

        public void dfs(TreeNode node, StringBuilder sb) {
            if (node == null) return;
            sb.append((char)('a' + node.val));

            if (node.left == null && node.right == null) {
                sb.reverse();
                String S = sb.toString();
                sb.reverse();

                if (S.compareTo(ans) < 0)
                    ans = S;
            }

            dfs(node.left, sb);
            dfs(node.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

  }