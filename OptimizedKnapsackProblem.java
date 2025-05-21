import java.util.ArrayList;
import java.util.List;

public class OptimizedKnapsackProblem {
    static int[] weights = {2, 1, 5, 3};
    static int[] values = {300, 200, 400, 500};
    static int capacity = 10;
    static Knapsack[][] memo;

    public static void main(String[] args) {
        memo = new Knapsack[values.length][capacity + 1];

        Knapsack result = solveKnapsackProblem(capacity, weights.length - 1);

        System.out.println("Maximum value in Knapsack = " + result.totalValue);
        System.out.print("\nWeights of items included: ");
        for (int index : result.items) {
            System.out.print(weights[index] + " ");
        }
        System.out.print("\nValues of items included: ");
        for (int index : result.items) {
            System.out.print(values[index] + " ");
        }
        System.out.println();
    }

    // makes a tree of all possible combinations of items
    // and returns the combination that results in the maximum value
    // now using memoization to avoid recalculating same states
    private static Knapsack solveKnapsackProblem(int remainingCapacity, int index) {
        if (index < 0 || remainingCapacity == 0) {
            return new Knapsack(0, new ArrayList<>());
        }

        if (memo[values.length - 1][remainingCapacity] != null) {
            return memo[values.length - 1][remainingCapacity];
        }

        if (weights[index] > remainingCapacity) {
            return solveKnapsackProblem(remainingCapacity, index - 1);
        } else {
            Knapsack include = solveKnapsackProblem(remainingCapacity - weights[index], index - 1);
            include.totalValue += values[index];
            include.items.add(index);

            Knapsack exclude = solveKnapsackProblem(remainingCapacity, index - 1);
            if (include.totalValue > exclude.totalValue) {
                memo[values.length - 1][remainingCapacity] = include;
                return include;
            } else {
                memo[values.length - 1][remainingCapacity] = exclude;
                return exclude;
            }
        }
    }
}

class Knapsack {
    int totalValue;
    List<Integer> items;

    Knapsack(int totalValue, List<Integer> items) {
        this.totalValue = totalValue;
        this.items = items;
    }
}