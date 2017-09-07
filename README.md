# CNUTCon-2017-Demo
Demonstration application for CNUTCon 2017 live show.

This demo is a simple distributed system. `project-A` is a front-end server, and `project-B` is a back-end. `project-A` use Spring RestTemplete to access the `project-B`'s RESTFul service. And both of them have their own db.

`project-A` use OpenTracing Java API to do manual instrumentation, and `project-B` use **@Trace** annotation to do so.

Please don't care much about the coding style, the tech stack we used, concentrate on auto/manual instrumentations, which is matter.

# Quick Start

1. Deploy skywalking agent for `project-A` and `project-B`
1. Start `project-A` and `project-B`
1. Open browser and visit `localhost:8081/hello?name=test`
