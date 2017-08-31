package org.skywalking.apm.cnutcon.liveshow.projecta.service;

import io.opentracing.ActiveSpan;
import io.opentracing.NoopTracerFactory;
import io.opentracing.Tracer;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skywalking.apm.cnutcon.liveshow.projecta.dao.GreetDao;
import org.skywalking.apm.toolkit.opentracing.SkywalkingTracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetService {

    private Logger logger = LogManager.getLogger(GreetService.class);

    @Autowired
    private GreetDao greetDao;

    public void sayHello(String name) throws SQLException {
        Tracer tracer = new SkywalkingTracer();

        ActiveSpan span = tracer.buildSpan("GreetService/sayHello/" + name).startActive();
        greetDao.saveUser(name);

        String remoteResponse = new RestTemplate().getForObject("http://localhost:18080/project-B/remote/" + name, String.class);
        logger.info("remote response: {}", remoteResponse);

        span.deactivate();
    }
}
