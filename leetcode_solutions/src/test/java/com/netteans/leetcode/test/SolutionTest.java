package com.netteans.leetcode.test;

import com.netteans.leetcode.Solution;
import com.netteans.leetcode.SolutionFactory;
import com.netteans.leetcode.Sort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SolutionTest {
    private static final Logger log = LoggerFactory.getLogger(SolutionTest.class);

    @Autowired
    private Solution solution;

    @Autowired
    private SolutionFactory solutionFactory;

    @Test
    public void testSort() {
        log.info("Sort info");
        log.debug("Sort debug");
        Integer[] arr = new Integer[]{1, 8, 7, 2, 3, 4, 5, 6};
        Sort.setTrace(true);
        Sort.qsort(arr, Integer::compareTo, Sort.ORDER.DESC);
    }

    @Test
    public void no1TestTwoSum() {
        solutionFactory.getSoulution(com.netteans.leetcode.no1.twosum.Solution.class).twoSum(new int[]{3, 3}, 6);
    }

    @Test
    public void no2TestAddTwoNumbers() {
        solutionFactory.getSoulution(com.netteans.leetcode.no2.addtwonumbers.Solution.class).addTwoNumbers(null, null);
    }

    @Test
    public void no3TestLengthOfLongestSubstring() {
        int l = solutionFactory.getSoulution(com.netteans.leetcode.no3.lengthoflongestsubstring.Solution.class).lengthOfLongestSubstring("abcbad");
        log.info("{}", l);
    }

    @Test
    public void no4TestFindMedianSortedArrays() {
        int[] n1 = new int[]{};
        int[] n2 = new int[]{1, 2, 3, 4, 5};
        double medianSortedArrays = solutionFactory.getSoulution(com.netteans.leetcode.no4.findmediansortedarrays.Solution.class).findMedianSortedArrays(n1, n2);
        log.info("{}", medianSortedArrays);
    }

    @Test
    public void no5LongestPalindrome() {
        solutionFactory.getSoulution(com.netteans.leetcode.no5.longestpalindrome.Solution.class).longestPalindrome("babad");
    }

    @Test
    public void no6convert() {
        solutionFactory.getSoulution(com.netteans.leetcode.no6.convert.Solution.class).convert("PAYPALISHIRING", 3);
    }

    @Test
    public void no7reverse() {
        solutionFactory.getSoulution(com.netteans.leetcode.no7.reverse.Solution.class).reverse(321);
    }
}
