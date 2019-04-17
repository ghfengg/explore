package com.outman.explore.functional;

public interface Defaulable {

    default String notRequired() {
        return "default implementation";
    }

}
