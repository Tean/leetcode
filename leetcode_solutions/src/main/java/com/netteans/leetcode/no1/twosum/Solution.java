package com.netteans.leetcode.no1.twosum;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("no1solution")
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left)) {
                return new int[]{map.get(left), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] v = map.get(nums[i]);
                int[] vp = new int[v.length + 1];
                System.arraycopy(v, 0, vp, 0, v.length);
                vp[v.length] = i;
                map.put(nums[i], vp);
            } else {
                map.put(nums[i], new int[]{i});
            }
        }

        final int[] rv = new int[2];
        final boolean[] found = {false};
        map.forEach((k, v) -> {
            int firstindex = v[0];
            int othervalue = target - k;
            if (map.containsKey(othervalue)) {
                rv[0] = firstindex;
                if (othervalue == k) {
                    int[] doubleV = map.get(othervalue);
                    if (doubleV.length > 1) {
                        rv[1] = doubleV[1];
                        found[0] = true;
                    }
                } else {
                    rv[1] = map.get(othervalue)[0];
                    found[0] = true;
                }
            }
        });
        return found[0] ? rv : null;
    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
