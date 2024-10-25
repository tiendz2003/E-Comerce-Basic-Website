package LinkedList;

public class SortList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;
         //Đệ quy sắp xếp hai nửa
        left = sortList(left);
        right = sortList(right);

        return merge(left,right);
    }
    public static ListNode getMiddle(ListNode head){
        if (head == null) {
            return head;
        }
        ListNode slow= head,fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Tạo danh sách liên kết đầu vào
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        // Sắp xếp danh sách
        ListNode sortedHead = sortList(head);

        // In danh sách đã sắp xếp
        ListNode current = sortedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
