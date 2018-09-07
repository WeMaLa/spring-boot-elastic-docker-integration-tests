package io.iconect.testing

import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
import org.springframework.stereotype.Service

/**
 * This repository shows using elasticsearchTemplate to communicate with elasticsearch.
 */
@Service
class UserRepository(private val elasticsearchTemplate: ElasticsearchTemplate) {

    fun store(user: User): String {
        val userIndex = IndexQueryBuilder()
                .withId(user.id)
                .withObject(user)
                .build()

        val index = elasticsearchTemplate.index(userIndex)

        elasticsearchTemplate.refresh(User::class.java)

        return index
    }

    fun findById(id: String) : User? {
        val searchQuery = NativeSearchQueryBuilder()
                .withIds(listOf(id))
                .withIndices("user")
                .withTypes("user")
                .build()

        return elasticsearchTemplate.queryForList(searchQuery, User::class.java).firstOrNull()
    }

    fun findAll(): List<User> {
        val searchQuery = NativeSearchQueryBuilder()
                .withIndices("user")
                .withTypes("user")
                .build()

        return elasticsearchTemplate.queryForList(searchQuery, User::class.java)
    }

    fun deleteAll() {
        elasticsearchTemplate.deleteIndex(User::class.java)
    }

}