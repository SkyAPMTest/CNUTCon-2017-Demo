package org.skywalking.apm.cnutcon.liveshow.projecta.service;

import io.opentracing.ActiveSpan;
import io.opentracing.Tracer;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skywalking.apm.cnutcon.liveshow.projecta.trace.TracerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetService {

    private Logger logger = LogManager.getLogger(GreetService.class);

    public void sayHello(String name) throws SQLException {
        Tracer tracer = TracerFactory.getTracer();

        ActiveSpan span = tracer.buildSpan("GreetService/sayHello/" + name).startActive();

        String remoteResponse = new RestTemplate().getForObject("http://localhost:18081/project-B/remote/" + name, String.class);
        logger.info("remote response: {}", remoteResponse);

        span.deactivate();
    }
}
