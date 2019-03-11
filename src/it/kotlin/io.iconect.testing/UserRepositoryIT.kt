package io.iconect.testing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * Demonstrates an integration spring boot test starting an elasticsearch as a docker container.
 */
@ExtendWith(SpringExtension::class)
@SpringBootTest
@ActiveProfiles("it")
class UserRepositoryIT {

    @Autowired
    private lateinit var userRepository: UserRepository

    @BeforeEach
    fun setUp() {
        userRepository.deleteAll()
    }

    @Test
    fun `save user document with defined id`() {
        val user = User("unit-test-user-id", "unit-test-user-name-1")

        val storedId = userRepository.store(user)

        assertThat(storedId).isEqualTo("unit-test-user-id")
        assertThat(userRepository.findById("unit-test-user-id")!!.id).isEqualTo("unit-test-user-id")
        assertThat(userRepository.findById("unit-test-user-id")!!.name).isEqualTo("unit-test-user-name-1")
    }

    @Test
    fun `save user document with generated id`() {
        val user = User(name = "unit-test-user-name-2")
        userRepository.store(user)

        val loadedUser = userRepository.findAll().find { "unit-test-user-name-2" == it.name }!!
        assertThat(loadedUser.id).isNotBlank()
        assertThat(loadedUser.name).isEqualTo("unit-test-user-name-2")
    }
}