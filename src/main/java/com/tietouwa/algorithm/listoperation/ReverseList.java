package com.tietouwa.algorithm.listoperation;

public class ReverseList {

    public static class Node {
        public Object o;
        public Node next;
        public Node pre;
        public Node (Object o, Node next) {
            this.o = o;
            this.next = next;
        }

        public Node (Object o, Node pre, Node next) {
            this.o = o;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            String s = printNext();
            s += "\n";
            s += printPre();
            return s;
        }

        private String printNext() {
            return o + "--->" + ((next == null) ? null : next.printNext());
        }
        private String printPre() {
            return ((pre == null) ? null : pre.o) + "<---" + ((next == null) ? o : next.printPre());
        }
    }

    public static void main(String[] args) {
        //单链表反转
        Node node = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        System.out.println(node);
        Node node1 = reverseLinkedList(node);
        System.out.println(node1);

        //双链表反转
        System.out.println("===============================");
        Node doubleNode = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node pre = null;
        Node nowNode = doubleNode;
        while (nowNode != null) {
            nowNode.pre = pre;
            pre = nowNode;
            nowNode = nowNode.next;
        }
        System.out.println(doubleNode);
        Node doubleNode1 = reverseDoubleLinkedList(doubleNode);
        System.out.println(doubleNode1);

        //单链表删除
        System.out.println("===============================");
        Node delNode = new Node(1, new Node(1, new Node(2, new Node(1, new Node(1, new Node(5, new Node(1, new Node(1, null))))))));
        System.out.println(delNode);
        Node delNode2 = delObjFromNode(delNode, 1);
        System.out.println(delNode2);


    }

    public static Node reverseLinkedList(Node head) {
        Node pre =  null;
        Node next =  null;
        while (head.next != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }

    public static Node reverseDoubleLinkedList(Node head) {
        Node temp =  null;
        Node pre =  null;
        while (head != null) {
            temp = head.next;
            head.next = head.pre;
            head.pre = temp;
            pre = head;
            head = head.pre;
        }
        return pre;
    }

    public static Node delObjFromNode(Node head, Object o) {
        Node first =  head;
        while (head != null) {
            if (head.o.equals(o)) {
                first = head.next;
            }
            if (head.next != null && head.next.o.equals(o)) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return first;
    }

}
