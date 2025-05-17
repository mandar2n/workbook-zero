package com.umc.workbook_zero.repository.MemberRepository;

import com.umc.workbook_zero.domain.Member;

public interface MemberRepositoryCustom {
    Member findMemberbyId(Long memberId);
}

