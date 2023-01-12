//<p>在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 <strong>逐行</strong> 依次按&nbsp;“之” 字形进行标记。</p>
//
//<p>如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；</p>
//
//<p>而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。</p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/06/28/tree.png" style="height: 138px; width: 300px;" /></p>
//
//<p>给你树上某一个节点的标号 <code>label</code>，请你返回从根节点到该标号为 <code>label</code> 节点的路径，该路径是由途经的节点标号所组成的。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>label = 14
//<strong>输出：</strong>[1,3,4,14]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>label = 26
//<strong>输出：</strong>[1,2,6,10,26]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= label &lt;= 10^6</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树</li><li>数学</li><li>二叉树</li></div></div><br><div><li>👍 188</li><li>👎 0</li></div>
  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetCode1104_PathInZigzagLabelledBinaryTree{
      public static void main(String[] args) {
           Solution solution = new leetCode1104_PathInZigzagLabelledBinaryTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> pathInZigZagTree(int label) {
        //得到lable应该所处的层级
        int level = 0 , i = 1;
        while(i <= label){
            i *= 2;
            level++;
        }

        while(level >= 1){
            result.add(label);
            //i/2即为其父节点
            label /= 2;
            i /= 2;
            /*
            即父节点的对称节点为2^i - 1 + 2^(i - 1) - label
             */
            label = i - 1 + i /2 - label;
            level--;
        }

        Collections.reverse(result);

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }