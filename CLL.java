public class CLL {
    private Node head;
    private Node tail;
    private class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }
    
    public void deleteNode(int val) {
        if(head == null) {
            return;
        }

        else if(head.data == val) {
            head = head.next;
            tail.next = head;
        }
        Node node = find(val);
        node.next = node.next.next;
    }

    public Node find(int val) {
        Node temp = head;
        while(temp.next.data != val) {
            temp = temp.next;
        }
        return temp;
    }

    public void dispaly() {
        Node temp = head;
        if(head != null) {
            do {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            while(temp != head);
        }
        System.out.println("HEAD");
    }

    public static void main(String[] args) {
        CLL clist = new CLL();
        clist.insertNode(23);
        clist.insertNode(28);
        clist.insertNode(21);
        clist.insertNode(20);
        clist.insertNode(34);
        clist.insertNode(73);
        clist.dispaly();
        clist.deleteNode(20);
        clist.dispaly();
        clist.deleteNode(28);
        clist.dispaly();
    }
}