package kr.jdbc.datasource;

import static kr.jdbc.common.connection.ConnectionConst.PASSWORD;
import static kr.jdbc.common.connection.ConnectionConst.URL;
import static kr.jdbc.common.connection.ConnectionConst.USERNAME;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceTest {

    private static final Logger log = LoggerFactory.getLogger(DataSourceTest.class);

    @Test
    void hikariDataSourcePool() throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        Connection connection = dataSource.getConnection();
        log.info("connection: {} ", connection);
    }
}
