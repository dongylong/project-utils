package com.alg.easy;

import java.util.Iterator;
import java.util.List;

public class DelDumplicates83 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(1, new ListNode(2, null)));
//        ListNode node = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        print(node);
        del(node);
        System.out.println("----------");
        print(node);
    }

    private static void print(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode cur = node;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }

    private static ListNode del(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode cur = node;
        while (cur.next!=null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return node;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
