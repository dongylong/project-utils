package com.study.demo;

import java.util.Optional;
import java.util.Stack;

public class SimulateQueueByStack {
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();
    public Optional<Object> deleteHead() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                Object pop = stack1.pop();
                stack2.push(pop);
            }
        }
        if (stack2.size() == 0) {
            return Optional.empty();
        }
        Object pop = stack2.pop();
        return Optional.of(pop);
    }
}
