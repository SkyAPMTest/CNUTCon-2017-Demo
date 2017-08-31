package org.skywalking.apm.cnutcon.liveshow.projectb.service;

import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skywalking.apm.cnutcon.liveshow.projectb.dao.RemoteGreetDao;
import org.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteGreetService {

    private Logger logger = LogManager.getLogger(RemoteGreetService.class);

    @Autowired
    private RemoteGreetDao greetDao;

    //@Trace
    public void sayHello(String name) throws SQLException {
        greetDao.saveUser(name);
        greetDao.selectUser(name);
    }
}
