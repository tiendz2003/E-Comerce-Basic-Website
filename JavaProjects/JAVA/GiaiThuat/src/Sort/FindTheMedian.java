package Sort;

import java.util.Scanner;

public class FindTheMedian {
    public static void findTheMedian(int a[]){
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int ai = a[i];
            int j = i- 1;
            while(j >= 0 && a[j] > ai){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = ai;
        }
    }
    public static int theMedian(int a[]){
        int n = a.length;
        findTheMedian(a);
        if (n % 2 == 0) {
            throw new IllegalArgumentException("Array has an even number of elements, it should have an odd number of" +
                    " elements to find a single middle element.");
        }
        return a[n/2];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[ ] = new  int[n];
        for (int i = 0; i < n; i++) {
            a[i]= scanner.nextInt();
        }
        System.out.println(theMedian(a));
    }
}
