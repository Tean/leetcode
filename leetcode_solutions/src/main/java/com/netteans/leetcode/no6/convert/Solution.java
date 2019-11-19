package com.netteans.leetcode.no6.convert;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component("no6convert")
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        char[] chars = s.toCharArray();
        int currnum = 0;
        int rev = 1;
        StringBuffer[] stringBuffers = new StringBuffer[numRows];
        for (int i = 0; i < stringBuffers.length; i++) {
            stringBuffers[i] = new StringBuffer();
        }

        for (int i = 0; i < chars.length; i++, currnum += rev) {
            if (currnum == 0 && rev < 0 || currnum == numRows - 1 && rev > 0) {
                rev = 0 - rev;
            }
            stringBuffers[currnum].append(chars[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            stringBuilder.append(stringBuffers[i]);
        }
        return stringBuilder.toString();
    }
}
