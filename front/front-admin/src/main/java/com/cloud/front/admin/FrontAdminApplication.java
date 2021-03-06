package com.cloud.front.admin;

//import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.cloud", exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients("com.cloud")
//@EnableAutoDataSourceProxy
@Slf4j
public class FrontAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontAdminApplication.class, args);
        log.info("front-admin 统一后台接口服务启动成功");
    }

}
