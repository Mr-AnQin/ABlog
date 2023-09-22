package top.aqlog.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * grafana prometheus（普罗米修斯） 监控 配置
 *
 * @author Mr.An
 * @date 2023-09-06 22:49:13
 */
@Configuration
public class PrometheusWebConfig {

    /**
     * 该Bean 是 本应用向 prometheus（普罗米修斯） 额外添加 applicationName
     *
     * @param applicationName 应用名称
     * @return {@link MeterRegistryCustomizer}<{@link MeterRegistry}>
     */
    @Bean
    MeterRegistryCustomizer<MeterRegistry> configuration(
            @Value("${spring.application.name}") String applicationName) {
        return (i) -> i.config().commonTags("application", applicationName);
    }
}
