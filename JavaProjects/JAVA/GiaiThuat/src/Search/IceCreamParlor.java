package Search;

import java.util.*;

public class IceCreamParlor {
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
       List<Integer> a = new ArrayList<>(2);
        a.add(0); // Initialize with two elements
        a.add(0);
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if(arr.get(i) + arr.get(j) == m){
                    a.set(0,i+1);
                    a.set(1,j+1);
                    return a;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            int numElements = scanner.nextInt();
            for (int j = 0; j < numElements; j++) {
                int element = scanner.nextInt();
                arr.add(element);
            }
            List<Integer> result = icecreamParlor(money, arr);
            results.add(result);
        }
        for (List<Integer> result : results) {
            if (result == null) {
                System.out.println("No such pair exists");
            } else {
                for (Integer index : result) {
                    System.out.print(index + " ");
                }
                System.out.println();
            }
        }
    }
}
