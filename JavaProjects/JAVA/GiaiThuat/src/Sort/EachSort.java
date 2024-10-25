package Sort;

public class EachSort {
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 1, 4, 5};
        insertionSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
