package com.netteans.leetcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SolutionFactory {

    @Autowired
    private Solution solution;

    @Autowired
    private ApplicationContext applicationContext;

    public <T> T getSoulution(Class<T> type) {
        return applicationContext.getBean(type);
    }
}
