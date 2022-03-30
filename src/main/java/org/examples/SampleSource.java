package org.examples;

import java.util.Map;
import org.apache.pulsar.io.debezium.DebeziumSource;

public class SampleSource extends DebeziumSource {
    @Override
    public void setDbConnectorTask(Map<String, Object> config) throws Exception {

    }
}
