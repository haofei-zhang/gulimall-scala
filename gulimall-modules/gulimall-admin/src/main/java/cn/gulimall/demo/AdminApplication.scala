package cn.gulimall.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 *
 * @author Z
 * @since 2024/5/14 下午10:37
 */
@SpringBootApplication
@EnableDiscoveryClient
class AdminApplication

object AdminApplication extends App {
  SpringApplication.run(classOf[AdminApplication], args: _*)
}
