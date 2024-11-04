package com.renlife.cloud.demo.service;

public class FactorialService {

    public Long calculate(int i) {
        return i * calculate(--i);
    }
}
