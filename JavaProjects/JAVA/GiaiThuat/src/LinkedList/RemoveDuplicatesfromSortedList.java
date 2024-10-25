package LinkedList;



public class RemoveDuplicatesfromSortedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val ){
            this.val = val;
            next = null;
        }
    }
    //  Loại bỏ các phần tử trùng lặp khỏi danh sách liên kết đã được sắp xếp.
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next !=null){
            if(curr.val == curr.next.val ){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);

        ListNode result = deleteDuplicates(l1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
