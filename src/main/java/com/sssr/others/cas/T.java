package com.sssr.others.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class T {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        ai.compareAndSet(1, 3);
    }
}
