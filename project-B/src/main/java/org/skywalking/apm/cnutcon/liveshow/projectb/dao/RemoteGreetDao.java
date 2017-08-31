package org.skywalking.apm.cnutcon.liveshow.projectb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skywalking.apm.toolkit.trace.ActiveSpan;
import org.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoteGreetDao {

    private Logger logger = LogManager.getLogger(RemoteGreetDao.class);

    @Autowired
    private DataSource dataSource;

    //@Trace
    public void saveUser(String name) {
        logger.info("save user[{}].", name);
        ActiveSpan.tag("user.name", name);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO user(name) VALUES(?)");
            preparedStatement.setString(1, name == null ? "" : name);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error("Failed to save user.", e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("Failed to release resource.", e);
            }
        }
    }

    //@Trace(operationName = "selectUser")
    public void selectUser(String name) {
        logger.info("select user[{}].", name);
        ActiveSpan.tag("user.name", name);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE name =?");
            preparedStatement.setString(1, name == null ? "" : name);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error("Failed to save user.", e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("Failed to release resource.", e);
            }
        }
    }

}
