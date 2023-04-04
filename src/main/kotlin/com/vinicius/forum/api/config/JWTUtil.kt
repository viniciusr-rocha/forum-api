package com.vinicius.forum.api.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWTUtil {

    private val expirationInMilliseconds: Long = 60000

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    fun generateToken(username: String): String? {
        return Jwts.builder()
            .setSubject(username)
            .setExpiration(Date(System.currentTimeMillis() + expirationInMilliseconds))
            .signWith(SignatureAlgorithm.HS512, secret.toByteArray())
            .compact()
    }
}