package com.tietouwa.algorithm.listoperation;

import java.util.Stack;

public class QueueByStack {

    private Stack<String> push;
    private Stack<String> pop;

    public QueueByStack() {
        push = new Stack<>();
        pop = new Stack<>();
    }

    public void add(String s) {
        push.push(s);
    }

    public String rem() {
        if (pop.empty()) {
            while (!push.empty()) {
                pop.push(push.pop());
            }
        }
        return pop.pop();
    }

    public static void main(String[] args) {
        QueueByStack qs = new QueueByStack();
        qs.add("asdqw1");
        qs.add("aqweq2");
        qs.add("aqweq3");
        System.out.println(qs.rem());
        System.out.println(qs.rem());
        qs.add("aqweq4");
        qs.add("aqweq5");
        System.out.println(qs.rem());
        System.out.println(qs.rem());
        System.out.println(qs.rem());
        System.out.println(qs.rem());
        qs.add("aqweq6");
        System.out.println(qs.rem());

    }

}
