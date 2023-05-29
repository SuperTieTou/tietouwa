package com.tietouwa.algorithm.listoperation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class StackByQueue {

    private Queue<String> add;
    private Queue<String> rem;

    private int size = 0;

    public StackByQueue() {
        add = new LinkedList<>();
        rem = new LinkedList<>();
    }

    public void push(String s) {
        add.add(s);
        size++;
    }

    public String pop() {
        size--;
        for (int i = 0; i < size; i++) {
            rem.add(add.remove());
        }
        String result = add.remove();
        Queue<String> temp = add;
        add = rem;
        rem = temp;
        return result;
    }

    public static void main(String[] args) {
        StackByQueue sq = new StackByQueue();
        sq.push("asdqw1");
        sq.push("aqweq2");
        sq.push("aqweq3");
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        sq.push("aqweq4");
        sq.push("aqweq5");
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        sq.push("aqweq6");
        System.out.println(sq.pop());
    }

}
