package com.sssr.others.cas;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class T {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        ai.compareAndSet(1, 3);

        ConcurrentHashMap<String, String> cmp = new ConcurrentHashMap<String, String>(16);
        cmp.put("A", "B");

        Collections.synchronizedMap(new HashMap<>(16));
    }
}
