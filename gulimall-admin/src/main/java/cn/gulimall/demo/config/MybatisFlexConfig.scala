package cn.gulimall.demo.config

import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Configuration

/**
 * 2024/5/12 下午2:06
 *
 * @author 44483
 */
@Configuration
@MapperScan(Array("cn.gulimall.demo.mapper"))
class MybatisFlexConfig {

}
