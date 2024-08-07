package cn.gulimall.demo.config

import com.mybatisflex.core.FlexGlobalConfig
import org.springframework.context.annotation.Configuration

/**
 * 2024/5/12 下午2:06
 *
 * @author 44483
 */
@Configuration
class MybatisFlexConfig {

  FlexGlobalConfig.getDefaultConfig.setLogicDeleteColumn("del")


}
