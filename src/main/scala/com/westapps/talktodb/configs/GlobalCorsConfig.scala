package com.westapps.talktodb.configs

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource

@Configuration
class GlobalCorsConfig {

  @Bean
  def corsWebFilter(): CorsWebFilter = {
    val config = new CorsConfiguration()
    config.setAllowCredentials(true)
    config.addAllowedOrigin("http://resume.simonxie.net")
    config.addAllowedOrigin("https://resume.simonxie.net")
    config.addAllowedHeader("*")
    config.addAllowedMethod("*")

    val source = new UrlBasedCorsConfigurationSource()
    source.registerCorsConfiguration("/**", config)

    new CorsWebFilter(source)
  }
}