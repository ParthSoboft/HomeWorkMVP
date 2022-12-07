package com.imaginato.homeworkmvp.mvvm

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFieldValidationsUnitTest {

    @Test
    fun emptyUserNameFalse() {
        val result = LoginValidateValues.validateLoginInput(
            "",
            "1111111",
        )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyPasswordFalse() {
        val result = LoginValidateValues.validateLoginInput(
            "username",
            "",
        )
        assertThat(result).isFalse()
    }

    @Test
    fun filledUserNamePasswordTrue() {
        val result = LoginValidateValues.validateLoginInput(
            "username",
            "1111111",
        )
        assertThat(result).isTrue()
    }

}