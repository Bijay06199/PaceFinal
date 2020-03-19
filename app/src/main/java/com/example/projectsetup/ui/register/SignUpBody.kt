package com.example.projectsetup.ui.register


data class SignUpBody(
    val email: String,
    val password: String,
    val full_name: String,
    val is_agree_terms: Boolean,
    val gender: String
)
