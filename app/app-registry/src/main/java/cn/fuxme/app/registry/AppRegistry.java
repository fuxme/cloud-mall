package cn.fuxme.app.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/5/23
 **/
@SpringBootApplication
@EnableEurekaServer
public class AppRegistry {

    public static void main(String[] args) {
        SpringApplication.run(AppRegistry.class, args);
    }
}
