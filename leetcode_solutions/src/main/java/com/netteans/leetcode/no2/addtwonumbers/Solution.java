package com.netteans.leetcode.addTwoNumbers;

import org.springframework.stereotype.Component;

@Component("no2solution")
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode(0);
        ListNode l1n = l1;
        ListNode l2n = l2;
        ListNode rn = ln;

        while (l1n != null || l2n != null) {

            int val = l1n == null ? 0 : l1n.val;
            val += l2n == null ? 0 : l2n.val;

            rn.val += val;

            if (rn.val >= 10) {
                rn.val -= 10;
                rn.next = new ListNode(1);
            }

            boolean l1cond = l1n != null && l1n.next != null;
            boolean l2cond = l2n != null && l2n.next != null;
            if (l1cond || l2cond) {
                rn.next = rn.next == null ? new ListNode(0) : rn.next;
            }
            rn = rn.next;

            l1n = l1n == null ? null : l1n.next;
            l2n = l2n == null ? null : l2n.next;
        }

        return ln;
    }
}
