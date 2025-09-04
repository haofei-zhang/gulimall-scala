package cn.gulimall.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 *
 * @author Z
 * @since 2024/6/10 下午4:41
 */
@SpringBootApplication
@EnableDiscoveryClient
class GatewayApplication

object GatewayApplication extends App {
  SpringApplication.run(classOf[GatewayApplication], args: _*)
}
