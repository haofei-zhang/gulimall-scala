package cn.gulimall.admin.config

import com.google.code.kaptcha.impl.DefaultKaptcha
import com.google.code.kaptcha.util.Config
import org.springframework.context.annotation.{Bean, Configuration}

import java.util.Properties

/**
 *
 * @author Z
 * @since 2024/5/18 下午10:59
 */
@Configuration
class KaptchaConfig {

  @Bean
  def kaptchaProducer(): DefaultKaptcha = {
    val properties = new Properties(){
      put("kaptcha.border", "no")
      put("kaptcha.textproducer.font.color", "black")
      put("kaptcha.textproducer.char.space", "5")
      put("kaptcha.textproducer.font.names", "Arial,Courier,cmr10,宋体,楷体,微软雅黑")
    }
    val config = new Config(properties)
    val defaultKaptcha = new DefaultKaptcha()
    defaultKaptcha.setConfig(config)
    defaultKaptcha
  }

}
