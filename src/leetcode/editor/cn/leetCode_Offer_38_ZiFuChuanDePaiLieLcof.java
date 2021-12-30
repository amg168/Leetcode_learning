//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 464 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class leetCode_Offer_38_ZiFuChuanDePaiLieLcof{
    public static void main(String[]args){
        Solution solution=new leetCode_Offer_38_ZiFuChuanDePaiLieLcof().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] permutation(String s) {
        List<String> result = new ArrayList<String>();

        process(s.toCharArray(), 0, result);

        return result.toArray(new String[result.size()]);
    }

    public void process(char[] str, int i, List<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(str));
        }

        boolean[] visited = new boolean[26];

        for (int j = i; j < str.length; j++) {
            if (!visited[str[j] - 'a']) {
                visited[str[j] - 'a'] = true;

                swap(str, i, j);

                process(str, i + 1, res);

                swap(str, i, j);
            }
        }

    }

    public void swap(char[] str, int i, int j) {
        char temp = str[i];

        str[i] = str[j];

        str[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }