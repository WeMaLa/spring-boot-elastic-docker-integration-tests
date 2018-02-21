package io.iconect.testing

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class UserTest {

    @Test
    fun build() {
        //val user = User("unit-test-user-id", "unit-test-user-name")
        val user = User()
        user.id = "unit-test-user-id"
        user.name = "unit-test-user-name"

        assertThat(user.id).isEqualTo("unit-test-user-id")
        assertThat(user.name).isEqualTo("unit-test-user-name")
    }
}