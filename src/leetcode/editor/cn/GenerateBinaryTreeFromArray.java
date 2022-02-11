package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryTreeFromArray {
    private static TreeNode node;
    //根据数据来创建二叉树
    public static TreeNode generateBT(Object[] arr){
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode((int)arr[0]);
        queue.add(root);

        TreeNode currentNode;

        for(int i = 0 ; i < arr.length ; i++){
            currentNode = queue.poll();
            if(arr[i] != null){

                if(2 * i + 1 < arr.length){
                    if(arr[2 * i + 1] == null)
                        currentNode.left = null;
                    else{
                        currentNode.left = new TreeNode((int) arr[2 * i + 1]);
                        queue.add(currentNode.left);
                    }

                }

                if(2 * i + 2 < arr.length){
                    if(arr[2 * i + 2] == null)
                        currentNode.right = null;
                    else{
                        currentNode.right = new TreeNode((int) arr[2 * i + 2]);
                        queue.add(currentNode.right);
                    }

                }

            }
        }

        return root;
    }

    public static void main(String[] args) {
        Object[] arr= {1,2,3,4,5,6,null,null,null,7,8};

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
