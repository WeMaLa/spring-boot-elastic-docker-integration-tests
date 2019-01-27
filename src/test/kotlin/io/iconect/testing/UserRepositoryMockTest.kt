package io.iconect.testing

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * Demonstrates an spring boot test with a mocked repository (and no docker is running).
 */
@ExtendWith(SpringExtension::class)
@SpringBootTest
@ActiveProfiles("unittest")
class UserRepositoryMockTest {

    @MockBean
    private lateinit var elasticSearchTemplateMock: ElasticsearchTemplate

    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun `run with mocked repository`() {
        val user = User("unit-test-user-id", "unit-test-user-name-1")

        whenever(elasticSearchTemplateMock.index(any())).thenReturn("unit-test-user-id")

        assertThat(userRepository.store(user)).isEqualTo("unit-test-user-id")
    }

}