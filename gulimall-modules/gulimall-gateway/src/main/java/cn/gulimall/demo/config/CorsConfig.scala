package cn.gulimall.demo.config

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.{CorsWebFilter, UrlBasedCorsConfigurationSource}

/**
 *
 * @author Z
 * @since 2024/7/7 下午9:01
 */
@Configuration
class CorsConfig {

  @Bean
  def corsWebFilter(): CorsWebFilter = {
    val source = new UrlBasedCorsConfigurationSource()
    val config = new CorsConfiguration()
    config.addAllowedHeader("*")
    config.addAllowedMethod("*")
    config.addAllowedOriginPattern("http://*")
    config.setAllowCredentials(true)

    source.registerCorsConfiguration("/**", config)
    new CorsWebFilter(source)
  }

}
