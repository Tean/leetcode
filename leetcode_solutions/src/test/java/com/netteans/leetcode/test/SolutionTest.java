package com.netteans.leetcode.test;


import com.netteans.leetcode.lengthOfLongestSubstring.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SolutionTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SolutionTest.class);

    @Autowired
    @Qualifier("com.netteans.leetcode.lengthOfLongestSubstring.Solution")
    private Solution no3solution;

    @Test
    public void lengthOfLongestSubstring() {
        String s = "asdk";
        no3solution.lengthOfLongestSubstring(s);
        int left = 0;
        int right = 0;

        StringBuilder sub = new StringBuilder();

        List<char[]> chars = Collections.singletonList(s.toCharArray());
        chars.stream().forEach(cs -> {
            LOGGER.info("{}", cs);
        });
    }
}
