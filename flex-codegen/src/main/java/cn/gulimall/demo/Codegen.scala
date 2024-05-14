package cn.gulimall.demo

import com.mybatisflex.codegen.Generator
import com.mybatisflex.codegen.config.GlobalConfig
import com.zaxxer.hikari.HikariDataSource

/**
 * 2024/5/14 上午12:28
 *
 * @author Z
 */
object Codegen {

  def main(args: Array[String]): Unit = {
    val dataSource = new HikariDataSource()
    dataSource.setJdbcUrl("jdbc:mysql://192.168.31.110:3306/gulimall_admin?characterEncoding=utf-8")
    dataSource.setUsername("root")
    dataSource.setPassword("123456")

    val generator = new Generator(dataSource, createGlobalConfig())

    generator.generate()

  }

  private def createGlobalConfig(): GlobalConfig = {
    //创建配置内容
    val globalConfig = new GlobalConfig()
    //设置根包
    globalConfig.setSourceDir("flex-codegen/src/main/java")
    globalConfig.setEntityPackage("cn.gulimall.demo.model.po")
    //设置表前缀和只生成哪些表
    globalConfig.setTablePrefix("")
    globalConfig.setGenerateTable("sys_user")

    //设置生成 entity 并启用 Lombok
    globalConfig.setEntityGenerateEnable(true)
    globalConfig.setEntityWithLombok(true)
    //设置生成 tableDef
    globalConfig.setTableDefGenerateEnable(true)
    globalConfig.setTableDefPackage("cn.gulimall.demo.model.po.table")

    globalConfig.setAuthor("Z")

    //设置项目的JDK版本，项目的JDK为14及以上时建议设置该项，小于14则可以不设置
    globalConfig.setEntityJdkVersion(21)

    //设置生成 mapper
    globalConfig.setMapperGenerateEnable(false)

    globalConfig
  }

}
