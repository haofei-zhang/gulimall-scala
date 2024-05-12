package cn.gulimall.demo.service.impl

import cn.dev33.satoken.stp.StpUtil
import cn.gulimall.demo.mapper.SysUserMapper
import cn.gulimall.demo.service.SysLoginService
import com.mybatisflex.core.query.QueryWrapper
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Service

/**
 * 2024/5/10 下午11:32
 * @author Z
 *
 */
@Service
class SysLoginServiceImpl(sysUserMapper: SysUserMapper) extends SysLoginService {

  private def log: Logger = LoggerFactory.getLogger(classOf[SysLoginServiceImpl])

  override def login(): Unit = {
    val queryWrapper = QueryWrapper.create().select()
    val list = sysUserMapper.selectListByQuery(queryWrapper)
    log.info(list.toString)
    StpUtil.login(1)
  }

  override def logout(): Unit = {
    StpUtil.logout()
  }
}
