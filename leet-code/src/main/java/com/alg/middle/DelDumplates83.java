package com.alg.middle;

import com.alg.model.ListNodeAlg;

public class DelDumplates83 {

    public static void main(String[] args) {
         ListNodeAlg.ListNode node = new  ListNodeAlg.ListNode(1, new  ListNodeAlg.ListNode(1, new  ListNodeAlg.ListNode(2, null)));
//         ListNodeAlg.ListNode node = new  ListNodeAlg.ListNode(1, new  ListNodeAlg.ListNode(1, new  ListNodeAlg.ListNode(2, new  ListNodeAlg.ListNode(3, new  ListNodeAlg.ListNode(3, null)))));
        print(node);
        delDumplates(node);
        System.out.println("----------");
        print(node);
    }

    private static void print( ListNodeAlg.ListNode node) {
        if (node == null) {
            return;
        }
         ListNodeAlg.ListNode cur = node;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }


    private static  ListNodeAlg.ListNode delDumplates( ListNodeAlg.ListNode node) {
        if (node == null) {
            return node;
        }
         ListNodeAlg.ListNode cur = node;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return node;
    }
}
