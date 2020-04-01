package com.example.projectsetup.utils.contracts

class AppContracts {
    object Strings {
        const val CURRENCY = "$"
        const val ok = "Ok"
        const val cancel = "Cancel"
        const val re_send = "Resend"
        const val TERMS_AND_CONDITIONS = "termsCondition"
        const val PRIVACY_POLICY = "privacyPolicy"
        const val TERMS_AND_CONDITIONS_TITLE = "Terms and\nConditions"
        const val PRIVACY_POLICY_TITLE = "Privacy Policy"
        const val START_A_PROJECT = "Start A Project"
    }

    object Args {
        const val PAGE = "page"
        const val REGRISTRATION_TYPE = "registration_type"

    }

    object RegistrationType{
        const val SALE=1
        const val RENT=2
    }


    object RequestCodes {
        const val REFRESH_FAILED = "refresh_failed"
    }


    object EXTRAS {
        const val DASHBOARD_TYPE = "dashboard_type"
    }

    object ErrorMessages {
        val SUCCESS_RESPONSE: String = "Success response"
        const val ERR_PROJECT_NAME: String = "Please provide name for your project."
        const val ERR_INVALID_CREDENTIAL = "Invalid email/password"
        const val ERR_FIRST_NAME = "Please provide first name."
        const val ERR_EMPTY_OLD_PASSWORD = "Please provide old password."
        const val ERR_EMPTY_NEW_PASSWORD = "Please provide new password."
        const val ERR_VAlID_FIRST_NAME = "firstName length must be at least 3 characters long."
        const val ERR_LAST_NAME = "Please provide last name."
        const val ERR_EMPTY_EMAIL = "Please provide email address."
        const val ERR_EMPTY_PASSWORD = "Please provide password."
        const val ERR_EMAIL_ADDRESS = "Please provide valid email address."
        const val ERR_EMAIL_USED = "Email is already in use."
        const val ERR_PASSWORD = "Password should include atleast one digit, one uppercase, one lowercase and minimum 8 characters"
    }

    object SuccessMessages {
        const val SUCCESSFUL = "Successful"
    }

    object PasswordRegex {
        const val PASSWORD_VALIDATION = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[A-Za-z\\d\$@\$!%*?&.]{8,}\$"
    }

    object NetworkCodes {
        const val NO_INTERNET_CONNECTION = 600
        const val NO_CONTENT_FOUND = 601
        const val SUCCESS = 200
    }

    object FROM {
        enum class DASHBOARD { LOGGED_IN, BROWSE_VENDORS, BEGIN_FINANCE }

    }

}