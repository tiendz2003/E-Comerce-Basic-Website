package LinkedList;

public class MyLinkedList {
    public static class Node{
        int value;
        Node next ;
        Node(int value){
            this.value = value;
        }
    }
    public static void print(Node head){
        if(head == null){
            System.out.println("List empty");
        }else{
            Node temp;
            temp = head;
            while (temp != null){
                System.out.print(temp.value);
                temp = temp.next;
                if (temp != null){
                    System.out.print("->");
                }else{
                    System.out.println();
                }
            }
        }
    }
    public static Node addToHead(Node headNode,int value){
        Node newNode = new Node(value);
        if(headNode != null){
            newNode.next = headNode;
        }
        return newNode;
    }
    public static Node addtoLast(Node headNode,int value){
        Node newNode = new Node(value);
        if(headNode == null){
            return newNode;
        }else{
            Node lastNode =headNode;
            while (lastNode.next !=null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        return headNode;
    }
    public static Node addtoMiddle(Node headNode,int value,int index){
        Node newNode = new Node(value);
        if(index ==0){
            return addToHead(headNode,value);
        }
        else{
            Node curNode = headNode;
            int count = 0;
            while(curNode != null){
                count++;
                if(count == index){
                    newNode.next = curNode.next;
                    curNode.next = newNode;
                    break;
                }
                curNode = curNode.next;
            }
        }
        return headNode;
    }
    public static Node removeAtHead(Node headNode){
        if(headNode != null){
            return headNode.next ;
        }
        return null;
    }
    public static Node removeAtLast(Node headNode){
        if (headNode== null){
            return null;
        }
        Node lastNode =headNode;
        Node prevNode = null;
        while (lastNode.next != null){
            prevNode = lastNode;
            lastNode = lastNode.next;
        }
        if(prevNode == null){
            return null;
        }else{
            prevNode.next = lastNode.next;
        }
        return headNode;
    }
    public static Node removeAtIndex(Node headNode,int index) {
        if (headNode == null || index < 0) {
            return null;
        }
        if (index == 0) {
            return removeAtHead(headNode);
        }

        Node curNode = headNode;
        Node prevNode = null;
        int count = 0;
        boolean isFound = false;
        while (curNode != null) {
            if (count == index) {
                isFound = true;
                break;
            }
            prevNode = curNode;
            curNode = curNode.next;
            count++;
        }
        if (isFound) {
            if (prevNode == null) {
                return null;
            } else {
                if (curNode != null) {
                    prevNode.next = curNode.next;
                }
            }
        }
        return headNode;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        print(n1);
        Node newList = addToHead(n1,3);
        print(newList);
        n1 = addtoLast(n1,5);
        print(n1);
        n1 = removeAtLast(n1);
        print(n1);
        n1 = removeAtIndex(n1,2);
        print(n1);
    }
}
