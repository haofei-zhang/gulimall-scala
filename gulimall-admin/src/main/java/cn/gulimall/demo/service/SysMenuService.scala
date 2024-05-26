package cn.gulimall.demo.service

import cn.gulimall.demo.model.vo.SysMenuVo
import java.util
/**
 *
 * @author Z
 * @since 2024/5/21 下午11:09
 */
trait SysMenuService {

  def getUserMenuList(userId: Long): util.List[SysMenuVo]

}
