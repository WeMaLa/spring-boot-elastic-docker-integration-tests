package io.iconect.testing

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

/**
 * Demonstrates an spring boot test with a mocked repository (and no docker is running).
 */
@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles("unittest")
class UserRepositoryMockTest {

    @MockBean
    private lateinit var userRepository: UserRepository

    @Test
    fun `run with mocked repository`() {
        val user = User("unit-test-user-id", "unit-test-user-name-1")

        `when`(userRepository.store(user)).thenReturn("unit-test-user-id")

        assertThat(userRepository.store(user)).isEqualTo("unit-test-user-id")
    }

}