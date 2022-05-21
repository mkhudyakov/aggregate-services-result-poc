aggregate-services-result-poc
=============================

Example of the service, that communicates with another one using HTTP to enrich its content.
This one example requires to switch to Jersey 2.13 to use its [Asynchronous Server Api]

At the moment performance seems degrade based on the Apache Benchmark result - there is an overhead of communicating with another one service (probably, keep alive is not enabled by default in jersey)
