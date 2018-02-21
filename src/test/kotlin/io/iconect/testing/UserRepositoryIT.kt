package io.iconect.testing

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class UserRepositoryIT {

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun callElasticSearch() {
        val user = User()
        user.id = "unit-test-user-id"
        user.name = "unit-test-user-name"
        userRepository.save(user)

        assertThat(userRepository.findById("unit-test-user-id")).isPresent
    }
}