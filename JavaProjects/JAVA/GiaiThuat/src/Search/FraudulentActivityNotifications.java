package Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FraudulentActivityNotifications {
    static Scanner sc = new Scanner(System.in);
    public static double findMedian(List<Integer> numbers){
        Collections.sort(numbers);
        int size = numbers.size();
        if(size %2 == 1){
            return numbers.get(size/2);
        }else{
            int mid1 = size/2 - 1;
            int mid2= size/2;
            return (numbers.get(mid1)+ numbers.get(mid2))/2.0;
        }
    }
    public static int activityNotifications(List<Integer> expenditure, int d) {

        int count = 0;
        for (int i = 0; i <= expenditure.size()-d-1; i++) {
            List<Integer> numberPick = new ArrayList<>(expenditure.subList(i,i+d));
            double median = findMedian(numberPick);
            if(median*2 <= expenditure.get(i+d) ){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        List<Integer> expenditure = new ArrayList<>();
        // Example data (you can modify this for testing)
        int n = sc.nextInt();
        int d = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int element= sc.nextInt();
            expenditure.add(element);
        }


        int result = activityNotifications(expenditure, d);
        System.out.println(result);
    }
}
