package org.examples;

import lombok.Data;

@Data
public class AerospikePlayer {
    private int id;
    private String name;
    private String namespace;
    private int ttl;
}
