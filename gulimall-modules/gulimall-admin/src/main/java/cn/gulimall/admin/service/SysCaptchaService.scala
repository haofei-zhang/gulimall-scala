package cn.gulimall.admin.service

import java.awt.image.BufferedImage

/**
 *
 * @author Z
 * @since 2024/5/19 下午3:34
 */
trait SysCaptchaService {

  def getCaptcha(uuid: String): BufferedImage

}
