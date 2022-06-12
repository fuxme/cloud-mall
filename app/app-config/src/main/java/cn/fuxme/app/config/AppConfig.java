package cn.fuxme.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/5/24
 **/
@SpringBootApplication
@EnableConfigServer
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}
