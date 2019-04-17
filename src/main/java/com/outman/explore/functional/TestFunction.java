package com.outman.explore.functional;

import java.util.function.Function;

public class TestFunction<String, R> {

    public void testFunctional(String name, Function<String, R> f) {
        System.out.println(f.apply(name));
    }

    public void testSupplier() {

    }
}
