package Sort;

import java.util.Scanner;

public class InsertionSortv2 {
    public static void insertionSort(int a[]){
        int n  = a.length;
        for (int i = 1; i < n; i++) {
            int ai = a[i];
            int j = i -1;
            while(j >= 0 && a[j]> ai){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = ai;
            printArray(a);
        }
    }
    public static void printArray(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ",a[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  n = scanner.nextInt();
        int a [ ]= new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        insertionSort(a);
    }
}
