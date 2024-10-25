package Search;
import java.util.*;
import java.util.stream.Collectors;

public class MissingNumber {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> arrMap = new HashMap<>();
        Map<Integer, Integer> brrMap = new HashMap<>();
        List<Integer> missing = new ArrayList<>();

        // Đếm số lần xuất hiện của từng phần tử trong arr
        for (int num : arr) {
            arrMap.put(num, arrMap.getOrDefault(num, 0) + 1);
        }

        // Đếm số lần xuất hiện của từng phần tử trong brr
        for (int num : brr) {
            brrMap.put(num, brrMap.getOrDefault(num, 0) + 1);
        }

        // So sánh số lần xuất hiện của từng phần tử trong brr với arr
        for (int num : brrMap.keySet()) {
            if (!arrMap.containsKey(num) || !arrMap.get(num).equals(brrMap.get(num))) {
                missing.add(num);
            }
        }

        // Sắp xếp danh sách kết quả theo thứ tự tăng dần
        Collections.sort(missing);
        return missing;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // List<Integer> a = new ArrayList<>(Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206));
        //List<Integer> b = new ArrayList<>(Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204));
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            a.add(element);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int element = sc.nextInt();
            b.add(element);
        }
        List<Integer> missing = missingNumbers(a,b);
        String result = missing.stream().map(String :: valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
