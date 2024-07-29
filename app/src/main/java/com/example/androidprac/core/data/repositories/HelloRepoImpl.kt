package com.example.androidprac.core.data.repositories

class HelloRepoImpl : HelloRepo {
    override fun sayHello(): String {
        return "Hello, World! From Repo"
    }
}