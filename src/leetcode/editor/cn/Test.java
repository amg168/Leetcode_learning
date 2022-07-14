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

    //最长回文子字符串
    public int longestPalidromSubsequence(String str){
        int n = str.length();

        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0 ;i < n ; i++)
            dp[i][i] = 1;

        for(int i = n - 2 ; i >= 0 ;i--){
            for(int j = i + 1; j <  n;j++){
                if(str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return  dp[0][n - 1];
    }

    //最少次数的插入字符串构建回文字符串
    public int minInsertions(String str){
        int size = str.length();

        int[][] dp = new int[size][size];
        for(int i = 0 ; i < size ; i++)
            dp[i][i] = 0;

        for(int i = size - 2 ; i >= 0 ; i--){
            for(int j = i + 1; j <  size ; j++){
                if(str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i + 1][j] , dp[i][j - 1]) + 1;
            }
        }

        return dp[0][size - 1];
    }

    ////最少次数的插入字符串构建回文字符串,将二维数组优化成一维数组
    public int minInsertions2(String str){
        int size = str.length();

        int[] dp = new int[size];
        for(int i = 0 ; i < size ; i++)
            dp[i] = 0;

        int temp = 0;

        for(int i = size - 2 ; i >= 0 ; i--){
            int pre = 0;
            for(int j = i + 1; j <  size ; j++){
                temp = dp[j];
                if(str.charAt(i) == str.charAt(j))
                    dp[j] = pre;
                else
                    dp[j] = Math.min(dp[j] , dp[j - 1]) + 1;
            }

            pre = temp;
        }

        return dp[size - 1];
    }

    //动态规划之正则表达式
    public boolean dp(String str, int i, String pattern , int j){
        int m = str.length();
        int n = pattern.length();

        //当正则字符串到达了尾部时，判断待匹配的字符串是否同时到底尾部，如果i = m，则表示匹配完成
        if(j == n){
            return i == m;
        }

        //如果待匹配的字符串到达尾部，则对待匹配的字符串进行判断
        if(i == m){
            if((n - j) % 2 == 1){
                return false;
            }
            for(;j + 1 < n;j += 2){
                if(pattern.charAt(j + 1) != '*'){
                    return false;
                }
            }
            return true;
        }

        boolean res = false;

        if(str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.'){
            if(j < n - 1 && pattern.charAt(j + 1) == '*'){
                res = dp(str, i , pattern, j + 2) || dp(str, i + 1 , pattern , j);
            }else{
                res = dp(str, i + 1, pattern, j + 1);
            }
        }
        else {
            if(j < n - 1 && pattern.charAt(j + 1) == '*'){
                res = dp(str, i , pattern, j + 2);
            }else {
                return  false;
            }
        }

        return res;

    }

    //高楼扔鸡蛋,k表示当前所剩的鸡蛋数，n表示楼层数
    public int superEggDrop(int k , int n){
        return superEggDP(k , n );
    }

    public int superEggDP(int k ,int n){
        if(k == 1)
            return n;

        if(n == 0)
            return  0;

        int res = Integer.MAX_VALUE;

        for(int  i = 0 ; i < n + 1; i++)
        {
            res = Math.min(res, Math.max(
                    superEggDP(k , n - i),
                    superEggDP(k - 1 , i - 1)
            ) + 1 );
        }

        return res;
    }

    public int superEggDp2(int k, int  n){
        if(k == 1)
            return n;

        if(n == 0)
            return 0;

        int res = Integer.MAX_VALUE;

        int low = 0 ;
        int high = 1;
        int mid = 0;

        while(low <  high){
            mid = (low + high) / 2;
            int broken = superEggDp2(k - 1, mid - 1);
            int not_broken = superEggDp2(k, n - mid);

            if(broken > not_broken){
                high = mid - 1;
                res = Math.min(res, broken + 1);
            }
            else{
                low = mid + 1;
                res = Math.min(res , not_broken + 1);
            }

        }

        return res;
    }

    //dp[k][m] = n表示当前有k个鸡蛋，最多可以尝试扔
    public int superEggDP3(int k , int  n){
        int[][] dp = new int[k + 1][n + 1];
        int m = 0;
        while(dp[k][m] < n){
            m++;
            for(int i = 1; i <= k ; i++)
                dp[k][n] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
        }

        return m;
    }

    //扎气球问题
    public int maxCoins(int[] nums){
        int n = nums.length;

        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;

        for(int i = 0 ; i < n + 2 ; i++){
            points[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 1];
        for(int i = n; i >= 0 ;i --){
            for(int j = i + 1 ; j < n + 2;j ++){
                for(int k = i + 1; k < j ; k++){
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][k] + dp[k][j] + points[i] * points[k] * points[k]
                    );
                }
            }
        }

        return dp[0][n + 1];
    }

    //0-1背包问题
    public int Knapsack(int W, int N, int[] wights, int[] val){
        int[][] dp = new int[W + 1][N + 1];
        //初始化
        for(int i = 0 ; i < W + 1; i++)
            dp[i][0] = 0;
        for(int j = 0 ; j < N + 1 ;j++)
            dp[0][j] = 0;

        for(int i = 0 ; i <= N ;i++){
            for(int w = 1 ; w <= W; w++) {
                if(w - wights[i - 1] < 0){
                    dp[i][w] = dp[i - 1][w];
                }else{
                    dp[i][w] = Math.max(dp[i - 1][w - wights[i - 1]] + val[i - 1],
                            dp[i - 1][w]);
                }
            }
        }

        return dp[N][W];
    }

    //完全背包问题
    public int completeKnapsackProblem(int amount, int[] coins){
        int n = coins.length;
        int[][] dp = new int[n + 1][amount];

        for(int i = 0 ; i < amount ; i++)
            dp[i][0] = 1;

        for(int i = 0 ; i <= n + 1; i++){
            for(int j = 0; j < amount ; j++){
                if(j - coins[i] >= 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return  dp[n][amount];
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
