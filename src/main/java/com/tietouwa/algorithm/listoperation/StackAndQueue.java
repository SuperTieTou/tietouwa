package com.tietouwa.algorithm.listoperation;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackAndQueue<T> {

    private Node<T> first;
    private Node<T> last;

    private static class Node<T> {
        public T t;
        public Node<T> next;
        public Node<T> pre;
        public Node(Node<T> pre, T t, Node<T> next) {
            this.pre = pre;
            this.t = t;
            this.next = next;
        }
    }

    public void add(T t) {
        Node<T> tNode = new Node<>(null, t, null);
        if (first == null && last == null) {
            first = tNode;
            last = tNode;
            return;
        }
        first.pre = tNode;
        tNode.next = first;
        first = tNode;
    }

    public void addLast(T t) {
        Node<T> tNode = new Node<>(null, t, null);
        if (first == null && last == null) {
            first = tNode;
            last = tNode;
            return;
        }
        last.next = tNode;
        tNode.pre = last;
        last = tNode;
    }

    public T rem() {
        if (first == null) {
            throwNEE();
        }
        T t = first.t;
        first = first.next;
        if (first != null) {
            first.pre = null;
        } else {
            last = null;
        }
        return t;
    }

    public T remLast() {
        if (last == null) {
            throwNEE();
        }
        T t = last.t;
        last = last.pre;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        return t;
    }

    private static void throwNEE() {
        throw new NoSuchElementException("链表为空");
    }

    public static void main(String[] args) {
        StackAndQueue<String> ssq = new StackAndQueue<>();
        ssq.add("asdasd");
        System.out.println(ssq.remLast());
        ssq.addLast("asdaasa");
        System.out.println(ssq.rem());

        System.out.println(ssq.rem());

    }

}
