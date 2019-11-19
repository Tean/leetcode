package com.netteans.leetcode.no5.longestpalindrome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("no5solution")
public class Solution {
    private static final Logger log = LoggerFactory.getLogger(Solution.class);

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        StringBuilder is = new StringBuilder();
        is.append('#');
        for (int i = 0; i < s.length(); i++) {
            is.append(s.charAt(i)).append("#");
        }
        char[] ncs = is.toString().toCharArray();
        int start = 0;
        int end = 0;

        for (int i = 0; i < ncs.length; i++) {
            int dl = Math.min(i, ncs.length - 1 - i);
            for (int j = 0; j <= dl; j++) {
                char l = ncs[i - j];
                char r = ncs[i + j];

                if (l != r || j == dl) {
                    int vstart = 0;
                    int vend = 0;
                    if (j != dl) {
                        vstart = i - j + 1;
                        vend = i + j - 1;
                    } else {
                        vstart = i - j;
                        vend = i + j;
                    }
                    if (vend - vstart > end - start) {
                        start = vstart;
                        end = vend;
                    }
                    break;
                }
            }
        }

        StringBuilder rsb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            rsb.append(ncs[i]);
        }
        return rsb.toString().replace("#", "");
    }
}
