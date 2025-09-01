package cn.gulimall.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 *
 * @author Z
 * @since 2024/7/2 下午11:19
 */
@SpringBootApplication
@EnableDiscoveryClient
class ProductApplication

object ProductApplication extends App {
  SpringApplication.run(classOf[ProductApplication], args: _*)
}
