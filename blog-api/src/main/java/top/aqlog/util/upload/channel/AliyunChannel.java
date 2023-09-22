package top.aqlog.util.upload.channel;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import top.aqlog.config.properties.AliyunProperties;
import top.aqlog.util.upload.UploadUtils;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author anqin
 * @date 2022/10/6 17:16
 * @title ABlog
 * @describe
 */
@Lazy
@Component
public class AliyunChannel implements FileUploadChannel {

    @Autowired
    private OSS ossClient;
    @Autowired
    private AliyunProperties aliyunProperties;

    /**
     * 将图像上传到OSS 并返回CDN链接
     *
     * @param image 需要保存的图片
     */
    @Override
    public String upload(UploadUtils.ImageResource image) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss.SSS");
        String format = df.format(new Date());
        String fileName = aliyunProperties.getPath() + format + "-" + RandomStringUtils.randomAlphanumeric(4) + "." + image.getType();
        // 创建 putObjectRequest 实例
        PutObjectRequest putObjectRequest = new PutObjectRequest(
                aliyunProperties.getBucketName(),
                fileName,
                new ByteArrayInputStream(image.getData()));
        ossClient.putObject(putObjectRequest);

        // 100年的过期时间
        Date expiration = new Date(System.currentTimeMillis() + (3600L * 1000 * 24 * 365 * 10) * 100);
        // 生成Url
        URL url = ossClient.generatePresignedUrl(aliyunProperties.getBucketName(), fileName, expiration);

        return url.toString();
    }
}
