package LinkedList;

public class DetectCycleinaLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Tạo chu kỳ

        // Kiểm tra chu kỳ trong danh sách liên kết
        DetectCycleinaLinkedList solution = new DetectCycleinaLinkedList();
        boolean hasCycle = solution.hasCycle(head);

        // In kết quả
        System.out.println(hasCycle); // Output: true
    }
}
