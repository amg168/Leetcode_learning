package leetcode.editor.cn;

import java.util.*;

public class Test {
    public int minDinstance(String str1,String str2){
        int m = str1.length();
        int n = str2.length();

        DpNode[][]  dp = new DpNode[m + 1][n + 1];

        for(int i = 0 ;i <= m;i++)
            dp[i][0] = new DpNode(i , 2);
        for(int j = 1 ;j <= n;j++)
            dp[0][j] = new DpNode(j, 1);

        for(int i = 1 ; i <= m;i++){
            for(int j = 1 ;j <= n ;j++){
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    DpNode node = dp[i - 1][j - 1];
                    dp[i][j] =  new DpNode(node.val, 0);
                }
                else{
                    dp[i][j] = minNode(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }

                dp[i][j].val++;
            }

        }
        printResult(dp, str1, str2);
        return dp[m][n].val;
    }

    public DpNode minNode(DpNode a, DpNode b, DpNode c){
        DpNode res = new DpNode(a.val, 2);

        if(res.val > b.val){
            res.val = b.val;

            res.choice = 1;
        }

        if(res.val > c.val){
            res.val = c.val;
            res.choice = 3;
        }

        return  res;
    }

    public void printResult(DpNode[][] dp, String str1, String str2){
        int rows = dp.length;
        int cols = dp[0].length;

        int i = rows - 1;
        int j = cols - 1;

        System.out.println("change s1 = " + str1 + " to str2 = " + str2 + ":\n");

        while(i != 0 && j != 0){
            char c1 =  str1.charAt(i - 1);
            char c2 = str2.charAt(j - 1);
            int choice = dp[i][j].choice;

            System.out.println("str1[" +(i - 1) + "]:");

            switch(choice){
                case 0:
                    System.out.println("skip :'" + c1 + "'");
                    i--; j--;
                    break;
                case 1:
                    System.out.println("insert :'" + c2 + "'");
                    j--;
                    break;
                case 2:
                    System.out.println("delete :'" + c1 + "'");
                    i--;
                    break;
                case 3:
                    System.out.println("replace :'" + c1 + "'" + "with '" + c2 + "'");
                    i--; j--;
                    break;
            }
        }

        while(i > 0){
            System.out.println("str[" + (i - 1) + "]:");
            System.out.println("delete '" + str1.charAt(i - 1) + "'");
            i--;
        }

        while(j > 0){
            System.out.println("str1[0] :");
            System.out.println("insert '" + str2.charAt(j - 1) + "'");
            j--;
        }
    }
    public static void main(String[] args) {
        Test test = new Test();
        String str1 = "intention";
        String  str2 = "execution";

        test.minDinstance(str1,str2);

    }
}

class DpNode{
    int val;
    int choice;

    public DpNode(int val, int choice) {
        this.val = val;
        this.choice = choice;
    }
}
