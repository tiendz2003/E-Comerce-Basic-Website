package Sort;

import java.util.*;

public class LyLy_Homework {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(minSwaps(arr));
    }

    public static int minSwaps(int[] arr) {
        int[] sortedAsc = arr.clone();
        int[] sortedDesc = arr.clone();

        Arrays.sort(sortedAsc);
        Arrays.sort(sortedDesc);
        reverseArray(sortedDesc);

        return Math.min(countSwaps(arr.clone(), sortedAsc), countSwaps(arr.clone(), sortedDesc));
    }

    private static int countSwaps(int[] original, int[] sorted) {
        int swaps = 0;
        boolean[] visited = new boolean[original.length];
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < original.length; i++) {
            indexMap.put(original[i], i);
        }

        for (int i = 0; i < original.length; i++) {
            if (visited[i] || original[i] == sorted[i]) {
                continue;
            }

            int cycleSize = 0;
            int x = i;

            while (!visited[x]) {
                visited[x] = true;
                x = indexMap.get(sorted[x]);
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    private static void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
