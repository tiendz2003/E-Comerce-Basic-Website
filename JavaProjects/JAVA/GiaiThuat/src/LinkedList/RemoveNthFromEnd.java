package LinkedList;


import java.util.List;

public class RemoveNthFromEnd {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val =val;
            next = null;
        }
    }
    public static ListNode removeNthFromEnd(ListNode headNode,int n){
        ListNode curNode = headNode;
        int count = 1;
        ListNode wantedNode=null;
        while(curNode != null){
            if(count == n+1){
                wantedNode= headNode;
            }
            //the Last Node
            if(curNode.next == null) {
                if (wantedNode == null) {
                    if (count == n) {
                        return headNode.next;
                    }
                    return headNode;
                } else {
                    if (wantedNode.next != null) {
                        wantedNode.next = wantedNode.next.next;
                        return headNode;
                    }
                }
            }
            count++;
            curNode = curNode.next;
            wantedNode = wantedNode ==null ? null:wantedNode.next;
        }
        return headNode;
    }
    // Hàm hỗ trợ để in danh sách liên kết
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Danh sách gốc:");
        printList(head);

        // Xoá node thứ 2 từ cuối danh sách (kết quả mong đợi: 1->2->3->5)
        int n = 2;
        head = removeNthFromEnd(head, n);

        System.out.println("Danh sách sau khi xoá node thứ " + n + " từ cuối:");
        printList(head);
    }
    /*public class RemoveNthFromEnd {
        public static class ListNode {
            int val;
            ListNode next;
            ListNode(int val) {
                this.val = val;
                next = null;
            }
        }

        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first = dummy;
            ListNode second = dummy;

            // Di chuyển con trỏ first n+1 bước
            for (int i = 0; i <= n; i++) {
                first = first.next;
            }

            // Di chuyển cả hai con trỏ cho đến khi first đạt đến cuối danh sách
            while (first != null) {
                first = first.next;
                second = second.next;
            }

            // Bỏ qua node cần xoá
            second.next = second.next.next;

            return dummy.next;
        }*/
}
