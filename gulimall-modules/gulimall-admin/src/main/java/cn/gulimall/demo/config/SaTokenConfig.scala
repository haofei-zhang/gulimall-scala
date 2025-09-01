package cn.gulimall.demo.config

import cn.dev33.satoken.context.SaHolder
import cn.dev33.satoken.interceptor.SaInterceptor
import cn.dev33.satoken.stp.StpUtil
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.{CorsRegistry, InterceptorRegistry, WebMvcConfigurer}

/**
 *
 * @author Z
 * @since 2024/5/15 下午11:39
 */
@Configuration
class SaTokenConfig extends WebMvcConfigurer{

  override def addInterceptors(registry: InterceptorRegistry): Unit = {
    registry.addInterceptor(new SaInterceptor(_ =>{
        val req = SaHolder.getRequest
        req.getMethod match {
          case "OPTIONS" =>
          case _ => StpUtil.checkLogin()
        }
      }))
      .addPathPatterns("/**")
      .excludePathPatterns("/login","/captcha.jpg")
  }

}
