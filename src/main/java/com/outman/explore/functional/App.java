package com.outman.explore.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class App {

    public static void main(String[] args) {
        // 函数范式 (x) -> y;
        Function<Integer, Integer> function1 = (x) -> 222;
        Function<Integer, String> function2 = (x) -> {
            return "after function1" + x;
        };
        System.out.println(function1.apply(6));
        // function2的入参 == function1的出参
        System.out.println(function1.andThen(function2).apply(123));

        // () ->y
        Supplier<String> supplierStr = () -> {
            return "hello world";
        };

        // 函数范式 (x) -> void
        Consumer<String> consumer1 = (x) -> System.out.print(x);
        Consumer<String> consumer2 = (x) -> {
            System.out.println(" after consumer 1" + x);
        };
        consumer1.andThen(consumer2).accept("test consumer1");

        TestFunction tf = new TestFunction();
        // 传递lambda函数体,简单的逻辑实现不需要再TestFunction去做，赞
        tf.testFunctional("outman", (x) -> {
            return "i am " + x;
        });

        testJavaScript();
    }

    static void testJavaScript() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine nashorn = manager.getEngineByName("nashorn");
        Integer result;
        try {
            nashorn.eval("print('Hello, Hafiz.Zhang')");
            result = (Integer)nashorn.eval("100 + 88");
            System.out.println("res:" + result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
