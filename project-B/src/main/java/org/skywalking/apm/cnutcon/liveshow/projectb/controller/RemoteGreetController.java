package org.skywalking.apm.cnutcon.liveshow.projectb.controller;

import java.sql.SQLException;
import org.skywalking.apm.cnutcon.liveshow.projectb.service.RemoteGreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RemoteGreetController {

    @Autowired
    private RemoteGreetService greetService;

    @GetMapping("/remote/{name}")
    public String helloWorld(
        @PathVariable(value = "name", required = false) String name) throws InterruptedException, SQLException {
        greetService.sayHello(name);
        return "{status: 'success'}";
    }
}
