package org.examples;

import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.impl.schema.JSONSchema;
import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;
import org.slf4j.Logger;

public class PojoParserFunction implements Function<StatementBean, Void> {
    @Override
    public Void process(StatementBean input, Context context) {
        Logger LOG = context.getLogger();
        String city = input.getCity();
        String toTopic = "persistent://public/default/default_topic";
        toTopic = (String) context.getUserConfigValueOrDefault(city, toTopic);
        LOG.debug("routing message with key {} to {}", city, toTopic);
        try {
            context.newOutputMessage(toTopic, JSONSchema.of(StatementBean.class)).value(input).sendAsync();
        } catch (PulsarClientException e) {
            LOG.error("Failed to send message to topic: {}, exception: ", toTopic, e);
        }
        return null;
    }
}
