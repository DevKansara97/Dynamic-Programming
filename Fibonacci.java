
import java.util.*;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }

        System.out.println(fibonacci_dp(n, dp));
        System.out.println(fibonacci_recurse(n));
        System.out.println(fibonacci_tabulation(n));
        System.out.println(fibonacci_optimized(n));
    }

    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
    // TC: O(2^n)
    // SC: O(n) (Stack memory)
    static int fibonacci_recurse(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci_recurse(n - 1) + fibonacci_recurse(n - 2);
    }

    // TC: O(n)
    // Sc: O(n)
    static int fibonacci_dp(int n, int[] dp) {
        if (n <= 1) {
            return n;
        } else {
            if (dp[n] != -1) {
                return dp[n];
            } else {
                return fibonacci_dp(n - 1, dp) + fibonacci_dp(n - 2, dp);
            }
        }
    }

    // TC: O(n)
    // Sc: O(n)
    static int fibonacci_tabulation(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // TC: O(n)
    // Sc: O(1)
    static int fibonacci_optimized(int n) {
        int curr = 0, prev1 = 1, prev2 = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}
