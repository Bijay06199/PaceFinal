package com.example.projectsetup.ui.login

data class User(
    val id: Int,
    val full_name: String,
    val location: String?,
    val address: String?,
    val country: String?,
    val country_code: String?,
    val phone: String?,
    val language: String?,
    val government_id: String?,
    val is_superuser: Boolean,
    val is_government_id_verified: Boolean,
    val is_phone_verified: Boolean,
    val gender: String?,
    val agent_id: String?,
    val company_name: String?,
    val is_agree_terms: Boolean,
    val user_type: String?,
    val createdAt: String,
    val updatedAt: String
)

data class Data(
    val id: Int,
    val email: String,
    val createdAt: String,
    val updatedAt: String,
    val user_id: Int,
    val user: User
)

data class UserBody(
    val message: String,
    val token: String,
    val data: Data
)
