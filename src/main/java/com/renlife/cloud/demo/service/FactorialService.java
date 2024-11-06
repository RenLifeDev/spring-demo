package com.renlife.cloud.demo.service;

public class FactorialService {

    /**
     * Recursive algorithm for calculating factorial.
     */
    public Long calculate(int i) {
        return i * calculate(--i);
    }
}
