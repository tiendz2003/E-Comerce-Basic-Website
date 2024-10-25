package LinkedList;

public class ReorderList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    //Sắp xếp lại danh sách liên kết sao cho L0 → Ln → L1 → Ln-1 → L2 → Ln-2...
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Đảo ngược nửa sau của danh sách
        ListNode prev = null, curr = slow, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        //Kêết hợp 2 nưửa
        ListNode first = head, second = prev;
        while (true) {
            assert second != null;
            if (second.next == null) break;
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;

        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);

        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

