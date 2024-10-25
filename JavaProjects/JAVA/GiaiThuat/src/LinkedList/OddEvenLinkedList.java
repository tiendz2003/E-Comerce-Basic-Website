package LinkedList;

public class OddEvenLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        // Tạo danh sách liên kết đầu vào
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(7);

        // Chuyển đổi danh sách theo yêu cầu
        ListNode result = oddEvenList(head);

        // In danh sách đã chuyển đổi
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
