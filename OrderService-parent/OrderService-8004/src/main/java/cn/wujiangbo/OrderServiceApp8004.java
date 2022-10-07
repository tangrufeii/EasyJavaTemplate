package cn.wujiangbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tangrufei
 * @date 2022-10-07 22:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceApp8004 {
      public static void main(String[] args) {
              SpringApplication.run(OrderServiceApp8004.class,args);
      }
}
