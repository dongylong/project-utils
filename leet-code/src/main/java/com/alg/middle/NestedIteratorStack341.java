package com.alg.middle;

import java.util.*;

public class NestedIteratorStack341 implements Iterator<Integer> {

    private Deque<Iterator<NestedInteger>> stack;

    public NestedIteratorStack341(List<NestedInteger> nestedList) {
        stack = new LinkedList();
        stack.push(nestedList.iterator());
    }


    @Override
    public Integer next() {
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()){
            Iterator<NestedInteger> it = stack.peek();
            if(!it.hasNext()){
                stack.pop();
                continue;
            }
            NestedInteger nest = it.next();
            if(nest.isInteger()){
                List<NestedInteger> list = new ArrayList<>();
                list.add(nest);
                stack.push(list.iterator());
                return true;
            }
            stack.push(nest.getList().iterator());
        }
        return false;
    }

    //--
    
}