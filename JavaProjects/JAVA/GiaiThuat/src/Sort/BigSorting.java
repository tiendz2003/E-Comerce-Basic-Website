package Sort;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BigSorting {

    public static List<String> bigSorting(List<String> unsorted) {
        // Create a custom comparator for sorting strings as integers
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.isEmpty() || s2.isEmpty()) {
                    // If either string is empty, treat it as a larger value
                    return s1.isEmpty() ? 1 : -1;
                }
                long i1 = Long.parseLong(s1);
                long i2 = Long.parseLong(s2);
                return Long.compare(i1, i2);
            }
        };

        // Sort the list using the custom comparator
        Collections.sort(unsorted, comparator);

        // Return the sorted list
        return unsorted;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> unsorted = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            String element = scanner.next();
            unsorted.add(String.valueOf(element));
        }

        List<String> sorted = bigSorting(unsorted);
        for (String s : sorted){
            System.out.println(s);
        }
    }
}

