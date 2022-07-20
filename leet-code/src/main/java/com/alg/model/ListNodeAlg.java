package com.alg.model;

public class ListNodeAlg {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;
        public ListNode child;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode cur = node;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }
}
