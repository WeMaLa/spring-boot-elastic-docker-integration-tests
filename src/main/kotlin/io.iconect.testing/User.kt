package io.iconect.testing

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "user", type = "user")
class User {
    @Id
    var id: String? = null

    @Field(type = FieldType.text)
    var name: String? = null
}