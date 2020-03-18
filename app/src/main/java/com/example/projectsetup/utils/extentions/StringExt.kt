package com.example.projectsetup.utils.extentions

import com.example.projectsetup.utils.contracts.AppContracts
import java.util.regex.Pattern


    /**
     * Email validation .
     */
    fun String.isValidEmail(): Boolean {

        val pattern = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                        ")+")
        return  pattern.matcher(this).matches()
    }

    /**
     * validate password with at least 8 character, One upper case , one lower case and digit regex
     *
     * @param passwordTxt => user password text
     */
    fun String.isValidPassword(): Boolean {
        this?.let {
            return it.matches(AppContracts.PasswordRegex.PASSWORD_VALIDATION.toRegex())
        }
        return false
    }

    /**
     * validate empty field
     *
     * @param value => value from edittext
     */
    fun String.isEmpty(): Boolean {
        return this.isNullOrEmpty()
    }

    /**
     * check email is already used or not
     ** */
    fun String.isEmailAlreadyUsed(): Boolean {
        return this == "tr1@getnada.com"
    }

    fun String.isFirstNameValid(): Boolean {
        return this!!.length > 2



}

