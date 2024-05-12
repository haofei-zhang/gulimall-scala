package cn.gulimall.demo.model.po

/**
 *
 * @author Z
 */
case class SysUser(id: Long,
                   username: String,
                   password: String,
                   salt: String,
                   email: String,
                   mobile: String,
                   status: String,
                   createUserId: Long,
                   createTime: String)
