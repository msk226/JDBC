package kr.jdbc.repository;

import static kr.jdbc.common.connection.ConnectionConst.PASSWORD;
import static kr.jdbc.common.connection.ConnectionConst.URL;
import static kr.jdbc.common.connection.ConnectionConst.USERNAME;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.SQLException;
import kr.jdbc.common.connection.ConnectionConst;
import kr.jdbc.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.support.JdbcUtils;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 repository;

    @BeforeEach
    void beforeEach() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        repository = new MemberRepositoryV1(dataSource);
    }

    @Test
    void crud() throws SQLException {
        log.info("start");

        Member member = new Member("memberV1", 10_000);
        Member save = repository.save(member);

        Member byId = repository.findById(member.getMemberId());
        assertThat(save).isNotNull();
        assertThat(save.getMemberId()).isEqualTo(byId.getMemberId());
    }


}