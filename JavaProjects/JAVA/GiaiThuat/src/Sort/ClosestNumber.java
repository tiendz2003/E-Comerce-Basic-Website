package Sort;

import java.util.Scanner;

public class ClosestNumber {
    public static void insertionSort(int a[]){
        int n  = a.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int ai = a[i];
            int j = i -1;
            while(j >= 0 && a[j]> ai){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = ai;
        }
        for (int i = 0; i < n-1; i++) {
            int diff = a[i+1] -a[i];
            if(diff<minDiff){
                minDiff = diff;
            }
        }
        for (int i = 0; i < n-1; i++) {
            int diff = a[i+1] -a[i];
            if(diff==minDiff){
                minDiff = diff;
                System.out.print(a[i]+" "+a[i+1]+" ");
            }
        }
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
