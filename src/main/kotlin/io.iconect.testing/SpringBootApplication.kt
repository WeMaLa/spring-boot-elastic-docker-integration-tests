package io.iconect.testing

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import org.springframework.stereotype.Component

@SpringBootApplication
class TestingApplication

fun main(args: Array<String>) {
    runApplication<TestingApplication>(*args)
}

/**
 * When not using an ElasticsearchRepository no index will be created. So this runner creates required index.
 */
@Component
class ElasticsearchInitializer @Autowired constructor(private var elasticsearchTemplate: ElasticsearchTemplate) : CommandLineRunner {

    override fun run(vararg args: String?) {
        elasticsearchTemplate.deleteIndex(User::class.java)
        elasticsearchTemplate.createIndex(User::class.java)
        elasticsearchTemplate.putMapping(User::class.java)
        elasticsearchTemplate.refresh(User::class.java)
    }
}