 public static void display_1D(int[] arr) 
    {
        for (int ele : arr) 
        {
            System.out.print(ele + "\t");
        }
        System.out.println();
    }
    public static void display_2D(int[][] arr) 
    {
        for (int[] ar : arr) 
        {
            display_1D(ar);
        }
        System.out.println();
    }

public static int Leetcode_516_Longest_Pallindromic_SubSequence_Tabulation(String str, int si, int ei, int[][] dp, boolean[][] isPalindrome)
    {
        int n=str.length();
        for(int gap = 0; gap < n; gap++)
        {
            for(si = 0; si < n - gap; si++)
            {
                ei = si + gap;

                if(isPalindrome[si][ei])
                {
                    dp[si][ei] = ei-si+1;
                    continue;
                }

                int len=0;
                if(str.charAt(si) == str.charAt(ei))
                {
                    len = dp[si+1][ei-1] + 2;
                }
                else
                {
                    len = Math.max(dp[si+1][ei], dp[si][ei-1]);
                }

                dp[si][ei] = len;
            }
        }

        return dp[0][str.length()-1];
    }
    
    public static void Leetcode_516_Longest_Pallindromic_SubSequence()
    {
        String str = "geeksforgeeks";
        int n = str.length();
        int si = 0, ei = n - 1;
        int[][] dp = new int[n][n];

        boolean[][] isPalindrome = is_Pallindrome_SubString(str);
        System.out.println("Tabulation :- " + Leetcode_516_Longest_Pallindromic_SubSequence_Tabulation(str, si, ei, dp, isPalindrome));
        display_2D(dp);
    }
