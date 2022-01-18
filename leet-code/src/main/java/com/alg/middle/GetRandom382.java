package com.alg.middle;

import com.alg.model.ListNodeAlg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetRandom382 {
    List<Integer> list;
    Random random;

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }

    public void get(ListNodeAlg.ListNode head) {
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        random = new Random();
    }
}
