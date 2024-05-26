package cn.gulimall.demo.config

import cn.dev33.satoken.interceptor.SaInterceptor
import cn.dev33.satoken.router.SaRouter
import cn.dev33.satoken.stp.StpUtil
import cn.gulimall.demo.model.vo.ResultVo
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
    registry.addInterceptor(new SaInterceptor(_ =>
        SaRouter
          .`match`("/**")
          .notMatch("/login","/captcha.jpg")
          .check(_ => StpUtil.checkLogin())
//          .back(ResultVo.error().toJSONString())
      ))
      .addPathPatterns("/**")
  }

  override def addCorsMappings(registry: CorsRegistry): Unit = {
    registry.addMapping("/**")
      .allowedOriginPatterns("http://*")
      .allowedMethods("*")
      .allowedHeaders("*")
      .allowCredentials(true)
//      .maxAge(3600)
  }

}
