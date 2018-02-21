package io.iconect.testing

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "user", type = "user")
class User {
    @Id lateinit var  id: String
    @Field(type = FieldType.text) lateinit var name: String
}