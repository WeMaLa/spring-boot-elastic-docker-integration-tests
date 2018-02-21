package io.iconect.testing

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import java.net.InetAddress

@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles("it")
class UserRepositoryIT {

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun callElasticSearch() {
        System.out.println("Reachable " + InetAddress.getByName("localhost").isReachable(10000))

        val user = User()
        user.id = "unit-test-user-id"
        user.name = "unit-test-user-name"
        userRepository.save(user)

        assertThat(userRepository.findById("unit-test-user-id")).isPresent
    }
}