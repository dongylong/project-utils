package com.alg.middle;


import java.util.List;

public class ListNodeAlg {

    public ListNode rotateRight61(ListNode head, int k) {
        if (head == null
                || k == 0 || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode listNode = head;
        while (listNode.next != null) {
            listNode = listNode.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        listNode.next = head;
        while (add-- > 0) {
            listNode = listNode.next;
        }
        ListNode ret = listNode.next;
        listNode.next = null;
        return ret;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(1, new ListNode(2, null)));
//        ListNode node = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        print(node);
        DelDumplates83(node);
        System.out.println("----------");
        print(node);
    }

    //-------83


    private static ListNode DelDumplates83(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode cur = node;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return node;
    }


    //---------86
    public ListNode deleteDuplicates86(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
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
}
