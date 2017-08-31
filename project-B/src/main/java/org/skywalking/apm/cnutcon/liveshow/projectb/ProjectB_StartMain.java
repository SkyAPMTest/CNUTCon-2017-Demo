package org.skywalking.apm.cnutcon.liveshow.projectb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("org.skywalking.apm.cnutcon.liveshow.projectb")
public class ProjectB_StartMain {

    public static void main(String[] args) {
        SpringApplication.run(ProjectB_StartMain.class, args);
    }
}
