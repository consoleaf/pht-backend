package com.example.demo.util;


import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Util {
    public static <T> void assignIfNotNull(Supplier<T> get, Consumer<T> set) {
        T val = get.get();
        if (val != null)
            set.accept(val);
    }
}
