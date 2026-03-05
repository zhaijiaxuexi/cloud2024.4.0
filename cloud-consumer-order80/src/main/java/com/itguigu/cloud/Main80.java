package com.itguigu.cloud;


//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@MapperScan("com.itguigu.cloud.mapper")

//在依赖配置了mp之后，springboot会自动连接数据库。但是，这个模块不需要配置数据库。
//所以，这里要写exclude语句，告诉springboot，这个模块不需要连接数据库。
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient // 开启服务发现
public class Main80 {
    public static void main(String[] args) {
        SpringApplication.run(Main80.class,args);
    }
}
