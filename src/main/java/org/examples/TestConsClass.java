package org.examples;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

public class TestConsClass implements Function<String, String> {
    public TestConsClass() {
        System.out.println("TestConsClass constructor");
    }

    @Override
    public String process(String input, Context context) throws Exception {
        return null;
    }
}
