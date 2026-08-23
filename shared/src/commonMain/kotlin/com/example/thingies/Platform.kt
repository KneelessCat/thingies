package com.example.thingies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform