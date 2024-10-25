package Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

    public static void insertionSort(int n, List<Integer> arr) {
        int tmp = arr.get(n - 1);
        for (int i = n - 1; i >= 0; i--) {
            if (i - 1 >= 0 && arr.get(i - 1) >= tmp) {
                arr.set(i, arr.get(i - 1));
            } else {
                arr.set(i, tmp);
                break;
            }
            printList(arr);
        }

    }

    public static void printList(List<Integer> arr) {
        for (int j = 0; j < arr.size(); j++) {
            if (j > 0) {
                System.out.print(" " + arr.get(j));
            } else {
                System.out.print(arr.get(j));
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            arrayList.add(element);
        }

        for (int i = 2; i <= n; i++) {
            insertionSort(i, arrayList);
        }
        printList(arrayList);
    }
}
