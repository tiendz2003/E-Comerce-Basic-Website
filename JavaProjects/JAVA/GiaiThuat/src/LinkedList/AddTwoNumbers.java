package LinkedList;


import java.util.List;

public class AddTwoNumbers {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x+ y;
            carry = sum/10;
            curr.next = new ListNode(sum % 10 );
            curr = curr.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 !=null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Tạo danh sách liên kết đầu vào
        ListNode l1 = new ListNode(2);

        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Cộng hai số được biểu diễn bởi danh sách liên kết
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);
        // In danh sách kết quả
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
