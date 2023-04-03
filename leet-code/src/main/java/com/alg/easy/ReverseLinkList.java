package com.alg.easy;

import java.util.LinkedList;

/**
 * @author dongyl-work
 * @date 2021/3/18 下午1:49
 **/
public class ReverseLinkList {
    public LinkNode reverseBetween(LinkNode head , int left,int right){
        LinkNode dummyNode = new LinkNode(-1);
        dummyNode.next = head;
        LinkNode pre = dummyNode;
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }
        LinkNode cur = pre.next;
        LinkNode next;
        for (int i = 0; i < right-left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;

    }

    public class LinkNode{
        LinkNode next;
        int root;
        public LinkNode(int root) {
            this.root = root;
        }
    }
}
