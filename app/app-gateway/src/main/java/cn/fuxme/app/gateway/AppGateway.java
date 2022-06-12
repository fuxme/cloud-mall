package cn.fuxme.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/5/11
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AppGateway {

    public static void main(String[] args) {
        SpringApplication.run(AppGateway.class, args);
    }

}
