package LinkedList;

public class ReverseLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){ this.val = val;}
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    // 5 3 4
    public static ListNode reverseList(ListNode headNode){
        ListNode curNode = headNode;
        while (headNode!= null && curNode.next != null){
            ListNode nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = headNode;
            headNode = nextNode;
        }
        return headNode;
    }
    public static void print(ListNode head){
        if(head == null){
            System.out.println("List empty");
        }else{
            ListNode temp;
            temp = head;
            while (temp != null){
                System.out.print(temp.val);
                temp = temp.next;
                if (temp != null){
                    System.out.print("->");
                }else{
                    System.out.println();
                }
            }
        }
    }
    public static void main(String[] args) {
        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        print(a1);
        ListNode newList = reverseList(a1);
        print(newList);
    }
}
