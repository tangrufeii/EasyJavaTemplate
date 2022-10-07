package cn.trf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * @author tangrufei
 * @date 2022-10-07 20:24
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class zuulApp8882 {
      public static void main(String[] args) {
              SpringApplication.run(zuulApp8882.class,args);
          }
}
