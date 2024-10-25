package Search;

import java.util.*;

public class Pair {
    public static int pairs(int k, List<Integer> arr) {
        List<Integer> pairs = new ArrayList<>();
        int n = arr.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(Math.abs(arr.get(j) - arr.get(i)) == k){
                    pairs.add(arr.get(j));
                    pairs.add(arr.get(i));
                    count ++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int k = sc.nextInt() ;
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            a.add(element);
        }
        int result = pairs(k,a);
        System.out.println(result);
    }
}
