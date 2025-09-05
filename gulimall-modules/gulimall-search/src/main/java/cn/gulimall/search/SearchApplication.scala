package cn.gulimall.search

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 *
 * @author zhanghaofei
 *         Create at 2025/9/2
 */
@SpringBootApplication
@EnableDiscoveryClient
class SearchApplication

object SearchApplication extends App {
  SpringApplication.run(classOf[SearchApplication], args: _*)
}
