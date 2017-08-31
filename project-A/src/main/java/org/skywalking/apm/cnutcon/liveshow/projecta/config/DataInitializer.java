package org.skywalking.apm.cnutcon.liveshow.projecta.config;

import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private Logger logger = LogManager.getLogger(DataInitializer.class);

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... strings) throws Exception {
        logger.info("initialize data schema ....");
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE IF EXISTS `user`");
        statement.execute("CREATE TABLE `user` (\n" +
            "  `id`   INT(20)     NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(50) NOT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ");");

        statement.close();
        connection.close();
        logger.info("initialize data schema finished");
    }
}
