package org.examples;

import org.apache.pulsar.common.util.Reflections;

public class VerifyReflection {

    public static void main(String[] args) {
        ClassLoader loader = VerifyReflection.class.getClassLoader();
        TestConsClass v = new TestConsClass();
        TestConsClass vv = (TestConsClass) Reflections.createInstance(TestConsClass.class.getName(), loader);
    }
}
