package Sort;

import java.util.*;

public class CountingSort2 {
    public static List<Integer> countingSort(List<Integer> arr) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int num : arr){
            count.put(num,count.getOrDefault(num,0)+1);
        }

        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(count.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                /*int fregCompare = o2.getValue().compareTo(o1.getValue());
                if (fregCompare == 0) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return fregCompare;
                }*/
                return o1.getKey().compareTo(o2.getKey());
            }
        });

//       /* for(Map.Entry<Integer,Integer> entry : entryList){
//            System.out.println(entry.getKey()+"= "+ entry.getValue());
//        }*/
        List<Integer> sortList = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : entryList){
            int value = entry.getKey();
            int cnt = entry.getValue();
            for (int i = 0; i < cnt; i++) {
                sortList.add(value);
            }
        }

        return sortList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int element =sc.nextInt();
            a.add(element);
        }
        List<Integer> result = countingSort(a);


        for (int value : result) {
            System.out.print(value + " ");
        }

    }
}
