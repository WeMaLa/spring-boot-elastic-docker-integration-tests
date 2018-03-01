# Introduction 

This example shows how integration testing with SpringBoot 2, Kotlin and Elasticsearch can be accomplished using Docker.

## Requirements

* Java 1.8
* Maven >= 3.2.1

## Executions

#### Unit testing

Maven test phase will apply all unit tests - in this demo ```UserTest.kt```

```ssh
mvn clean test
```

#### Integrations testing

Maven verify phase will apply all unit tests and all integration tests - in this demo ```UserTest.kt``` and ```UserRepositoryIT.kt```

```ssh
mvn clean verify
```

#### Build artifact

Maven package phase will build a local artifact and applies only unit tests

```ssh
mvn clean package
```

#### Install artifact

Maven install phase will build an artifact, install it to local repository and applies unit and integration tests. 
Skipping tests will not skip starting an elasticsearch docker container.

```ssh
mvn clean install
```

## Local integration test debugging

Debugging by an IDE will not start an elasticsearch container. The test container must be installed and started by yourself.


#### First install and run

To reduce resources, it is suggested that the container be launched in Developing mode

```ssh
docker pull docker.elastic.co/elasticsearch/elasticsearch:5.6.8
docker run -p 9200:9200 -p 9300:9300 --name it-elasticsearch -e "discovery.type=single-node" -e "xpack.security.enabled=false"  docker.elastic.co/elasticsearch/elasticsearch:5.6.8
```

#### Start and stop an installed image

```ssh
docker start it-elasticsearch
docker stop it-elasticsearch
```