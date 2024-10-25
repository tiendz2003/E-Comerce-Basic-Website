package Search;

import java.util.*;

public class HackerlandRadioTransmitters {
    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        Collections.sort(x);
        int count = 0;
        int n = x.size();
        int i =0;
        while (i<n){
            count ++;
            int loc = x.get(i)+k;
            while (i<n && x.get(i)<= loc){
                i++;
            }
            loc = x.get(--i)+k;
            while (i<n && x.get(i)<= loc){
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(7, 2, 4, 6, 5, 9, 12, 11));
        //2,4,5,6,7,9,11,12
        System.out.println(hackerlandRadioTransmitters(a, 2)); // Output should be 3
    }
}
