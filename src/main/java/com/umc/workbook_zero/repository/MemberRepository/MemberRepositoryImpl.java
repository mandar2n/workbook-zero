package com.umc.workbook_zero.repository.MemberRepository;

import com.umc.workbook_zero.apiPayload.code.status.ErrorStatus;
import com.umc.workbook_zero.apiPayload.exception.MemberException;
import com.umc.workbook_zero.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final EntityManager em;

    @Override
    public Member findMemberbyId(Long memberId) {
        Member member = em.find(Member.class, memberId);
        if (member == null) {
            throw new MemberException(ErrorStatus.MEMBER_NOT_FOUND);
        }
        return member;
    }
}

