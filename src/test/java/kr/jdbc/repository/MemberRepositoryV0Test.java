package kr.jdbc.repository;

import java.sql.SQLException;
import kr.jdbc.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 memberRepository = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        Member member = new Member("memberV0", 10_000);
        memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getMemberId());
        log.info("findMember = {}", member);
        Assertions.assertThat(findMember).isEqualTo(member);
    }

}