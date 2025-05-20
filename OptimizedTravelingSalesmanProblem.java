package com.mycompany.optimized;

public class Optimized {

    static final int N = 4;
    static final int INF = 9999999;

    static int[][] dist = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };

    static int[][] dp = new int[1 << N][N];

    static int tsp(int mask, int pos) {
        if (mask == (1 << N) - 1) {
            return dist[pos][0];
        }

        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int minCost = INF;

        for (int city = 0; city < N; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = dist[pos][city] + tsp(mask | (1 << city), city);
                if (newCost < minCost) {
                    minCost = newCost;
                }
            }
        }

        dp[mask][pos] = minCost;
        return minCost;
    }

    public static void main(String[] args) {

        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        int result = tsp(1, 0);
        System.out.println("The minimum cost is " + result);
    }
}

