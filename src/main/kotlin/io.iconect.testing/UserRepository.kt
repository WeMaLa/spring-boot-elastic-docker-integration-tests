package io.iconect.testing

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface UserRepository : ElasticsearchRepository<User, String>