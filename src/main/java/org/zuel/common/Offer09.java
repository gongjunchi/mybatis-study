package org.zuel.common;

import java.util.Stack;

public class Offer09 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Offer09() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
        }
        return -1;
    }
}
