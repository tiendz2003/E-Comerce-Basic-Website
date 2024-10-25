package Sort;

public class MergeSort {
    public static void mergeSort (int n1[],int n2[],int n,int m){
        int i = n - 1;
        int j = m - 1;
        int k =(m+n)-1;
        while (k >= 0){
            if(n1[i] < n2[j]){
                n1[k] = n2[j];
                j--;
            }else if(n1[i]>n2[j]){
                n1[k] = n1[i];
                i--;
            }else if(j<0){
                n1[k] = n1[i];
                i--;
            } else if (i<0) {
                n1[k] = n2[j];
                j--;
            }
            k--;
        }
    }
    public static void main(String[] args) {
        int n1[] = new int[]{1,2,3,0,0,0};
        int n2[] = new int [ ]{ 2,4,5};
         mergeSort(n1,n2,3,3);
         for (int n : n1){
             System.out.println(n);
         }
    }
}
