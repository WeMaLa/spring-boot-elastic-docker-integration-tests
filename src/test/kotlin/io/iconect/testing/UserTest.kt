package io.iconect.testing

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Simple unit test with no spring integration
 */
class UserTest {

    @Test
    fun `create user document`() {
        val user = User(name = "unit-test-user-name")

        assertThat(user.id).isNotBlank()
        assertThat(user.name).isEqualTo("unit-test-user-name")
    }
}