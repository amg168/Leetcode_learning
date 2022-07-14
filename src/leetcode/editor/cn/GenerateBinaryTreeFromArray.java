package leetcode.editor.cn;

import java.util.*;

public class GenerateBinaryTreeFromArray {
    private static TreeNode node;
    static TreeNode root = null;
    //根据数据来创建二叉树
    public static TreeNode generateBT(Integer[] array){
            if (array == null || array.length == 0 || array[0] == null) {
                return null;
            }

            int index = 0;
            int length = array.length;

            TreeNode root = new TreeNode(array[0]);
            Deque<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.offer(root);
            TreeNode currNode;
            while (index < length) {
                index++;
                if (index >= length) {
                    return root;
                }
                currNode = nodeQueue.poll();
                Integer leftChild = array[index];
                if (leftChild != null) {
                    currNode.left = new TreeNode(leftChild);
                    nodeQueue.offer(currNode.left);
                }
                index++;
                if (index >= length) {
                    return root;
                }
                Integer rightChild = array[index];
                if (rightChild != null) {
                    currNode.right = new TreeNode(rightChild);
                    nodeQueue.offer(currNode.right);
                }
            }

            return root;
        }



    public static void main(String[] args) {
        Integer[] arr= {8,3,10,1,6,null,14,null,null,4,7,13};

        TreeNode root = generateBT(arr);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0 ; i <  size ; i++){
                TreeNode cur = queue.poll();

                System.out.println(cur.val);

                if(cur.left != null)
                    queue.add(cur.left);

                if(cur.right != null)
                    queue.add(cur.right);
            }
        }
    }

}
