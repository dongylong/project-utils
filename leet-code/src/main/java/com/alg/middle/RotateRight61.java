package com.alg.middle;

import com.alg.model.ListNodeAlg;

public class RotateRight61 {

    public  ListNodeAlg.ListNode rotateRight(ListNodeAlg.ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        int n = 1;
         ListNodeAlg.ListNode listNode = head;
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
         ListNodeAlg.ListNode ret = listNode.next;
        listNode.next = null;
        return ret;
    }
}
