class Solution {

    static int recurse(int n) {
        if (n <= 1)
            return 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += recurse(i) * recurse(n - i - 1);
        }

        return cnt;
    }

    static int[] dp;

    public int numTrees(int n) {

        // return recurse(n);

        // dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return memoized(n);

        return bottomUp(n);
    }

    // Top Down:
    static int memoized(int n) {
        if (n <= 1)
            return dp[n] = 1;
        if (dp[n] != -1)
            return dp[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += memoized(i) * memoized(n - i - 1);
        }

        return dp[n] = cnt;
    }

    // Bottom-Up:
    static int bottomUp(int n) {
        int[] dp_ = new int[n + 1];
        dp_[0] = 1;
        dp_[1] = 1;
        for (int i = 2; i <= n; i++) {
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                cnt += dp_[j] * dp_[i - j - 1];
            }
            dp_[i] = cnt;
        }

        return dp_[n];
    }
}
