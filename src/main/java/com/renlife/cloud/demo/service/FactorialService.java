package com.renlife.cloud.demo.service;

import org.springframework.stereotype.Service;

@Service // TODO убрать аннотацию, чтобы не взлетало
public class FactorialService {

    public Long calculate(int i) {
        if (1 == i) return 1L; // TODO убрать базовый случай, чтобы ушло в stackoverflow

        return i * calculate(--i);
    }
}
