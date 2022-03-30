## Pulsar Function Sample with POJO parser

```bash
bin/pulsar-admin functions create --jar /pulsar/pulsar-java-functions-pojo-parse-1.0-SNAPSHOT.jar --classname org.examples.PojoParserFunction --inputs persistent://public/default/input --parallelism 100 --name pojo-parser --user-config '{"beijing":"persistent://public/default/beijing","wuhan":"persistent://public/default/wuhan","guangzhou":"persistent://public/default/guangzhou"}' --log-topic persistent://public/default/log
```

```bash
bin/pulsar-admin functions status --name pojo-parser

bin/pulsar-admin functions delete --name pojo-parser
```

```json
{
  "numInstances" : 3,
  "numRunning" : 3,
  "instances" : [ {
    "instanceId" : 2,
    "status" : {
      "running" : true,
      "error" : "",
      "numRestarts" : 0,
      "numReceived" : 30,
      "numSuccessfullyProcessed" : 30,
      "numUserExceptions" : 0,
      "latestUserExceptions" : [ ],
      "numSystemExceptions" : 0,
      "latestSystemExceptions" : [ ],
      "averageLatency" : 18.543309533333332,
      "lastInvocationTime" : 1626662969317,
      "workerId" : "c-pulsar-fw-pulsar-broker-0.pulsar-broker.default.svc.cluster.local-8080"
    }
  }, {
    "instanceId" : 0,
    "status" : {
      "running" : true,
      "error" : "",
      "numRestarts" : 0,
      "numReceived" : 30,
      "numSuccessfullyProcessed" : 30,
      "numUserExceptions" : 0,
      "latestUserExceptions" : [ ],
      "numSystemExceptions" : 0,
      "latestSystemExceptions" : [ ],
      "averageLatency" : 19.935237466666667,
      "lastInvocationTime" : 1626662969327,
      "workerId" : "c-pulsar-fw-pulsar-broker-0.pulsar-broker.default.svc.cluster.local-8080"
    }
  }, {
    "instanceId" : 1,
    "status" : {
      "running" : true,
      "error" : "",
      "numRestarts" : 0,
      "numReceived" : 30,
      "numSuccessfullyProcessed" : 30,
      "numUserExceptions" : 0,
      "latestUserExceptions" : [ ],
      "numSystemExceptions" : 0,
      "latestSystemExceptions" : [ ],
      "averageLatency" : 21.317499499999997,
      "lastInvocationTime" : 1626662969340,
      "workerId" : "c-pulsar-fw-pulsar-broker-0.pulsar-broker.default.svc.cluster.local-8080"
    }
  } ]
}
```

