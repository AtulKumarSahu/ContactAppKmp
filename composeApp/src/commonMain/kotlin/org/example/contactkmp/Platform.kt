package org.example.contactkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform