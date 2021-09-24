package com.alg.middle;


import com.alg.model.ListNodeAlg;

public class Flatten430 {

    public static void main(String[] args) {

    }
    public static ListNodeAlg.ListNode flatten(ListNodeAlg.ListNode node) {
        dfs(node);
        return node;
    }
    public static ListNodeAlg.ListNode dfs(ListNodeAlg.ListNode node) {
        ListNodeAlg.ListNode cur = node;
        ListNodeAlg.ListNode last = null;
        while (cur != null) {
            ListNodeAlg.ListNode next = cur.next;
            //如果有子节点，首先处理子节点
            if (cur.child != null) {
                ListNodeAlg.ListNode childLast = dfs(cur.child);
                next = cur.next;
                //node与child相连
                cur.next = cur.child;
                cur.child.prev = cur;
                //如果next不为空，将last与next相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
