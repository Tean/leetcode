package com.netteans.leetcode;

public class ReverseInteger {


    public int reverse(int x) {
        int[] ars = new int[0];
        do {
            int n = x % 10;
            int[] nars = new int[ars.length + 1];
            System.arraycopy(ars, 0, nars, 0, ars.length);
            nars[ars.length] = n;
            ars = nars;
            x /= 10;
        } while (x != 0);

        long r = 0;
        for (int i = 0; i < ars.length; i++) {
            long c = ars[i];
            for (int j = 0; j < ars.length - i - 1; j++) {
                c *= 10;
            }
            if (c > Integer.MAX_VALUE || c < Integer.MIN_VALUE) {
                return 0;
            }
            r += c;
            if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) r;
    }
}
