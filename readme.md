# Introduction 
_IN PROGRESS_

This example shows how integration testing with SpringBoot 2 and Elastic can be accomplished using Docker.

## Setup

Install local elasticsearch

```ssh
docker pull docker.elastic.co/elasticsearch/elasticsearch:5.6.6
# run in developer mode (user: elastic, pw: changeme)
docker run -p 9200:9200 -p 9300:9300 --name elasticsearch -e "discovery.type=single-node" -e "xpack.security.enabled=false"  docker.elastic.co/elasticsearch/elasticsearch:5.6.6 
```

After starting elastic start maven

```ssh
mvn clean test # unit tests
mvn clean verify # integration tests
```