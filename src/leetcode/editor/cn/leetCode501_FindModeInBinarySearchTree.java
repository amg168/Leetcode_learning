//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 380 👎 0

  
  package leetcode.editor.cn;

import java.util.*;

public class leetCode501_FindModeInBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new leetCode501_FindModeInBinarySearchTree().new Solution();

           TreeNode root = new TreeNode(1);
           TreeNode node1 = new TreeNode(2);
           TreeNode node2 = new TreeNode(3);
           TreeNode node3 = new TreeNode(4);
           TreeNode node4 = new TreeNode(5);
           TreeNode node5 = new TreeNode(6);
           TreeNode node6 = new TreeNode(7);
           TreeNode node7 = new TreeNode(8);


           root.left = node1;
           root.right = node2;

           node1.left = node3;
           node1.right = node4;

           node2.left = node5;
           node2.right = node6;

           node5.left = node7;

           solution.findMode(root);


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
    /*
    暴力解法：通过中序遍历获取升序数组，然后将每个元素的出现次数放入到对应的map中，对出现的次数进行排序，然后得到对应的众数
     */
//    List<Integer> nodeArr = new ArrayList<>();
//
//    public int[] findMode(TreeNode root) {
//        midOrder(root);
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for(int i=0;i<nodeArr.size();i++)
//        {
//            if(map.containsKey(nodeArr.get(i))){
//                int count = map.get(nodeArr.get(i));
//                map.put(nodeArr.get(i),count+=1);
//            }else{
//                map.put(nodeArr.get(i),1);
//            }
//        };
//
//        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
//                return o2.getValue() - o1.getValue();
//            }
//        });
//
//        List<Integer> result = new ArrayList<>();
//
//        int mostValue = list.get(0).getValue();
//        result.add(list.get(0).getKey());
//        for(int i=1;i<list.size();i++){
//            if(list.get(i).getValue() == mostValue)
//                result.add(list.get(i).getKey());
//        }
//
//        System.out.println(result);
//
//        return  Arrays.stream(result.toArray(new Integer[result.size()])).mapToInt(Integer::valueOf).toArray();
//    }
//
//    //根据中序遍历得到升序数组
//    public void midOrder(TreeNode root)
//    {
//        if(root == null)
//            return;
//        midOrder(root.left);
//        nodeArr.add(root.val);
//        midOrder(root.right);
//    }

    //中序遍历解法
//    List<Integer> answer = new ArrayList<>();
//
//    int base, count, maxCount;
//
//    public int[] findMode(TreeNode root){
//        dfs(root);
//
//        int[] result = new int[answer.size()];
//        for(int i=0;i<answer.size();i++){
//            result[i] = answer.get(i);
//        }
//
//        return result;
//    }
//
//    public void dfs(TreeNode node){
//        if(node  == null)
//            return;
//
//        dfs(node.left);
//        update(node.val);
//        dfs(node.right);
//    }
//
//    public  void update(int x){
//        if(x == base)
//            count++;
//        else{
//            count = 1;
//            base = x;
//        }
//
//        if(count == maxCount){
//            answer.add(x);
//        }
//
//        if(count > maxCount){
//            maxCount = count;
//            answer.clear();
//            answer.add(base);
//        }
//    }

    //morris中序遍历，将morris中序遍历的打印过程编程update函数即可
    int base, count, maxCount;
    List<Integer> answer = new ArrayList<Integer>();

    public int[] findMode(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }