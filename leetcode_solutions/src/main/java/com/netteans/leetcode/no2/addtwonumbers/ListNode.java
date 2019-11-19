package com.netteans.leetcode.no2.addtwonumbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author netteans
 */
@Component
public class ListNode {
    int val;

    ListNode next;

    ListNode(@Value("0") int x) {
        val = x;
    }
}
