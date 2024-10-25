package LinkedList;

public class IntersectionofTwoLinkedLists {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
            int countA = 0;
            int countB = 0;
            ListNode currentA = headA;
            ListNode currentB = headB;
            while(currentA != null){
                countA++;
                currentA =currentA.next;
            }
        while(currentB != null){
            countB++;
            currentB =currentB.next;
        }
        //Di chuyển con trỏ đầu của danh sách dài hơn:
        //đưa hai con tror trở lại đầu danh sách
        currentA = headA;
        currentB = headB;
        if(countA> countB){
            int diff= countA - countB;
            for (int i = 0; i < diff; i++) {

                currentA = currentA.next;
            }
        }else{
            int diff = countB - countA;
            for (int i = 0; i < diff; i++) {

                currentB = currentB.next;
            }
        }
        //duyệt hai danh sách cùng lúcw\
        while(currentA != null && currentB != null){
            if(currentA == currentB){
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
    }
    //Tìm điểm giao nhau của hai danh sách liên kết.
    public static void main(String[] args) {
        // Tạo danh sách liên kết đầu vào
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersection = new ListNode(8);
        headA.next.next = intersection;
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;

        // Tìm điểm giao
        ListNode result = getIntersectionNode(headA, headB);

        // In kết quả
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }
    }

