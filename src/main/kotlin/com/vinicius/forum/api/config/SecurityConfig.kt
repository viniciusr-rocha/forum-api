package com.vinicius.forum.api.config

import com.vinicius.forum.api.config.security.JWTAuthenticationFilter
import com.vinicius.forum.api.config.security.JWTLoginFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.filter.OncePerRequestFilter


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtUtil: JWTUtil,
    private val userDetailService: UserDetailsService,
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf()?.disable()
            ?.authorizeHttpRequests()
//            ?.requestMatchers("/topics")?.hasAuthority("READ_WRITE")
            ?.requestMatchers(HttpMethod.POST, "/login")?.permitAll()
            ?.anyRequest()
            ?.authenticated()
            ?.and()
        http.addFilterBefore(
            JWTLoginFilter(authenticationManager = authenticationManager(http), jwtUtil = jwtUtil),
            UsernamePasswordAuthenticationFilter().javaClass
        )
        http.addFilterBefore(JWTAuthenticationFilter(jwtUtil = jwtUtil), OncePerRequestFilter::class.java)
        http.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        return http.build()
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationManager(
        http: HttpSecurity,
    ): AuthenticationManager {
        return http.getSharedObject(AuthenticationManagerBuilder::class.java)
            .userDetailsService(userDetailService)
            .passwordEncoder(bCryptPasswordEncoder())
            .and()
            .build()
    }
}