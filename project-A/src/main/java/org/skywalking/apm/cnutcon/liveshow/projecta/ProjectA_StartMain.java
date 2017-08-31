package org.skywalking.apm.cnutcon.liveshow.projecta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("org.skywalking.apm.cnutcon.liveshow.projecta")
public class ProjectA_StartMain {

    public static void main(String[] args) {
        SpringApplication.run(ProjectA_StartMain.class, args);
    }
}
