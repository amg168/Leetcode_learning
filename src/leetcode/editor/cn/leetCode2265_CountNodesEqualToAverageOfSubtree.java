//<p>给你一棵二叉树的根节点 <code>root</code> ，找出并返回满足要求的节点数，要求节点的值等于其 <strong>子树</strong> 中值的 <strong>平均值</strong> 。</p>
//
//<p><strong>注意：</strong></p>
//
//<ul> 
// <li><code>n</code> 个元素的平均值可以由 <code>n</code> 个元素 <strong>求和</strong> 然后再除以 <code>n</code> ，并 <strong>向下舍入</strong> 到最近的整数。</li> 
// <li><code>root</code> 的 <strong>子树</strong> 由 <code>root</code> 和它的所有后代组成。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p> 
//<img src="https://assets.leetcode.com/uploads/2022/03/15/image-20220315203925-1.png" style="width: 300px; height: 212px;"> <pre><strong>输入：</strong>root = [4,8,5,0,1,null,6]
//<strong>输出：</strong>5
//<strong>解释：</strong>
//对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
//对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
//对值为 0 的节点：子树的平均值 0 / 1 = 0 。
//对值为 1 的节点：子树的平均值 1 / 1 = 1 。
//对值为 6 的节点：子树的平均值 6 / 1 = 6 。
//</pre> </img>
//
//<p><strong>示例 2：</strong></p> 
//<img src="https://assets.leetcode.com/uploads/2022/03/26/image-20220326133920-1.png" style="width: 80px; height: 76px;"> <pre><strong>输入：</strong>root = [1]
//<strong>输出：</strong>1
//<strong>解释：</strong>对值为 1 的节点：子树的平均值 1 / 1 = 1。
//</pre> </img>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>树中节点数目在范围 <code>[1, 1000]</code> 内</li> 
// <li><code>0 &lt;= Node.val &lt;= 1000</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 27</li><li>👎 0</li></div>
  
package leetcode.editor.cn;
public class leetCode2265_CountNodesEqualToAverageOfSubtree{
      public static void main(String[] args) {
           Solution solution = new leetCode2265_CountNodesEqualToAverageOfSubtree().new Solution();

           Integer[] arr = {4,8,5,0,1,null,6};
           TreeNode root = GenerateBinaryTreeFromArray.generateBT(arr);

           solution.averageOfSubtree(root);
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
    int result = 0;

    /*
    我自己写的方法，从上到下遍历的过程中，会有计算冗余，改进为自下而上
    执行耗时:30 ms,击败了5.49% 的Java用户
	内存消耗:41.5 MB,击败了6.70% 的Java用户
     */
//    public int averageOfSubtree(TreeNode root) {
//        //根据节点信息得到每一个节点的子节点的个数和总和，进而求得平均值
//        if(root.left == null && root.right == null){
//            result += 1;
//            return 1;
//        }
//
//        NewNode rootNode = sum(root);
//        if(rootNode.sum / rootNode.nodeCount == root.val)
//            result += 1;
//
//        if(root.left != null)
//            averageOfSubtree(root.left);
//        if(root.right != null)
//        averageOfSubtree(root.right);
//
//        return result;
//    }
//
//    //得到一个节点的左子树、右子树的节点数和总和
//    public NewNode sum(TreeNode node){
//        if(node != null && node.left == null && node.right == null)
//            return new NewNode(1,node.val);
//
//        NewNode leftNode = new NewNode(0,0);
//        NewNode rightNode = new NewNode(0,0);
//
//        if(node.left != null)
//            leftNode = sum(node.left);
//        if(node.right != null)
//            rightNode = sum(node.right);
//
//        return new NewNode(leftNode.nodeCount + rightNode.nodeCount + 1,leftNode.sum + rightNode.sum + node.val);
//    }

    /*
    自下而上的方法
    执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:41 MB,击败了56.71% 的Java用户
     */
    public int averageOfSubtree(TreeNode root) {
        //根据节点信息得到每一个节点的子节点的个数和总和，进而求得平均值
        average(root);
        return  result;
    }

    //得到一个节点的左子树、右子树的节点数和总和
    public NewNode average(TreeNode node){
        if(node == null)
            return new NewNode(0,0);

        NewNode leftNode = average(node.left);
        NewNode rightNode = average(node.right);

        if((leftNode.sum + rightNode.sum + node.val) / (leftNode.nodeCount + rightNode.nodeCount + 1) == node.val)
            result++;

        return new NewNode(leftNode.nodeCount + rightNode.nodeCount + 1,leftNode.sum + rightNode.sum + node.val);
    }
}

class NewNode{
    public int nodeCount;
    public int sum;

    public NewNode(int nodeCount, int sum) {
        this.nodeCount = nodeCount;
        this.sum = sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }