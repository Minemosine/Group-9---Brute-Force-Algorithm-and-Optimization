
package com.mycompany.travelingsalesman;

class TravelingSalesman {

    static int tsp(int[][] cost) {
        int numNodes = cost.length;
        int[] nodes = new int[numNodes - 1];

        for (int i = 1; i < numNodes; i++) {
            nodes[i - 1] = i;
        }

        int minCost = 1000000;

        do {
            int currCost = 0;
            int currNode = 0;

            for (int i = 0; i < nodes.length; i++) {
                currCost += cost[currNode][nodes[i]];
                currNode = nodes[i];
            }

            currCost += cost[currNode][0]; // return to start

            if (currCost < minCost) {
                minCost = currCost;
            }

        } while (nextPermutation(nodes));

        return minCost;
    }

    static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverse(arr, i + 1, arr.length - 1);

        return true;
    }

    static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[][] cost = {
            { 0, 10, 15, 20 },
            { 10, 0, 35, 25 },
            { 15, 35, 0, 30 },
            { 20, 25, 30, 0 }
        };

        int result = tsp(cost);
        System.out.println("Minimum cost: " + result);
    }
}

