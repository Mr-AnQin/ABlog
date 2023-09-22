package top.aqlog.config.properties;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author anqin
 * @date 2022/10/6 18:11
 * @title NBlog
 * @describe
 * @ConfigurationProperties(prefix = "aliyun.oss")  获取配置文件中的信息
 */
@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "aliyun.oss.file")
public class AliyunProperties {
    /**
     * aliyunOSS 桶名称
     */
    private String bucketName;

    /**
     * aliyunOSS keyId
     */
    private String keyId;

    /**
     * keySecret
     */
    private String keySecret;

    /**
     * 存储路径
     */
    private String path;

    /**
     * 位置
     */
    private String endpoint;

    /**
     * CDN访问域名
     */
    private String domain;

    /**
     * 在Spring中创建Bean
     * @return
     */
    @Bean
    public OSS oss(){
        return new OSSClient(endpoint,keyId,keySecret);
    }
}
