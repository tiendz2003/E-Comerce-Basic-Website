package Search;

import java.util.*;

public class AnotherPair {
    public static int pairs(int k, List<Integer> arr) {
       Set<Integer> numbers = new HashSet<>(arr);
       int count = 0;
       for (int number : arr){
           if(numbers.contains(number+k) && numbers.contains(number-k)){
               count++;
           }
           numbers.remove(number);
       }
       return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Đọc số lượng phần tử trong danh sách
        int k = sc.nextInt();  // Đọc giá trị khoảng cách k
        List<Integer> a = new ArrayList<>();  // Tạo danh sách
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            a.add(element);
        }
        sc.close();

        System.out.println(pairs(k, a));  // Gọi hàm pairs và in kết quả
    }
}
