//给你一个二维整数数组 descriptions ，其中 descriptions[i] = [parenti, childi, isLefti] 表示 
//parenti 是 childi 在 二叉树 中的 父节点，二叉树中各节点的值 互不相同 。此外： 
//
// 
// 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。 
// 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。 
// 
//
// 请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。 
//
// 测试用例会保证可以构造出 有效 的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
//输出：[50,20,80,15,17,19]
//解释：根节点是值为 50 的节点，因为它没有父节点。
//结果二叉树如上图所示。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：descriptions = [[1,2,1],[2,3,0],[3,4,1]]
//输出：[1,2,null,null,3,4]
//解释：根节点是值为 1 的节点，因为它没有父节点。 
//结果二叉树如上图所示。 
//
// 
//
// 提示： 
//
// 
// 1 <= descriptions.length <= 10⁴ 
// descriptions[i].length == 3 
// 1 <= parenti, childi <= 10⁵ 
// 0 <= isLefti <= 1 
// descriptions 所描述的二叉树是一棵有效二叉树 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 数组 哈希表 二叉树 👍 30 👎 0

package leetcode.editor.cn;

import java.util.Hashtable;
import java.util.Map;

public class leetcode2196_CreateBinaryTreeFromDescriptions{
    public static void main(String[] args) {
        Solution solution = new leetcode2196_CreateBinaryTreeFromDescriptions().new Solution();
        int[][] arr = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};

        solution.createBinaryTree(arr);
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
    TreeNode root = null;
    public TreeNode createBinaryTree(int[][] descriptions) {
        Hashtable<Integer,TreeNode> allNodes = new Hashtable<>();
        //维护第二个表，如果数据第一个值代表的节点不在在第二个值代表的节点序列中，则此节点为跟节点
        Hashtable<Integer,TreeNode> secondNodes = new Hashtable<>();
        boolean isRoot = false;
        for(int i = 0 ; i < descriptions.length; i++){
                TreeNode newNode = allNodes.getOrDefault(descriptions[i][0],new TreeNode(descriptions[i][0]));
                allNodes.put(descriptions[i][0],newNode);

                if(descriptions[i][2] == 1){
                    TreeNode left = allNodes.getOrDefault(descriptions[i][1],new TreeNode(descriptions[i][1]));
                    allNodes.put(descriptions[i][1],left);
                    secondNodes.put(descriptions[i][1],left);
                    newNode.left = left;
                }else{
                    TreeNode right = allNodes.getOrDefault(descriptions[i][1],new TreeNode(descriptions[i][1]));
                    allNodes.put(descriptions[i][1],right);
                    secondNodes.put(descriptions[i][1],right);
                    newNode.right = right;
                }
        }

        for(Map.Entry<Integer,TreeNode> entry: allNodes.entrySet()){
            if(!secondNodes.containsKey(entry.getKey())){
                isRoot = true;
                root = entry.getValue();
            }
        }

        return  root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
