package cn.fuxme.app.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/3/26
 **/
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class AppAccount {
    public static void main(String[] args) {
        SpringApplication.run(AppAccount.class, args);
    }
}
