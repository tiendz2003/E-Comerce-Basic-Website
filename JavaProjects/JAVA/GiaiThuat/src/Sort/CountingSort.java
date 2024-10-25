package Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountingSort {
    public static int[] countingSort(List<Integer> arr){
        int maxCount = 100;
        int count[] = new int[maxCount];
        for (int c : arr){
            count[c]++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            List<Integer> a = new ArrayList<>();
            int numElements = scanner.nextInt();
            for (int i = 0; i < numElements; i++) {
            int element = scanner.nextInt();
            a.add(element);
        }

        int[] result = countingSort(a);


        for (int value : result) {
            System.out.print(value + " ");
        }

        scanner.close();
    }
}
