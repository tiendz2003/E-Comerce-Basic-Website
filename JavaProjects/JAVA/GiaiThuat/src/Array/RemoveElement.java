package Array;

public class RemoveElement {
    public static int removeElement(int[] nums, int value) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != value) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2,3, 3, 4, 5};
        int value = 3;
        int length = removeElement(num, value);
        for (int i = 0; i < length; i++) {
            System.out.println(num[i]);
        }
    }
}
