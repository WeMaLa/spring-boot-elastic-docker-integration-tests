package io.iconect.testing

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles("it")
class UserRepositoryIT {

    @Autowired
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        println("SEARCH FOR EXISTING USER")
        userRepository.findAll().forEach { u -> println("FOUND USER ${u.name}") }
        userRepository.deleteAll()
    }

    @Test
    fun saveUserWithDefinedId() {
        val user = User()
        user.id = "unit-test-user-id"
        user.name = "unit-test-user-name-1"
        userRepository.save(user)

        assertThat(userRepository.findById("unit-test-user-id").get().id).isEqualTo("unit-test-user-id")
        assertThat(userRepository.findById("unit-test-user-id").get().name).isEqualTo("unit-test-user-name-1")
    }

    @Test
    fun saveUserWithGeneratedId() {
        val user = User()
        user.name = "unit-test-user-name-2"
        userRepository.save(user)

        val loadedUser = userRepository.findAll().find { u -> "unit-test-user-name-2" == u.name }!!
        assertThat(loadedUser.id).isNotBlank()
        assertThat(loadedUser.id).isNotEqualTo("unit-test-user-id")
        assertThat(loadedUser.name).isEqualTo("unit-test-user-name-2")
    }
}