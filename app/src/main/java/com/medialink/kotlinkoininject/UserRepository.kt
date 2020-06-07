package com.medialink.kotlinkoininject

class UserRepository(private val api: GithubApi) {
    fun getAllUser()  = api.getUsers()
}