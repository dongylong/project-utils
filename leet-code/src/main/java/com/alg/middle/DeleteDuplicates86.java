package com.alg.middle;

import com.alg.model.ListNodeAlg;

public class DeleteDuplicates86 {

    public static void main(String[] args) {
//        ListNodeAlg.ListNode node = new ListNodeAlg.ListNode(1, new ListNodeAlg.ListNode(1, new ListNodeAlg.ListNode(2, null)));
        ListNodeAlg.ListNode node = new ListNodeAlg.ListNode(1, new ListNodeAlg.ListNode(1, new ListNodeAlg.ListNode(2, new ListNodeAlg.ListNode(3, new ListNodeAlg.ListNode(3, null)))));
        ListNodeAlg.print(node);
        deleteDuplicates(node);
        System.out.println("----------");
        ListNodeAlg.print(node);
    }

    public static ListNodeAlg.ListNode deleteDuplicates(ListNodeAlg.ListNode head) {
        if (head == null) {
            return head;
        }
        ListNodeAlg.ListNode dummy = new ListNodeAlg.ListNode(0, head);
        ListNodeAlg.ListNode cur = dummy;
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

}
