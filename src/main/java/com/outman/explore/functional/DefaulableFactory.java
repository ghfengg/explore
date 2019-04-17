package com.outman.explore.functional;

import java.util.function.Supplier;

public interface DefaulableFactory {
    // Interfaces now allow static methods
    static Defaulable create(Supplier<Defaulable> supplier) {
        return supplier.get();
    }
}
