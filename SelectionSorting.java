public class SelectionSorting {
    public static void main(String[] args) {
        
        int arr[] = {81, 15, 7, 60, 5, 36}; 
        int length = arr.length;

        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j < length; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println();
        System.out.println("Sorted Array: ");
        for(int i = 0; i < length; i++)
            System.out.print(arr[i] + " ");
    }
}
