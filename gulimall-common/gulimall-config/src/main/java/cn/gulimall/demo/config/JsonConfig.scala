package cn.gulimall.demo.config

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

/**
 *
 * @author Z
 * @since 2024/8/1 上午12:24
 */
@Configuration
class JsonConfig {

  @Bean
  def jacksonBuilder(): Jackson2ObjectMapperBuilder = {
    val builder = new Jackson2ObjectMapperBuilder()
    builder.modules(new DefaultScalaModule())
    builder
  }

}
