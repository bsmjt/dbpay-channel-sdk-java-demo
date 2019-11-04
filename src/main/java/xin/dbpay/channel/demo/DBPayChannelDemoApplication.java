package xin.dbpay.channel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"xin.dbpay.channel.demo.service"})
public class DBPayChannelDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DBPayChannelDemoApplication.class, args);
    }

}
