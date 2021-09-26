package com.alg.easy;

import com.alg.model.ListNodeAlg;

import java.util.HashSet;
import java.util.Set;

public class HasCycle141 {


    public static void main(String[] args) {
        ListNodeAlg.ListNode node = null;
        hasCycleCur(node);
    }

    private static boolean hasCycleCur(ListNodeAlg.ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNodeAlg.ListNode slow = node;
        ListNodeAlg.ListNode fast = node.next;
        while (slow != fast) {
            if (node == null || node.next == null) {
                return false;
            }
            slow = node.next;
            fast = node.next.next;
        }
        return true;
    }

    private static boolean hasCycleHash(ListNodeAlg.ListNode node) {
        Set<ListNodeAlg.ListNode> nodeList = new HashSet<>();
        while (node != null) {
            if (!nodeList.add(node)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
