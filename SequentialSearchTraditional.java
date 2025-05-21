public class Main {
    public static int sequentialSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found, return index
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] numbers = {4, 7, 1, 9, 3};
        int target = 1;

        int index = sequentialSearch(numbers, target);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
}
