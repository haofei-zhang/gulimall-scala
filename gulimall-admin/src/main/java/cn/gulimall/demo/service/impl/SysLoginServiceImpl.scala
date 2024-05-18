package cn.gulimall.demo.service.impl

import cn.dev33.satoken.stp.{SaTokenInfo, StpUtil}
import cn.gulimall.demo.mapper.SysUserMapper
import cn.gulimall.demo.model.dto.LoginDto
import cn.gulimall.demo.service.SysLoginService
import org.apache.commons.codec.digest.DigestUtils
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Service

import java.util.Objects

/**
 * 2024/5/10 下午11:32
 * @author Z
 *
 */
@Service
class SysLoginServiceImpl(sysUserMapper: SysUserMapper) extends SysLoginService {

  private def log: Logger = LoggerFactory.getLogger(classOf[SysLoginServiceImpl])

  override def login(loginDto: LoginDto): SaTokenInfo = {
    val user = sysUserMapper.selectByMobile(loginDto.getMobile)
    if (Objects.isNull(user)){
      throw new RuntimeException("用户不存在")
    }
    if (!Objects.equals(user.getPassword, DigestUtils.sha256Hex(loginDto.getPassword))){
      throw new RuntimeException("密码错误")
    }
    StpUtil.login(user.getId)

    StpUtil.getTokenInfo
  }

  override def logout(): Unit = {
    StpUtil.logout()
  }
}
