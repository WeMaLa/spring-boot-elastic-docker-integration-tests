package io.iconect.testing

import org.mockito.Mockito.mock
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate

/**
 * ElasticsearchTemplate is used by DatabaseInitializerCommandLineRunner to create indexes.
 */
@Configuration
class ElasticSearchTemplateMock {

    @Bean
    @Profile("unittest")
    fun elasticsearchTemplate(): ElasticsearchTemplate {
        return mock<ElasticsearchTemplate>(ElasticsearchTemplate::class.java)
    }

}