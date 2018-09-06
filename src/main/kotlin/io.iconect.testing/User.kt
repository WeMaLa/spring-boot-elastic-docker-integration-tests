package io.iconect.testing

import org.elasticsearch.common.UUIDs
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "user", type = "user")
class User constructor(@Id val id: String = UUIDs.base64UUID(),
                       @Field(type = FieldType.Keyword) val name: String? = null)