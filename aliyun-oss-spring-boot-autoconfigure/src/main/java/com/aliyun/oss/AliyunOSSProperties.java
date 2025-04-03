package com.aliyun.oss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSProperties {
    private String endPoint;
    private String bucketName;
    private String region;
}
