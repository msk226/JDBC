package kr.jdbc.connection;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import kr.jdbc.common.connection.DBConnectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DBConnectionUtilsTest {

    @Test
    void connection() {
        Connection connection = DBConnectionUtil.getConnection();
        assertThat(connection).isNotNull();
    }
}
