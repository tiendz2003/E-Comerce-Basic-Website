package Sort;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumberDissappeareArray {
    public static List<Integer> findMissingValue(int [] a){
        ArrayList<Integer> result= new ArrayList<>();
        boolean [] exist = new boolean[a.length+1];
        for (int i = 0; i < a.length; i++) {
            exist[a[i]] = true;
        }
        for (int i = 0; i < a.length; i++) {
            if(!exist[i]){
                result.add(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int a[] = new int []{4,3,2,7,8,2,3,1};
        System.out.println(findMissingValue(a));
    }
}
