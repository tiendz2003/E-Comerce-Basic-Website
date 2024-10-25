package Array;

public class Find_Number {
    public static int findNumbers(int num[]){
        int count= 0;

        for (int a : num){
            int slSo = countNumbers(a);
            if (countNumbers(a) % 2 == 0){
                count++;
            }
        }
        return count;
    }
    public static int countNumbers(int a){
        int count = 0 ;
        int kq = a;
        while (kq !=0){
            kq = a/10;
            a=kq;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,22};
        System.out.println(findNumbers(num));
    }
}
