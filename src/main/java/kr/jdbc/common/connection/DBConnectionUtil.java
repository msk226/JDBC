package kr.jdbc.common.connection;

import static kr.jdbc.common.connection.ConnectionConst.PASSWORD;
import static kr.jdbc.common.connection.ConnectionConst.URL;
import static kr.jdbc.common.connection.ConnectionConst.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBConnectionUtil {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
