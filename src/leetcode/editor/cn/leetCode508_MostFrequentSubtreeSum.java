//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 135 👎 0

  
package leetcode.editor.cn;

import leetcode.editor.cn.common.TestTree;

import java.util.*;
import java.util.stream.Stream;

public class leetCode508_MostFrequentSubtreeSum{
      public static void main(String[] args) {
           Solution solution = new leetCode508_MostFrequentSubtreeSum().new Solution();

          TreeNode root = new TreeNode(5);
          root.left = new TreeNode(2);
          root.right = new TreeNode(-5);

          solution.findFrequentTreeSum(root);
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
    Map<Integer,Integer> result = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        //记录每一个节点的所有节点值和节点和

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //遍历所有节点
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size ; i++){
                TreeNode cur = queue.poll();

                //计算和，并加入,注意叶子节点时，其跟和以该节点为跟的二叉树和值一致，只能添加一遍
                if(cur.left == null && cur.right == null){
                    if(result.containsKey(cur.val))
                        result.put(cur.val,result.get(cur.val)+1);
                    else
                        result.put(cur.val,1);
                    //跳出该次循环，进行下一次
                    continue;
                }
                int sum = getSumOfTree(cur);
                if(result.containsKey(sum))
                    result.put(sum,result.get(sum)+1);
                else
                    result.put(sum,1);
                if(cur.left != null){
                    queue.add(cur.left);
                }


                if(cur.right != null){
                    queue.add(cur.right);
                }

            }
        }

        //对result按照value进行排序,得到出现次数最多的,降序排列
        List<Map.Entry<Integer,Integer>> list = new LinkedList<>(result.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int maxCount = list.get(0).getValue();
        List<Integer> nodeCount = new ArrayList<>();
        nodeCount.add(list.get(0).getKey());
        //遍历list
        for(int i = 1; i < list.size() ; i++){
            if(list.get(i).getValue() == maxCount)
                nodeCount.add(list.get(i).getKey());
        }

        return nodeCount.stream().mapToInt(Integer::valueOf).toArray();
    }

    //以node为根节点的二叉树词频
    public int getSumOfTree(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftSum = getSumOfTree(node.left);
        int rightSum = getSumOfTree(node.right);

        return node.val + leftSum + rightSum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }