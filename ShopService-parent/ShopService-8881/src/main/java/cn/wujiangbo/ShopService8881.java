package cn.wujiangbo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author tangrufei
 * @date 2022-10-07 18:31
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("cn.wujiangbo.feign")
public class ShopService8881 {
      public static void main(String[] args) {
              SpringApplication.run(ShopService8881.class,args);
          }
}
