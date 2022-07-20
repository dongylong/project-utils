package com.alg.middle;

import com.alg.model.ListNodeAlg;

public class AddTwoNumbers02 {

    public  ListNodeAlg.ListNode addTwoNumbers(ListNodeAlg.ListNode l1, ListNodeAlg.ListNode l2) {
         ListNodeAlg.ListNode head = null;
         ListNodeAlg.ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new  ListNodeAlg.ListNode(sum % 10);
            } else {
                tail.next = new  ListNodeAlg.ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry>0){
            tail.next = new  ListNodeAlg.ListNode(carry);
        }
        return head;
    }
}
