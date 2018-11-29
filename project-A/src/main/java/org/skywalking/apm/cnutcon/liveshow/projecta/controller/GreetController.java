package org.skywalking.apm.cnutcon.liveshow.projecta.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.skywalking.apm.cnutcon.liveshow.projecta.service.GreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetController {

    @Autowired
    private GreetService greetService;

    @RequestMapping("/hello")
    public String helloWorld(
        @RequestParam(value = "name", required = false) String name,
        HttpServletRequest request) throws InterruptedException, SQLException {
        greetService.sayHello(name);

        request.setAttribute("globalTraceId", TraceContext.traceId());
        return "/helloHtml";
    }
}
