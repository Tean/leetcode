package com.netteans.leetcode.no4.findmediansortedarrays;

import org.springframework.stereotype.Component;

@Component("no4solution")
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nl = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nl, 0, nums1.length);
        System.arraycopy(nums2, 0, nl, nums1.length, nums2.length);

        if (nl.length == 1) {
            return nl[0];
        }
        if (nl.length == 2) {
            return (1.0 * (nl[0] + nl[1]) / 2);
        }

        int[] cal = new int[nl.length % 2 == 0 ? 4 : 3];
        int start = cal.length == 3 ? 3 : 4;
        cal[0] = nl[0];
        cal[1] = nl[1];
        cal[2] = nl[2];
        if (start == 4) {
            cal[3] = nl[3];
        }

        for (int i = 0; i < cal.length; i++) {
            for (int j = 0; j < cal.length; j++) {
                if (i != j) {
                    if (cal[i] < cal[j]) {
                        int te = cal[i];
                        cal[i] = cal[j];
                        cal[j] = te;
                    }
                }
            }
        }

        for (int i = start; i < nl.length; i++) {
            int n = nl[i];
            if (n > cal[0] && n < cal[cal.length - 1]) {
                if (n > cal[1]) {
                    cal[2] = n;
                }
            }
        }

        if (cal.length == 3) {
            return cal[1];
        } else {
            return (1.0 * (cal[1] + cal[2])) / 2;
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        int[] numsl = nums1.length > nums2.length ? nums1 : nums2;
        int[] numss = nums1.length > nums2.length ? nums2 : nums1;

        int[] nl = new int[numsl.length + numss.length];

        System.arraycopy(numsl, 0, nl, 0, numsl.length);
        for (int i = numsl.length; i < numsl.length + numss.length; i++) {
            nl[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < numss.length; i++) {
            int n = numss[i];
            for (int j = 0; j < numsl.length + i; j++) {
                int nlast = nl[numsl.length - 1 + i - j];

                if (nlast > n) {
                    nl[numsl.length - 1 + i - j + 1] = nlast;
                } else {
                    nl[numsl.length - 1 + i - j + 1] = n;
                    break;
                }

                if (j == numsl.length - 1) {
                    nl[numsl.length - 1 + i - j] = n;
                }
            }
        }

        if (nl.length == 1) {
            return nl[0];
        }
        if (nl.length == 2) {
            return (1.0 * (nl[0] + nl[1]) / 2);
        }

        if (nl.length % 2 == 0) {
            int m = (nl.length / 2) - 1;
            return (1.0 * (nl[m] + nl[m + 1])) / 2;
        }

        return nl[(nl.length - 1) / 2];
    }
}
