package cn.gulimall.demo.service.impl

import cn.gulimall.demo.mapper.SysCaptchaMapper
import cn.gulimall.demo.model.po.SysCaptcha
import cn.gulimall.demo.service.SysCaptchaService
import com.google.code.kaptcha.impl.DefaultKaptcha
import org.springframework.stereotype.Service

import java.awt.image.BufferedImage

/**
 *
 * @author Z
 * @since 2024/5/19 下午3:35
 */
@Service
class SysCaptchaServiceImpl(sysCaptchaMapper: SysCaptchaMapper,
                            defaultKaptcha: DefaultKaptcha) extends SysCaptchaService{

  override def getCaptcha(uuid: String): BufferedImage = {
    val code = defaultKaptcha.createText()
    val captcha = new SysCaptcha()
    captcha.setUuid(uuid)
    captcha.setCode(code)
    sysCaptchaMapper.insert(captcha)
    defaultKaptcha.createImage(code)
  }
}
