package LinkedList;

public class MergeTwoSortedLists {
    public static class ListNode{
        int value;
        ListNode next;

        public ListNode(int x) {
            this.value = x;
        }
    }
    public static ListNode mergeTwoSortList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null){
            if(l1.value <= l2.value){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next= l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null){
            current.next = l1;
        }else{
            current.next = l2;
        }
        return  dummy.next;
    }
    public static void main(String[] args) {
        // Tạo danh sách liên kết đầu vào
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // Gộp hai danh sách liên kết đã sắp xếp
       // MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode result = mergeTwoSortList(l1, l2);

        // In danh sách kết quả
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
