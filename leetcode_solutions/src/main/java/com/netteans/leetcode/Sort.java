package com.netteans.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {

    public enum ORDER {
        /**
         * 小到大顺序
         */
        ASC,
        /**
         * 小到大逆序
         */
        DESC
    }

    public static ORDER order = ORDER.ASC;
    private static final Logger log = LoggerFactory.getLogger(Sort.class);

    private static boolean trace = false;

    public static void setTrace(boolean trace) {
        Sort.trace = trace;
    }

    public static <T> void qsort(T[] arr, Comparator<T> comparator, ORDER order) {
        qsort(arr, 0, arr.length - 1, comparator, order, 0);
    }

    private static <T> void qsort(T[] arr, int low, int high, Comparator<T> comparator, ORDER order, int depth) {
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = Sort.getIndex(arr, low, high, comparator, order, depth);
            qsort(arr, 0, index - 1, comparator, order, depth + 1);
            qsort(arr, index + 1, high, comparator, order, depth + 1);
        }
    }

    private static <T> int getIndex(T[] arr, int low, int high, Comparator<T> comparator, ORDER order, int depth) {
        T tmp = arr[low];
        if (trace) {
            log.debug("BeforeLp[{}]:{}:{}", depth, Arrays.toString(arr), tmp);
        }
        while (low < high) {
            while (low < high && (order == ORDER.ASC ? comparator.compare(arr[high], tmp) >= 0 : comparator.compare(arr[high], tmp) <= 0)) {
                high--;
            }
            if (trace) {
                log.debug("In depth[{}]:{}:{}", depth, Arrays.toString(arr), tmp);
            }
            arr[low] = arr[high];
            if (trace) {
                log.debug("Swapped [{}]:{}:{}", depth, Arrays.toString(arr), tmp);
            }
            while (low < high && (order == ORDER.ASC ? comparator.compare(arr[low], tmp) <= 0 : comparator.compare(arr[high], tmp) >= 0)) {
                low++;
            }
            if (trace) {
                log.debug("In depth[{}]:{}:{}", depth, Arrays.toString(arr), tmp);
            }
            arr[high] = arr[low];
            if (trace) {
                log.debug("Swapped [{}]:{}:{}", depth, Arrays.toString(arr), tmp);
            }
        }
        arr[low] = tmp;
        if (trace) {
            log.debug("Overloop[{}]:{}:{}", depth, Arrays.toString(arr), tmp);
        }
        return low;
    }
}
