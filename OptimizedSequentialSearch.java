public class Main {
    public static int search(int[] arr, int target, int size) {
        int start = 0, end = size - 1;

        while (start <= end) {
            if (arr[start] == target) {
                return start;
            }
            if (arr[end] == target) {
                return end;
            }
            start++;
            end--;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 9, 3};
        int target = 1;
        int size = arr.length;
        int pos = search(arr, target, size);

        if (pos == -1) {
            System.out.println("Element is not present in array");
        } else {
            System.out.println("Element is present at index " + pos);
        }
    }
}