package com.netteans.leetcode.no3.lengthoflongestsubstring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author netteans
 */
@Component("no3solution")
public class Solution {
    private static final Logger log = LoggerFactory.getLogger(Solution.class);

    public int lengthOfLongestSubstring(String s) {
        log.info("s is {}", s);
        int max = 0;
        int left = 0;
        int right = 0;

        Map<Character, Integer> loc = new HashMap<>();
        Set<Character> rm = new HashSet<>();

        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            log.info("now get {}", Solution.gotSubStr(s, left, right));

            if (loc.containsKey(c)) {
                log.info("{}", Solution.gotSubStr(s, left, right));
                max = Math.max(max, right - left);
                left = loc.get(c) + 1;

//                rm.clear();
//                int finalLeft = left;
//                loc.forEach((k, v) -> {
//                    if (v < finalLeft) {
//                        rm.add(k);
//                    }
//                });
//                rm.forEach(loc::remove);
                loc.clear();
                right = left + 1;
            }
            loc.put(c, right);

        }

        return Math.max(max, right - left);
    }

    private static String gotSubStr(String s, int left, int right) {
        return s.substring(left, right);
    }
}
