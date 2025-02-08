public static int LeetCode_70_Climbing_Stairs_Memoization(int n, int[] dp) 
    {
        if (n <= 1) 
        {
            return dp[n] = 1;
        }

        if (dp[n] != 0) 
        {
            return dp[n];
        }

        int ans = LeetCode_70_Climbing_Stairs_Memoization(n - 1, dp)
                + LeetCode_70_Climbing_Stairs_Memoization(n - 2, dp);

        return dp[n] = ans;
    }
    public static int LeetCode_70_Climbing_Stairs_Tabulation(int n, int[] dp) 
    {
        int N = n;
        for (n = 0; n <= N; n++) 
        {
            if (n <= 1) 
            {
                dp[n] = 1;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];

            dp[n] = ans;
        }

        return dp[N];
    }
    public static int LeetCode_70_Climbing_Stairs_Better(int n) 
    {
        int a = 1;
        int b = 1;
        int sum = 0;

        for (int i = 2; i <= n; i++) 
        {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }
    public static void LeetCode_70_Climbing_Stairs()
    {
        int n=7;
        int[] dp = new int[n+1];
        System.out.println("Memoization :- " + LeetCode_70_Climbing_Stairs_Memoization(n, dp));
        display_1D(dp);
        System.out.println("Tabulation :- " + LeetCode_70_Climbing_Stairs_Tabulation(n, dp));
        display_1D(dp);
        System.out.println("Better :- " + LeetCode_70_Climbing_Stairs_Better(n));
    }
