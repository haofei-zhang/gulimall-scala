package cn.gulimall.admin.controller

import cn.gulimall.admin.service.{SysCaptchaService, SysLoginService}
import cn.gulimall.demo.model.dto.LoginDto
import cn.gulimall.web.model.vo.ResultVo
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.{GetMapping, PostMapping, RequestBody, RestController}

import javax.imageio.ImageIO

/**
 * @author Z
 */
@RestController
class SysLoginController(sysLoginService: SysLoginService,
                         sysCaptchaService: SysCaptchaService) {

  @GetMapping(Array("/captcha.jpg"))
  def captcha(response: HttpServletResponse, uuid: String): Unit = {
    val image = sysCaptchaService.getCaptcha(uuid)
    response.setHeader("Cache-Control", "no-store, no-cache")
    response.setContentType("image/jpeg")

    val outputStream = response.getOutputStream
    ImageIO.write(image, "jpg", outputStream)
  }

  @PostMapping(Array("/login"))
  def login(@RequestBody loginDto: LoginDto): ResultVo = {
    ResultVo.ok(sysLoginService.login(loginDto))
  }

  @PostMapping(Array("/logout"))
  def logout(): ResultVo = {
    ResultVo.ok()
  }


}
