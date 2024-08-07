package cn.gulimall.demo.config

import com.mybatisflex.core.FlexGlobalConfig
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.{Bean, Configuration}

/**
 * 2024/5/12 下午2:06
 *
 * @author 44483
 */
@Configuration
@MapperScan(Array("cn.gulimall.demo.mapper"))
class MybatisFlexConfig {

  FlexGlobalConfig.getDefaultConfig.setLogicDeleteColumn("del")


}
