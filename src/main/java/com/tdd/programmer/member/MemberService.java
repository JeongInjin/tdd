package com.tdd.programmer.member;

import com.tdd.programmer.domain.Member;
import com.tdd.programmer.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newstudy);

    void notify(Member member);
}
