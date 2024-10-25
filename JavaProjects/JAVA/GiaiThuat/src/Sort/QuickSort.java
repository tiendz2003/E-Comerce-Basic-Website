package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuickSort {
    public static List<Integer> quickSort(ArrayList<Integer> a) {
        if (a == null || a.size() <= 1) {
            return a;
        }
        int pivot = a.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < a.size(); i++) {
            int value = a.get(i);
            if (value > pivot) right.add(value);
            else left.add(value);
        }

        left.add(pivot);
        left.addAll(right);
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int numElements = scanner.nextInt();
        for (int i = 0; i < numElements; i++) {
            int element = scanner.nextInt();
            arr.add(element);
        }


        ArrayList<Integer> sortedArr = (ArrayList<Integer>) quickSort(arr);

        for(int i = 0; i < sortedArr.size(); i++) {
            System.out.print(sortedArr.get(i));
            if (i != sortedArr.size() - 1) {
                System.out.print(" ");
            }
        }

    }
}
