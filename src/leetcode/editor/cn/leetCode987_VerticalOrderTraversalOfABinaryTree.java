//<p>给你二叉树的根结点 <code>root</code> ，请你设计算法计算二叉树的<em> </em><strong>垂序遍历</strong> 序列。</p>
//
//<p>对位于 <code>(row, col)</code> 的每个结点而言，其左右子结点分别位于 <code>(row + 1, col - 1)</code> 和 <code>(row + 1, col + 1)</code> 。树的根结点位于 <code>(0, 0)</code> 。</p>
//
//<p>二叉树的 <strong>垂序遍历</strong> 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。</p>
//
//<p>返回二叉树的 <strong>垂序遍历</strong> 序列。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/29/vtree1.jpg" style="width: 431px; height: 304px;" />
//<pre>
//<strong>输入：</strong>root = [3,9,20,null,null,15,7]
//<strong>输出：</strong>[[9],[3,15],[20],[7]]
//<strong>解释：</strong>
//列 -1 ：只有结点 9 在此列中。
//列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
//列  1 ：只有结点 20 在此列中。
//列  2 ：只有结点 7 在此列中。</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/29/vtree2.jpg" style="width: 512px; height: 304px;" />
//<pre>
//<strong>输入：</strong>root = [1,2,3,4,5,6,7]
//<strong>输出：</strong>[[4],[2],[1,5,6],[3],[7]]
//<strong>解释：</strong>
//列 -2 ：只有结点 4 在此列中。
//列 -1 ：只有结点 2 在此列中。
//列  0 ：结点 1 、5 和 6 都在此列中。
//          1 在上面，所以它出现在前面。
//          5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
//列  1 ：只有结点 3 在此列中。
//列  2 ：只有结点 7 在此列中。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/29/vtree3.jpg" style="width: 512px; height: 304px;" />
//<pre>
//<strong>输入：</strong>root = [1,2,3,4,6,5,7]
//<strong>输出：</strong>[[4],[2],[1,5,6],[3],[7]]
//<strong>解释：</strong>
//这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
//因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中结点数目总数在范围 <code>[1, 1000]</code> 内</li>
//	<li><code>0 <= Node.val <= 1000</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>哈希表</li><li>二叉树</li></div></div><br><div><li>👍 197</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.*;

public class leetCode987_VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new leetCode987_VerticalOrderTraversalOfABinaryTree().new Solution();

        Integer[] arr = {3,1,4,0,2,2};
        TreeNode root = GenerateBinaryTreeFromArray.generateBT(arr);
        solution.verticalTraversal(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null)
            return result;

        travel(root);
        return result;
    }

    public void travel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //从列索引到list的映射
        Map<TreeNode,NodeByIndex> map = new HashMap<>();
        map.put(root, new NodeByIndex(root,0,0));
//
//        Comparator<Map.Entry<TreeNode,NodeByIndex>> valueComparator = new Comparator<Map.Entry<TreeNode,NodeByIndex>>() {
//            @Override
//            public int compare(Map.Entry<TreeNode , NodeByIndex> entry1 , Map.Entry<TreeNode,NodeByIndex> entry2) {
//                if(entry1.getValue().yIndex != entry2.getValue().yIndex)
//                    return entry1.getValue().yIndex - entry2.getValue().yIndex;
//                else if(entry1.getValue().xIndex != entry2.getValue().xIndex)
//                    return entry1.getValue().xIndex -entry2.getValue().xIndex;
//                else
//                    return entry1.getValue().node.val - entry2.getValue().node.val;
//            }
//        };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0 ; i < size ; i++) {
                TreeNode cur = queue.poll();
                NodeByIndex curNodeIndex = map.get(cur);

                if (cur.left != null) {
                    queue.add(cur.left);
                    NodeByIndex leftNodeIndex = new NodeByIndex(cur.left,curNodeIndex.xIndex + 1, curNodeIndex.yIndex - 1);
                    map.put(cur.left, leftNodeIndex);

                }

                if (cur.right != null) {
                    queue.add(cur.right);
                    NodeByIndex rightNodeIndex = new NodeByIndex(cur.right,curNodeIndex.xIndex + 1, curNodeIndex.yIndex + 1);
                    map.put(cur.right, rightNodeIndex);
                }
            }
        }

        //对map进行排序
        List<NodeByIndex> list = new ArrayList<NodeByIndex>(map.values());
        Collections.sort(list, new Comparator<NodeByIndex>() {
            @Override
            public int compare(NodeByIndex node1, NodeByIndex node2) {
                if(node1.yIndex != node2.yIndex)
                    return node1.yIndex - node2.yIndex;
                else if(node1.xIndex != node2.xIndex)
                    return node1.xIndex - node2.xIndex;
                else
                    return node1.node.val - node2.node.val;
            }
        });

        int lastcol = Integer.MIN_VALUE;
        int size = 0;
        for ( NodeByIndex entry : list) {
            if(entry.yIndex != lastcol){
                lastcol = entry.yIndex;
                result.add(new ArrayList<>());
                size++;
            }
            result.get(size - 1).add(entry.node.val);
        }

        System.out.println(result);
    }

}

class NodeByIndex implements Comparator<NodeByIndex>{
    TreeNode node;
    int xIndex;
    int yIndex;

    public NodeByIndex(TreeNode node , int xIndex, int yIndex) {
        this.node = node;
        this.xIndex = xIndex;
        this.yIndex = yIndex;
    }

    @Override
    public int compare(NodeByIndex o1, NodeByIndex o2) {
        return o1.node.val - o2.node.val;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

  }