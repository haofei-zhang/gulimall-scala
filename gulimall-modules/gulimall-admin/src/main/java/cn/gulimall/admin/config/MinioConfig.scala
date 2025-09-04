package cn.gulimall.admin.config

import io.minio.MinioClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.{Bean, Configuration}

/**
 *
 * @author Z
 * @since 2024/7/11 下午11:38
 */
@Configuration
class MinioConfig(@Value("${minio.endpoint}") endpoint: String,
                  @Value("${minio.accessKey}") accessKey: String,
                  @Value("${minio.secretKey}") secretKey: String) {


  @Bean
  def minioClient(): MinioClient = {
    MinioClient.builder().endpoint(endpoint).credentials(accessKey, secretKey).build()
  }

}
