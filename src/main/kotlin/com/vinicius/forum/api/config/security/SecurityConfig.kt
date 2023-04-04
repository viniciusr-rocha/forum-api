package com.vinicius.forum.api.config.security

import com.vinicius.forum.api.config.security.jwt.JWTUtil
import com.vinicius.forum.api.config.security.jwt.JWTAuthenticationFilter
import com.vinicius.forum.api.config.security.jwt.JWTLoginFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtUtil: JWTUtil,
    private val authenticationConfiguration: AuthenticationConfiguration,
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf()?.disable()
            ?.authorizeHttpRequests()
            ?.requestMatchers("/topics")?.hasAuthority("READ_WRITE")
            ?.requestMatchers(HttpMethod.POST, "/login")?.permitAll()

        http.addFilterBefore(
            JWTLoginFilter(authenticationManager = authenticationConfiguration.authenticationManager, jwtUtil = jwtUtil),
            UsernamePasswordAuthenticationFilter::class.java
        )
        http.addFilterBefore(JWTAuthenticationFilter(jwtUtil = jwtUtil), UsernamePasswordAuthenticationFilter()::class.java)

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        return http.build()
    }

    @Bean
    fun bCryptPasswordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}